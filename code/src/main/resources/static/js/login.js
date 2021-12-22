layui.use(['layer', 'element'], function () {
    var $ = layui.jquery,
        element = layui.element,
        form = layui.form,
        layer = layui.layer;

    // 登录按钮
    form.on('submit(stuLoginIn)', function (data) {
        layer.load();
        $.post("/stuLogin", {username: data.field.username, password: data.field.password}, function (data) {
            console.log(data)
            if (data.code === 1) {
                sessionStorage.setItem("realName", data.msg.realName);
                sessionStorage.setItem("username", data.msg.username);
                sessionStorage.setItem("id", data.msg.id);
                sessionStorage.setItem("role",data.msg.role)
                sessionStorage.setItem("grade",data.msg.grade)
                layer.msg("登录成功，当前登录用户：" + data.msg.realName, {
                    time: 2000
                }, function () {
                    window.location.href = "/";
                })
            } else {
                layer.msg(data.msg);
                layer.closeAll('loading');
            }
        });
        return false;
    })


})
