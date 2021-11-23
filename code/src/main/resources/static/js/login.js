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
                if (data.success){
                    layer.msg("登录成功", {
                        time : 2000
                    }, function() {
                        window.location.href = "/index";
                    })
                }else{
                    layer.msg("用户名或密码错误");
                    layer.closeAll('loading');
                }
            }
        });
        return false;
    })



})
