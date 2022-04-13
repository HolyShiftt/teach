var operId;
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#myExamStu").addClass("layui-this");

    form.render();

    scoreTable = table.render({
        elem: '#scoreTable'
        , url: '/exam/myScoreList?stuId='+sessionStorage.getItem("stuId")
        , page: true
        , cols: [[
            {field: 'examSub', title: '考试科目', align: 'center'}
            , {field: 'examName', title: '考试名称', align: 'center'}
            , {field: 'score', title: '成绩', align: 'center'}
        ]]
    });

    $("#search").click(function () {
        scoreTable.reload({
            where: {
                subject:$("#subject").val(),
            }
        });
    })

})
