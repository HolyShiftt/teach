var operId;
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table,
        transfer = layui.transfer;

    $("#myExamTeacher").addClass("layui-this");

    examTable = table.render({
        elem: '#examTable'
        , url: '/exam/examList?teacherId='+sessionStorage.getItem("id")
        , page: true
        , cols: [[
            {field: 'id', title: 'ID', sort: true, align: 'center'}
            , {field: 'name', title: '名称', align: 'center'}
            , {field: 'grade', title: '年级', align: 'center'}
            , {field: 'sclass', title: '班级', align: 'center'}
            , {field: 'startTime', title: '开始时间', align: 'center'}
            , {field: 'endTime', title: '结束时间', align: 'center'}
            , {fixed: 'right', title: '操作', align: 'center', toolbar: '#operation'}
        ]]
    });

    table.on('tool(examTable)', function (obj) {
        var data = obj.data;
        if (obj.event === 'showScoreList'){
            table.render({
                elem: '#ScoreTable'
                , url: '/exam/scoreList?id='+data.id
                , page: true
                , cols: [[
                    {field: 'stuId', title: '学号', align: 'center'}
                    , {field: 'stuName', title: '姓名', align: 'center'}
                    , {field: 'score', title: '成绩', align: 'center'}
                ]]
            });

            layer.open({
                title: '学生成绩',
                type: 1,
                area: ['40%', '80%'],
                content: $("#ScoreDiv")
            })
        }

    })


})
