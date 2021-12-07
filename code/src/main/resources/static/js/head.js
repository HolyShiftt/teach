layui.use(['layer', 'element'], function () {
    var $ = layui.jquery,
        layer = layui.layer;

    // 右上角显示用户名
    $("#realName").text(sessionStorage.getItem("realName"))

    // 根据角色判断添加的菜单
    if (sessionStorage.getItem("role") == 1){
        $("#headBar").append("<li class='layui-nav-item layui-hide-xs' id='user'><a href='user'>用户管理</a></li>")
    }

    // 注销
    $("#out").click(function () {
        layer.confirm("你确定要注销账户？", function (index) {
            layer.load();
            $.post("/out", function (d) {
                if (d.code === 1) {
                    sessionStorage.clear();
                    layer.msg("注销成功", {
                        icon: 6,
                        time: 2000
                    }, function () {
                        window.location.href = "/";
                    })
                }
            })
        })
    })


})
