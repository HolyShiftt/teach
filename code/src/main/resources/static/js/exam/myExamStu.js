var operId;
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#myExamStu").addClass("layui-this");

    form.render();

    // table.render({
    //     elem: '#noticeTable'
    //     , url: '/notice/noticeList'
    //     , page: true
    //     , cols: [[
    //         {field: 'title', title: '考试名称', align: 'center'}
    //         , {field: 'createTime', title: '完成时间', align: 'center'}
    //         , {field: '', title: '成绩', align: 'center'}
    //     ]]
    // });

})
