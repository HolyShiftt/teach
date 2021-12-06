layui.use(['layer','element'], function() {
    var $ = layui.jquery,
        element = layui.element,
        form = layui.form,
        layer = layui.layer;

    form.on('submit(loginIn)',function (data) {
        layer.load();
        $.ajax("/login", {
            method:'post',
            data:data.field,
            success : function(data) {
                if (data.code === 1){
                    sessionStorage.setItem("realName",data.msg);
                    layer.msg("登录成功，当前登录用户："+data.msg, {
                        time : 2000
                    }, function() {
                        window.location.href = "/";
                    })
                }else{
                    layer.msg(data.msg);
                    layer.closeAll('loading');
                }
            }
        });
        return false;
    })



})
