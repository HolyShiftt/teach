var personal;
layui.use(['layer'], function () {
    var $ = layui.jquery,
        layer = layui.layer;

    $("#personal").addClass("layui-this")
    var username = sessionStorage.getItem("username");
    var role = sessionStorage.getItem("role");

    if (role == 2){
        $(".tbb").append(`<tr>
                            <td>教师编号:</td>
                            <td id="teacherId" colspan="3"></td>
                            <td>受教育程度:</td>
                            <td id="edu" colspan="3"></td></tr><tr>
                            <td>薪资:</td>
                            <td id="salary" colspan="3"></td>
                            <td>任课科目:</td>
                            <td id="subject" colspan="3"></td>
                        </tr>`)
    }
    // 初始化个人信息表格
    $.post("user/personalInfo",{"username":username, "role":role}, function (d) {
        var user = d.msg;
        personal = d.msg;
        $("#name").text(user.realName)
        $("#sex").text(user.sex)
        $("#age").text(user.age)
        $("#birth").text(user.birth)
        $("#nation").text(user.nation)
        $("#phone").text(user.phone)
        $("#politics").text(user.politics)
        $("#mail").text(user.mail)
        $("#picture").attr("src",user.picture)
        $("#teacherId").text(user.teacher.teacherId)
        $("#edu").text(user.teacher.edu)
        $("#salary").text(user.teacher.salary)
        $("#subject").text(user.teacher.subject)
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
    // 修改用户信息按钮
    $("#updatePersonal").click(function (data) {
        layer.open({
            title : '修改个人信息',
            type : 2,
            area : [ '40%', '80%' ],
            content : "/updateUser"
        })
    })

})
