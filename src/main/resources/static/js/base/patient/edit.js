/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tPatient: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../patient/info?_' + $.now(),
		    	param: vm.tPatient.id,
		    	success: function(data) {
		    		vm.tPatient = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../patient/update?_' + $.now(),
		    	param: vm.tPatient,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})