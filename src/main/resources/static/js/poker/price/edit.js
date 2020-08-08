/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		wpStrategyPrice: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../poker/price/info?_' + $.now(),
		    	param: vm.wpStrategyPrice.id,
		    	success: function(data) {
		    		vm.wpStrategyPrice = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../poker/price/update?_' + $.now(),
		    	param: vm.wpStrategyPrice,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})