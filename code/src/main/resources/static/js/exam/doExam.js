layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table,
        transfer = layui.transfer;
    var stuclass = sessionStorage.getItem("class");
    var grade = sessionStorage.getItem("grade");
    var realName = sessionStorage.getItem("realName");
    $("#stuInfo1").html(realName)
    $("#stuInfo2").html(grade+"年级("+stuclass+")班")


})
