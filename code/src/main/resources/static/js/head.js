layui.use(['layer', 'element'], function () {
    var $ = layui.jquery,
        layer = layui.layer;

    if (!sessionStorage.getItem("realName")){
        window.location.href = "/login";
    }
    // 右上角显示用户名
    $("#realName").text(sessionStorage.getItem("realName"))

    $("#headBar").append("<li class='layui-nav-item layui-show-xs-inline-block layui-hide-sm' lay-header-event='menuLeft'> <i class='layui-icon layui-icon-spread-left\'></i></li>")

    // 根据角色判断添加的菜单
    if (sessionStorage.getItem("role") == 1) {
        $("#headBar").append("<li class='layui-nav-item layui-hide-xs' id='personal'><a href='personal'>个人信息</a></li>" +
            "<li class='layui-nav-item layui-hide-xs' id='courseManage'><a href='course'>课程表管理</a></li>" +
            "<li class='layui-nav-item layui-hide-xs' id='notice'><a href='notice'>公告通知</a></li>" +
            "<li class='layui-nav-item layui-hide-xs' id='chat'><a href='chat'>聊天室</a></li>"+
            "<li class='layui-nav-item layui-hide-xs' id='question'><a href='question'>题库</a></li>"+
            "<li class='layui-nav-item layui-hide-xs' id='examTeacher'><a href='examTeacher'>发布考试</a></li>"+
            "<li class='layui-nav-item layui-hide-xs' id='examStu'><a href='examStu'>我的考试</a></li>"+
            "</li><li class='layui-nav-item layui-hide-xs' id='user'><a href='user'>用户管理</a></li>");
    }else if (sessionStorage.getItem("role") == 2) {
        $("#headBar").append("<li class='layui-nav-item layui-hide-xs' id='personal'><a href='personal'>个人信息</a></li>" +
            "<li class='layui-nav-item layui-hide-xs' id='question'><a href='question'>题库</a></li>"+
            "<li class='layui-nav-item layui-hide-xs' id='examTeacher'><a href='examTeacher'>发布考试</a></li>"+
            "<li class='layui-nav-item layui-hide-xs' id='myExamTeacher'><a href='myExamTeacher'>我的考试</a></li>"+
            "</li><li class='layui-nav-item layui-hide-xs' id='chat'><a href='chat'>聊天室</a></li>");
    }else if (sessionStorage.getItem("role") == 3) {
        $("#headBar").append("<li class='layui-nav-item layui-hide-xs' id='personal'><a href='personal'>个人信息</a></li>" +
            "<li class='layui-nav-item layui-hide-xs' id='examStudent'><a href='examStudent'>查看考试</a></li>"+
            "<li class='layui-nav-item layui-hide-xs' id='myExamStu'><a href='myExamStu'>我的考试</a></li>"+
            "</li><li class='layui-nav-item layui-hide-xs' id='chat'><a href='chat'>聊天室</a></li>");
    }else if (sessionStorage.getItem("role") == 4) {
        $("#headBar").append("<li class='layui-nav-item layui-hide-xs' id='personal'><a href='personal'>个人信息</a></li>" +
            "<li class='layui-nav-item layui-hide-xs' id='examStudent'><a href='examStudent'>查看考试</a></li>"+
            "<li class='layui-nav-item layui-hide-xs' id='myExamStu'><a href='myExamStu'>我的考试</a></li>"+
            "</li><li class='layui-nav-item layui-hide-xs' id='chat'><a href='chat'>聊天室</a></li>");
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
                        window.location.href = "/login";
                    })
                }
            })
        })
    })


})
