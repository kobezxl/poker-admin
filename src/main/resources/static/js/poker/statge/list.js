/**
 * 策略包js
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
		url: '../../poker/statge/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
	/*	    {field : "poolType", title : "底池类型:1单次底池，2. 3bet底池，3. 4bet底池", width : "100px"},
			{field : "type", title : "类型:1.单挑， 2.6人桌，3.8人桌", width : "100px"},*/
            {field : "name", title : "策略包名", width : "100px"},
            {title: '底池类型', field: 'poolType', align: 'center', valign: 'middle', width: '60px', formatter: function(item, index){
                    if(item.poolType = 1){
                        return '<span class="">单次底池</span>';
                    }
                    if(item.poolType = 2){
                        return '<span class="">3bet底池</span>';
                    }
                    if(item.poolType = 3){
                        return '<span class="">4bet底池</span>';
                    }
                }},
            {title: '类型', field: 'type', align: 'center', valign: 'middle', width: '60px', formatter: function(item, index){
                    if(item.type = 1){
                        return '<span class="">单挑</span>';
                    }
                    if(item.type = 2){
                        return '<span class="">六人桌</span>';
                    }
                    if(item.type = 3){
                        return '<span class="">八人桌</span>';
                    }
                }}

            /*	{field : "price", title : "价格", width : "100px"},
                {field : "dayCount", title : "天数:-1代表永久", width : "100px"},*/
            /*{title: '天数', field: 'dayCount', align: 'center', valign: 'middle', width: '60px', formatter: function(item, index){
                    if(item.dayCount === 1){
                        return '<span class="label label-primary">单挑</span>';
                    }
                    if(item.type === 2){
                        return '<span class="label label-success">六人桌</span>';
                    }
                    if(item.type === 3){
                        return '<span class="label label-warning">八人桌</span>';
                    }
                }},*/
			// {field : "sort", title : "排序", width : "100px"},
			// {field : "createTime", title : "创建时间", width : "100px"},
			// {field : "updateTime", title : "创建时间", width : "100px"}
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
				title: '新增策略包',
				url: 'poker/statge/add.html?_' + $.now(),
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
					title: '编辑策略包',
					url: 'poker/statge/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.wpStrate.id = ck[0].id;
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
					url: '../../poker//remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})