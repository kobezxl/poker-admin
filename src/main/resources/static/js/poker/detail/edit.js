/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		wpStrategyDetail: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../strate/info?_' + $.now(),
		    	param: vm.wpStrategyDetail.id,
		    	success: function(data) {
		    		vm.wpStrategyDetail = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../strate/update?_' + $.now(),
		    	param: vm.wpStrategyDetail,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})