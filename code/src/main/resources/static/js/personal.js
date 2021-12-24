layui.use(['layer'], function () {
    var $ = layui.jquery,
        layer = layui.layer;

    $("#personal").addClass("layui-this")
    var username = sessionStorage.getItem("username");
    var role = sessionStorage.getItem("role");

    // 初始化个人信息表格
    $.post("user/personalInfo",{"username":username, "role":role}, function (d) {
        var user = d.msg;
        $("#name").text(user.realName)
        $("#sex").text(user.sex)
        $("#age").text(user.age)
        $("#birth").text(user.birth)
        $("#nation").text(user.nation)
        $("#phone").text(user.phone)
        $("#politics").text(user.politics)
        $("#mail").text(user.mail)
        $("#picture").attr("src",user.picture)
    })

    // 修改密码按钮
    $("#updatePwd").click(function (data) {
        layer.open({
            title : '修改密码',
            type : 2,
            area : [ '20%', '40%' ],
            content : "/updatePwd"
        })
    })

})
