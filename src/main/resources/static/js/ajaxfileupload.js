var vm = new Vue({    
    methods: {
        selectCover: function() {
            $('#cover').trigger('click');
        },
        uploadCover: function() {
            if(checkFileExt($('#cover').val(), ['jpg', 'png'])) {
                $.ajaxFileUpload({
                    url: '/mall/picture/upload',
                    type: 'post',
                    fileElementId: ['cover'],
                    dataType: 'json',
                    success: function (data, status) {
                        if(data.code=='0'){ 
                            dialogMsg(data.msg, 'success');
                        }else{
                            dialogMsg(data.msg, 'error');
                        }
                    },
                    error: function (data, status, e) {
                        dialogMsg(e, 'error')
                    }
                });
            } else {
                dialogMsg('仅支持jpg，png类型！');
            }
            $('#cover').on('change', vm.uploadCover);
        }
    }
})