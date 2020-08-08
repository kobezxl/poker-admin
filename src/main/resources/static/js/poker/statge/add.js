/**
 * 新增-策略包js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		wpStrate: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../poker/statge/save?_' + $.now(),
		    	param: vm.wpStrate,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
