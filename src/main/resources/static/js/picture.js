layui.use('upload', function(){
  var $ = layui.jquery,
  upload = layui.upload;
  
  //普通图片上传
  var uploadInst = upload.render({
    elem: '#dpLTE',
    url: '../../mall/categoryItem/upload?_' + $.now(),
    before: function(obj){
      //预读本地文件示例，不支持ie8
      obj.preview(function(index, file, result){
        $('#demo1').attr('src', result); //图片链接(base64)
      });
    },
    done: function(res){
      //如果上传失败
      if(res.code > 0){
        return layer.msg('上传失败');
      }
      //上传成功
    },
    error: function(){
      //演示失败状态，并实现重传
      var demoText = $('#demoText');
      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
      demoText.find('.demo-reload').on('click', function(){
        uploadInst.upload();
      });
    }
  });
  
  //设定文件大小限制
  upload.render({
    elem: '#test7'
    ,url: '/upload/'
    ,size: 60 //限制文件大小，单位 KB
    ,done: function(res){
      console.log(res)
    }
  });
  
  
  //选完文件后不自动上传
  upload.render({
    elem: '#test8',
    url: '/upload/',
    auto: false,
    //,multiple: true,
    bindAction: '#test9',
    done: function(res){
      console.log(res)
    }
  });
  
  
});