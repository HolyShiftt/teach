layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#courseManage").addClass("layui-this");

    form.render();

    var courseTable = table.render({
        elem: '#courseTable'
        , url: '/course/allCourseScheduleServiceList'
        , page: true
        , cols: [[
            {field: 'grade', title: '年级', align: 'center'}
            , {field: 'sclass', title: '班级', align: 'center'}
            , {field: 'mondayCourse', title: '周一', align: 'center'}
            , {field: 'tuesdayCourse', title: '周二', align: 'center'}
            , {field: 'wednesdayCourse', title: '周三', align: 'center'}
            , {field: 'thursdayCourse', title: '周四', align: 'center'}
            , {field: 'fridayCourse', title: '周五', align: 'center'}
            , {field: 'saturdayCourse', title: '周六', align: 'center'}
            , {field: 'sundayCourse', title: '周天', align: 'center'}
            ,
        ]]
    });


    $("#search").click(function () {
        courseTable.reload({
            where: {
                grade:$("#grade").val(),
                sClass:$("#sClass").val()
            }
        });
    })
})
