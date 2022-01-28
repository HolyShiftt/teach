layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#exam").addClass("layui-this");

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
})
