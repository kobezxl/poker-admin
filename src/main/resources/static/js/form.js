$.SaveForm = function (options) {
    var defaults = {
        url: "",
        param: {},
        type: "post",
        dataType: "json",
        contentType: 'application/json',
        success: null,
        close: true
    };
    var options = $.extend(defaults, options);
    dialogLoading(true);
    window.setTimeout(function () {
        $.ajax({
            url: options.url,
            data: JSON.stringify(options.param),
            type: options.type,
            dataType: options.dataType,
            contentType: options.contentType,
            success: function (data) {
                if (data.code == '500') {
                    dialogAlert(data.msg, 'error');
                } else if (data.code == '0') {
                    options.success(data);
                    dialogMsg(data.msg, 'success');
                    if (options.close == true) {
                        dialogClose();
                    }
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                dialogLoading(false);
                if (XMLHttpRequest.responseJSON.code == 401) {
                    toUrl('login.html');
                } else if (textStatus == "error") {
                    dialogMsg("请求超时，请稍候重试...", "error");
                } else {
                    dialogMsg(errorThrown, 'error');
                }
            },
            beforeSend: function () {
                dialogLoading(true);
            },
            complete: function () {
                dialogLoading(false);
            }
        });
    }, 500);
}

$.RemoveForm = function (options) {
    var defaults = {
        msg: "注：您确定要删除吗？该操作将无法恢复",
        url: "",
        param: [],
        type: "post",
        dataType: "json",
        contentType: 'application/json',
        success: null
    };
    var options = $.extend(defaults, options);
    dialogConfirm(options.msg, function () {
        dialogLoading(true);
        window.setTimeout(function () {
            var postdata = options.param;
            $.ajax({
                url: options.url,
                data: JSON.stringify(postdata),
                type: options.type,
                dataType: options.dataType,
                contentType: options.contentType,
                success: function (data) {
                    if (data.code == '500') {
                        dialogAlert(data.msg, 'error');
                    } else if (data.code == '0') {

                        dialogMsg(data.msg, 'success');
                        options.success(data);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    dialogLoading(false);
                    if (XMLHttpRequest.responseJSON.code == 401) {
                        toUrl('login.html');
                    } else if (textStatus == "error") {
                        dialogMsg("请求超时，请稍候重试...", "error");
                    } else {
                        dialogMsg(errorThrown, 'error');
                    }
                },
                beforeSend: function () {
                    dialogLoading(true);
                },
                complete: function () {
                    dialogLoading(false);
                }
            });
        }, 500);
    });
}

$.SetForm = function (options) {
    var defaults = {
        url: "",
        param: {},
        type: "post",
        dataType: "json",
        contentType: 'application/json',
        success: null
    };
    var options = $.extend(defaults, options);
    $.ajax({
        url: options.url,
        data: JSON.stringify(options.param),
        type: options.type,
        dataType: options.dataType,
        contentType: options.contentType,
        success: function (data) {
            if (data.code == '500') {
                dialogAlert(data.msg, 'error');
            } else if (data.code == '0') {
                options.success(data.rows);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            dialogLoading(false);
            if (XMLHttpRequest.responseJSON.code == 401) {
                toUrl('login.html');
            } else if (textStatus == "error") {
                dialogMsg("请求超时，请稍候重试...", "error");
            } else {
                dialogMsg(errorThrown, 'error');
            }
        },
        beforeSend: function () {
            dialogLoading(true);
        },
        complete: function () {
            dialogLoading(false);
        }
    });
}

$.ConfirmForm = function (options) {
    var defaults = {
        msg: "您确定要保存当前数据项修改操作吗？",
        url: "",
        param: {},
        type: "post",
        dataType: "json",
        contentType: 'application/json',
        success: null,
        close: true
    };
    var options = $.extend(defaults, options);
    dialogConfirm(options.msg, function () {
        $.SaveForm(options);
    });
}

$.ConfirmAjax = function (options) {
    var defaults = {
        msg: "您确定要保存当前操作结果吗？",
        url: "",
        param: {},
        type: "post",
        dataType: "json",
        contentType: options.contentType,
        success: null,
        close: true
    };
    var options = $.extend(defaults, options);
    dialogConfirm(options.msg, function () {
        dialogLoading(true);
        window.setTimeout(function () {
            var postdata = options.param;
            $.ajax({
                url: options.url,
                data: JSON.stringify(postdata),
                type: options.type,
                dataType: options.dataType,
                contentType: options.contentType,
                success: function (data) {
                    if (data.code == '500') {
                        dialogAlert(data.msg, 'error');
                    } else if (data.code == '0') {
                        dialogMsg(data.msg, 'success');
                        options.success(data);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    dialogLoading(false);
                    if (XMLHttpRequest.responseJSON.code == 401) {
                        toUrl('login.html');
                    } else if (textStatus == "error") {
                        dialogMsg("请求超时，请稍候重试...", "error");
                    } else {
                        dialogMsg(errorThrown, 'error');
                    }
                },
                beforeSend: function () {
                    dialogLoading(true);
                },
                complete: function () {
                    dialogLoading(false);
                }
            });
        }, 500);
    });
}

$.uploadImg = function (options) {
    var form = new FormData();
    var defaults = {
        url: "",
        param: form,
        type: "post",
        dataType: "json",
        contentType: false,
        success: null,
        close: false
    };
    var options = $.extend(defaults, options);
    if (options.param) {
        for (var key in options.param) {
            form.append(key, options.param[key]);
        }
        options.param = form;
    }

    dialogLoading(true);
    window.setTimeout(function () {
        $.ajax({
            url: options.url,
            data: options.param,
            type: options.type,
            dataType: options.dataType,
            contentType: options.contentType,
            processData: false,
            success: function (data) {
                if (data.code == '500') {
                    dialogAlert(data.msg, 'error');
                } else if (data.code == '0') {
                    options.success(data);
                    dialogMsg('图片上传成功', 'success');
                    if (options.close == true) {
                        dialogClose();
                    }
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                dialogLoading(false);
                if (XMLHttpRequest.responseJSON.code == 401) {
                    toUrl('login.html');
                } else if (textStatus == "error") {
                    dialogMsg("请求超时，请稍候重试...", "error");
                } else {
                    dialogMsg(errorThrown, 'error');
                }
            },
            beforeSend: function () {
                dialogLoading(true);
            },
            complete: function () {
                dialogLoading(false);
            }
        });
    }, 500);
}
