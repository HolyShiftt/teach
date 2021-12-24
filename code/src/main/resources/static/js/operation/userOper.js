layui.use(['layer', 'form', 'laydate'], function () {
    var $ = layui.$
        , layer = layui.layer
        , form = layui.form;

    //角色下拉列表
    $.ajax({
        url:'/role/roleList',
        async : false,
        success : function(d) {
            $.each(d, function (index, item) {
                $('#role').append(new Option(item.roleName, item.id));
            });
        }
    });
    if (parent.operId !== 0){
        // 获取该行数据
        $.ajax('/user/userInfo', {
            async : false,
            data : {
                id : parent.operId
            },
            success : function(d) {
                form.val("userForm", d);
                $("#role").val(d.role);
            }
        });
    }
    form.render();


    form.on('submit(submit)', function (data) {
        layer.load();
        var url;
        if (parent.operId===0){
            $("#id").val('')
            url = '/user/userAdd'
        }else{
            $("#id").val(parent.operId)
            url = '/user/userUpd'
        }
        $.ajax({
            url: url,
            data: $("#userForm").serialize(),
            success: function (d) {
                if (d.code) {
                    layer.msg(d.msg, {
                        icon: 6,
                        time: 2000
                    }, function () {
                        parent.layer.close(parent.layer.getFrameIndex(window.name))
                        parent.userTable.reload();
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
