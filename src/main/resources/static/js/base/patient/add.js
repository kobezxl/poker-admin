/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tPatient: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../patient/save?_' + $.now(),
		    	param: vm.tPatient,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
