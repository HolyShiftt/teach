layui.use(['layer', 'element'], function () {
    var $ = layui.jquery,
        layer = layui.layer;

    // 右上角显示用户名
    $("#realName").text(sessionStorage.getItem("realName"))

    $("#headBar").append("<li class='layui-nav-item layui-show-xs-inline-block layui-hide-sm' lay-header-event='menuLeft'> <i class='layui-icon layui-icon-spread-left\'></i></li>")

    // 根据角色判断添加的菜单
    if (sessionStorage.getItem("role") == 1) {
        $("#headBar").append("<li class='layui-nav-item layui-hide-xs' id='personal'><a href='personal'>个人信息</a></li>" +
            "<li class='layui-nav-item layui-hide-xs' id='work'><a href='work'>我的题库</a></li>" +
            "<li class='layui-nav-item'><a href='javascript:;'>我的考试</a>" +
            "<dl class='layui-nav-child'>" +
            "<dd><a href=''>考试安排</a></dd>" +
            "<dd><a href=''>历史考试</a></dd>" +
            "</dl>" +
            "</li><li class='layui-nav-item layui-hide-xs' id='user'><a href='user'>用户管理</a></li>");
    }else if (sessionStorage.getItem("role") == 2) {
        $("#headBar").append("<li class='layui-nav-item layui-hide-xs' id='personal'><a href='personal'>个人信息</a></li>" +
            "</li><li class='layui-nav-item layui-hide-xs' id='user'><a href='user'>用户管理</a></li>");
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
