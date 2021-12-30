var pic;
layui.use(['layer', 'form', 'laydate','upload','element'], function () {
    var $ = layui.$
        , layer = layui.layer
        , form = layui.form
        , upload = layui.upload
        , element = layui.element;
    personal = parent.personal;

    //表单数据回显
    form.val("userForm", {
        "realName": personal.realName
        ,"sex":personal.sex
        ,"age": personal.age
        ,"politics": personal.politics
        ,"birth": personal.birth
        ,"nation": personal.nation
        ,"phone": personal.phone
        ,"mail": personal.mail
        ,"picture": personal.picture
    });
    $("#id").val(sessionStorage.getItem("id"));
    $("#pic").attr("src",personal.picture)

    //图片上传
    upload.render({
        elem: '#picture'
        ,url: '/user/uploadPic'
        ,before: function(obj){
            obj.preview(function(index, file, result){
                $('#pic').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(res){
            pic = res.msg;
            $("#pictureUrl").val("data:image/jpeg;base64,"+pic)
        }
    });

    form.on('submit(submit)', function (data) {
        layer.load();
        $.ajax({
            url: "/user/updPersonal",
            data: $("#userForm").serialize(),
            success: function (d) {
                if (d.code) {
                    layer.msg(d.msg, {
                        icon: 6,
                        time: 2000
                    }, function () {
                        parent.layer.close(parent.layer.getFrameIndex(window.name))
                        parent.window.location.href = "/personal"
                    })
                } else {
                    layer.alert(d.msg)
                    layer.closeAll('loading');
                }
            },
        });
        return false;
    })

    $('#close').click(function () {
        parent.layer.close(parent.layer.getFrameIndex(window.name))
    })

})
