/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		wpStrategyDetail: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../strate/save?_' + $.now(),
		    	param: vm.wpStrategyDetail,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
