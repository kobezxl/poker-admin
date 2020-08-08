/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		wpStrategyPrice: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../poker/price/save?_' + $.now(),
		    	param: vm.wpStrategyPrice,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
