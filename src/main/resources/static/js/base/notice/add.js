/**
 * 新增-帮助问题表js
 */

var E = window.wangEditor;
// 中文编辑器
var editor1 = new E('#editor1');
editor1.customConfig.uploadImgServer = '../../sys/picture/uploadUrl';
editor1.customConfig.uploadFileName = 'file';
editor1.customConfig.uploadImgTimeout = 30000;
editor1.customConfig.uploadImgHeaders = {
    'token': localStorage.getItem('token')
}
editor1.customConfig.menus = [
    'head',  // 标题
    'bold',  // 粗体
    'fontSize',  // 字号
    'fontName',  // 字体
    'italic',  // 斜体
    'underline',  // 下划线
    'strikeThrough',  // 删除线
    'foreColor',  // 文字颜色
    'backColor',  // 背景颜色
//    'link',  // 插入链接
    'list',  // 列表
    'justify',  // 对齐方式
//    'quote',  // 引用
//    'emoticon',  // 表情
    'image',  // 插入图片
//    'table',  // 表格
//    'video',  // 插入视频
    'code',  // 插入代码
    'undo',  // 撤销
    'redo'  // 重复
]

// 英文编辑器
var editor2 = new E('#editor2');
editor2.customConfig.uploadImgServer = '../../sys/picture/uploadUrl';
editor2.customConfig.uploadFileName = 'file';
editor2.customConfig.uploadImgTimeout = 30000;
editor2.customConfig.uploadImgHeaders = {
    'token': localStorage.getItem('token')
}
editor2.customConfig.menus = [
    'head',  // 标题
    'bold',  // 粗体
    'fontSize',  // 字号
    'fontName',  // 字体
    'italic',  // 斜体
    'underline',  // 下划线
    'strikeThrough',  // 删除线
    'foreColor',  // 文字颜色
    'backColor',  // 背景颜色
//    'link',  // 插入链接
    'list',  // 列表
    'justify',  // 对齐方式
//    'quote',  // 引用
//    'emoticon',  // 表情
    'image',  // 插入图片
//    'table',  // 表格
//    'video',  // 插入视频
    'code',  // 插入代码
    'undo',  // 撤销
    'redo'  // 重复
]
var vm = new Vue({
	el:'#dpLTE',
	data: {
        tNotice: {
            state: 1,
            typeId: null,
			kinds: null
		},
	},
	mounted(){
        editor1.create();
        editor2.create();
        editor1.txt.clear();
        editor2.txt.clear();
	},

	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
            if (editor1.txt.html() === '<p><br></p>' || editor2.txt.html() === '<p><br></p>') {
                return alert("提交不能为空");
            }
            vm.tNotice.content=editor1.txt.html()
                .replace(/\</g,'&lt;')
                .replace(/\>/g,'&gt;')
                .replace(/x-small/g,'0.26666rem')//20
                .replace(/small/g,'0.32rem')//24
                .replace(/medium/g,'0.37333rem')//28
                .replace(/xx-large/g,'0.5333rem')//40
                .replace(/x-large/g,'0.48rem')//36
                .replace(/large/g,'0.42666rem')//32
                .replace(/text-decoration-line/g,'text-decoration'); // 解决删除线跟下划线，ios不支持
            // vm.tNotice.itemContent=text_content1;

            vm.tNotice.enContent=editor2.txt.html()
                .replace(/\</g,'&lt;')
                .replace(/\>/g,'&gt;')
                .replace(/x-small/g,'0.26666rem')//20
                .replace(/small/g,'0.32rem')//24
                .replace(/medium/g,'0.37333rem')//28
                .replace(/xx-large/g,'0.5333rem')//40
                .replace(/x-large/g,'0.48rem')//36
                .replace(/large/g,'0.42666rem')//32
                .replace(/text-decoration-line/g,'text-decoration'); // 解决删除线跟下划线，ios不支持
            // vm.tNotice.itemContentForeign=text_content2;
		    $.SaveForm({
		    	url: '../../notice/save?_' + $.now(),
		    	param: vm.tNotice,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
	}
})
