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
		url: '../../poker/detail/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			// {field : "userId", title : "用户id", width : "100px"},
			{field : "userLogin", title : "用户名", width : "100px"},
			{field : "userEmail", title : "邮箱", width : "100px"},
			{field : "userNicename", title : "昵称", width : "100px"},
			{field : "startDate", title : "开始时间", width : "100px"},
			{field : "endDate", title : "结束时间", width : "100px"},
		/*	{field : "poolType", title : "底池类型", width : "100px"},
			{field : "type", title : "", width : "100px"}, */
            {title: '底池类型', field: 'poolType', align: 'center', valign: 'middle', width: '60px', formatter: function(item, index){
                   console.log('池底类型:'+item)
                    if(item == 1){
                        return '<span class="">单次底池</span>';
                    }
                    if(item == 2){
                        return '<span class="">3bet底池</span>';
                    }
                    if(item == 3){
                        return '<span class="">4bet底池</span>';
                    }
                    if(item == 4){
                        return '<span class="">全部</span>';
                    }
                }},
            {title: '类型', field: 'type', align: 'center', valign: 'middle', width: '60px', formatter: function(item, index){
                   console.log("类型:"+item)
                    if(item == 1){
                        return '<span class="">单挑</span>';
                    }
                    if(item == 2){
                        return '<span class="">六人桌</span>';
                    }
                    if(item == 3){
                        return '<span class="">八人桌</span>';
                    }
                }},
			{field : "gold", title : "金币", width : "100px"},
			// {field : "typeDate", title : "", width : "100px"},

			// {field : "strategyId", title : "", width : "100px"},
			/*{field : "dayCount", title : "时长", width : "100px"}*/
            {title: '时长', field: 'dayCount', align: 'center', valign: 'middle', width: '60px', formatter: function(item, index){
                   // console.log(item)
                    if(item == -1){
                        return '<span class="label label-primary">永久</span>';
                    }
                    if(item == 30){
                        return '<span class="label label-success">30天</span>';
                    }
                    if(item == 365){
                        return '<span class="label label-warning">365天</span>';
                    }
                }},
            {field : "createDate", title : "购买时间", width : "100px"},
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
				title: '用户赠送策略包',
				url: 'poker/detail/add.html?_' + $.now(),
				width: '1000px',
				height: '600px',
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
					url: 'poker/detail/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.wpStrategyDetail.id = ck[0].id;
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
					url: '../../poker/detail/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})