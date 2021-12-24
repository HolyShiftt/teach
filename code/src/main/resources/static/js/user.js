var operId;
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#user").addClass("layui-this");

    // 角色选择
    $.ajax({
        url:'/role/roleList',
        async : false,
        success : function(d) {
            $.each(d, function (index, item) {
                $('#roleList').append(new Option(item.roleName, item.id));
            });
        }
    })

    form.render();

    userTable = table.render({
        elem: '#userTable'
        , url: '/user/userList'
        , page: true
        , cols: [[
            {field: 'id', title: 'ID', sort: true, align: 'center'}
            , {field: 'username', title: '用户名', align: 'center'}
            , {field: 'realName', title: '真实姓名', align: 'center'}
            , {field: 'phone', title: '手机号码', align: 'center'}
            , {field: 'roleName', title: '角色', align: 'center'}
            , {fixed: 'right', title: '操作', toolbar: '#operation'}
        ]]
    });

    // 搜索
    $("#search").click(function () {
        userTable.reload({
            where: {
                role:$("#roleList").val(),
                name:$("#name").val()
            }
        });
    })

    // 添加
    $("#addUser").click(function () {
        operId=0
        layer.open({
            title: '添加',
            type: 2,
            area: ['25%', '45%'],
            content: '/userOper'
        })
    })

    // 编辑和删除
    table.on('tool(userTable)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del'){
            // 删除按钮
            layer.confirm('确定要删除这个用户吗', function (index) {
                $.ajax({
                    type: "POST",
                    data: {id: data.id},
                    url: "/user/userDel",
                    success: function (d) {
                        if (d.code) {
                            layer.msg(d.msg, {time: 1000}, function () {
                                layer.closeAll();//关闭弹窗
                                userTable.reload()//保存成功刷新
                            });
                        } else {
                            layer.alert(d.msg)
                        }
                    }
                });
                layer.close(index);
            })
        }else if (obj.event === 'edit'){
            operId=data.id
            layer.open({
                title: '编辑',
                type: 2,
                area: ['25%', '45%'],
                content: '/userOper'
            })
        }
    })
})
