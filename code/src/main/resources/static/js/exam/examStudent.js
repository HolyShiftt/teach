var operId;
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table,
        transfer = layui.transfer;

    $("#examStudent").addClass("layui-this");
    $.get('/exam/examListStu?grade=' + sessionStorage.getItem("grade") + '&sclass=' + sessionStorage.getItem("class"), function (d) {
        for (const exam of d.data) {
            var btn;
            if (new Date(exam.endTime) >= new Date()){
                $("#examTable").append(`<div class="layui-card" style="margin-top: 20px">
                <div class="layui-card-header" style="padding:10px"><h1>` + exam.name + `</h1></div>
                <div class="layui-card-body">
                时间:` + exam.startTime + `  ——  ` + exam.endTime + `<br><br>
                <h2>科目:` + exam.subject + `</h2><br><br>
                <button class="layui-btn" onclick="toExam(`+exam.id+`)">进入考试</button>
                </div>
            </div>`)
            }

        }
    })

    window.toExam = function (id) {
        location.href="doExam?id="+id;
    }
})
