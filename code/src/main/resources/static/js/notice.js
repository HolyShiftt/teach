layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#notice").addClass("layui-this");

    form.render();

    table.render({
        elem: '#noticeTable'
        , url: '/notice/noticeList'
        , page: true
        , cols: [[
            {field: 'title', title: '标题', align: 'center'}
            , {field: 'index', title: '内容', align: 'center'}
            , {field: 'createTime', title: '创建时间', align: 'center'}
            ,
        ]]
    });
    //
    //
    // $("#search").click(function () {
    //     courseTable.reload({
    //         where: {
    //             grade:$("#grade").val(),
    //             sClass:$("#sClass").val()
    //         }
    //     });
    // })
})
