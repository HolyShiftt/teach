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

    var userTable = table.render({
        elem: '#userTable'
        , url: '/user/userList'
        , page: true
        , cols: [[
            {field: 'id', title: 'ID', sort: true, align: 'center'}
            , {field: 'username', title: '用户名', align: 'center'}
            , {field: 'realName', title: '真实姓名', align: 'center'}
            , {field: 'phone', title: '手机号码', align: 'center'}
            , {field: 'roleName', title: '角色', align: 'center'}
        ]]
    });


    $("#search").click(function () {
        userTable.reload({
            where: {
                role:$("#roleList").val(),
                name:$("#name").val()
            }
        });
    })
})
