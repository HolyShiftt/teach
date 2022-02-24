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
            if (new Date(exam.startTime)<new Date()){
                var total = new Date(exam.startTime)-new Date()
                var day = parseInt(total / (24*60*60));//计算整数天数

                var afterDay = total - day*24*60*60;//取得算出天数后剩余的秒数

                var hour = parseInt(afterDay/(60*60));//计算整数小时数

                var afterHour = total - day*24*60*60 - hour*60*60;//取得算出小时数后剩余的秒数

                var min = parseInt(afterHour/60);//计算整数分

                var afterMin = total - day*24*60*60 - hour*60*60 - min*60;//取得算出分后剩余的秒数
            }
            $("#examTable").append(`<div class="layui-card" style="margin-top: 20px">
                <div class="layui-card-header" style="padding:10px"><h1>` + exam.name + `</h1></div>
                <div class="layui-card-body">
                时间:` + exam.startTime + `————` + exam.endTime + `<br>
                科目:` + exam.subject + `<br>
                <button class="layui-btn">进入考试</button>
                </div>
            </div>`)
        }
    })
})
