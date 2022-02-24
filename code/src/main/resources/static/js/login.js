layui.use(['layer', 'element'], function () {
    var $ = layui.jquery,
        element = layui.element,
        form = layui.form,
        layer = layui.layer;

    function login(data){
        layer.load();
        $.post("/Login", {username: data.field.username, password: data.field.password,role: data.field.role}, function (data) {
            if (data.code === 1) {
                sessionStorage.setItem("realName", data.msg.realName);
                sessionStorage.setItem("username", data.msg.username);
                sessionStorage.setItem("id", data.msg.id);
                sessionStorage.setItem("role",data.msg.role)
                if (data.msg.role == 3){
                    sessionStorage.setItem("grade",data.msg.student.stuGrade)
                    sessionStorage.setItem("class",data.msg.student.stuClass)
                }else if (data.msg.role == 2){
                    sessionStorage.setItem("subject",data.msg.teacherSubject)
                }

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
    }
    // 登录按钮
    form.on('submit(stuLoginIn)', function (data) {
        login(data)
        return false;
    })
    // 登录按钮
    form.on('submit(teacherLoginIn)', function (data) {
        login(data)
        return false;
    })
    // 登录按钮
    form.on('submit(adminLoginIn)', function (data) {
        login(data)
        return false;
    })


})
