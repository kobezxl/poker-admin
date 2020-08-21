/**
 * js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../poker/price/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "month", title : "30天价格", width : "100px"},
			{field : "year", title : "365天价格", width : "100px"},
			{field : "forver", title : "永久", width : "100px"},
			// {field : "type", title : "策略包类型1", width : "100px"},
            {title: '策略包类型', field: 'type', align: 'center', valign: 'middle', width: '60px', formatter: function(item, index){
            	console.log("策略包类型:"+item)
                    if(item == '2-0'){
                        return '<span class="">六人桌-单个</span>';
                    }
                    if(item == '2-1'){
                        return '<span class="">六人桌-单次底池</span>';
                    }
                    if(item == '2-2'){
                        return '<span class="">六人桌-3bet底池</span>';
                    }
                    if(item == '2-3'){
                        return '<span class="">六人桌-4bet底池</span>';
                    }
                    if(item == '2-4'){
                        return '<span class="">六人桌-全部</span>';
                    }
                    if(item == '3-0'){
                        return '<span class="">八人桌-单个</span>';
                    }
                    if(item == '3-1'){
                        return '<span class="">八人桌-单次底池</span>';
                    }
                    if(item == '3-2'){
                        return '<span class="">八人桌-3bet底池</span>';
                    }
                    if(item == '3-3'){
                        return '<span class="">八人桌-4bet底池</span>';
                    }
                    if(item == '3-4'){
                        return '<span class="">八人桌-全部</span>';
                    }
                }}
		]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
		keyword: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增',
				url: 'poker/price/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑',
					url: 'poker/price/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.wpStrategyPrice.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		remove: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url: '../../poker/price/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})