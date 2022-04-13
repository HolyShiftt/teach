var personal;
layui.use(['layer'], function () {
    var $ = layui.jquery,
        layer = layui.layer;

    $("#personal").addClass("layui-this")
    var username = sessionStorage.getItem("role") == 4?sessionStorage.getItem("childUname"):sessionStorage.getItem("username");
    var role = sessionStorage.getItem("role") == 4?3:sessionStorage.getItem("role");

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
    }else if (role == 3 || role==4){
        $(".tbb").append(`<tr>
                            <td>年级:</td>
                            <td id="stuGrade"></td>
                            <td>班级:</td>
                            <td id="stuClass" ></td>
                            <td>学号:</td>
                            <td id="stuId" colspan="2"></td>
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
        if (role == 2){
            $("#teacherId").text(user.teacher.teacherId)
            $("#edu").text(user.teacher.edu)
            $("#salary").text(user.teacher.salary)
            $("#subject").text(user.teacher.subject)
        }else if (role == 3){
            $("#stuGrade").text(user.student.stuGrade)
            $("#stuClass").text(user.student.stuClass)
            $("#stuId").text(user.student.stuId)
        }
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
