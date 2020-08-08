/**
 * 公告js
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
		url: '../../notice/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			// {field : "userId", title : "创建人id", width : "100px"},
			{field : "title", title : "标题", width : "100px"}, 
			{field : "content", title : "内容", width : "100px"}, 
			{field : "enTitle", title : "英文-标题", width : "100px"}, 
			{field : "enContent", title : "英文-内容", width : "100px"}, 
			{field : "state", title : "公告类型:1可用，2不可用", width : "100px"}, 
			{field : "createTime", title : "创建时间", width : "100px"}, 
			{field : "updateTime", title : "修改时间", width : "100px"}
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
				title: '新增公告',
				url: 'base/notice/add.html?_' + $.now(),
				width: '720px',
				height: '500px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑公告',
					url: 'base/notice/edit.html?_' + $.now(),
					width: '720px',
					height: '500px',
					success: function(iframeId){
						top.frames[iframeId].vm.tNotice.id = ck[0].id;
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
					url: '../../notice/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})