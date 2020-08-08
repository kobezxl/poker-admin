/**
 * 编辑-策略包js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		wpStrate: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../poker/statge/info?_' + $.now(),
		    	param: vm.wpStrate.id,
		    	success: function(data) {
		    		vm.wpStrate = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../poker/statge/update?_' + $.now(),
		    	param: vm.wpStrate,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})