layui.use(['layer', 'element'], function () {
    var $ = layui.jquery,
        element = layui.element,
        form = layui.form,
        layer = layui.layer;

    $("#realName").text(sessionStorage.getItem("realName"))

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
