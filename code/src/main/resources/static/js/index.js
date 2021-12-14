layui.use(['layer','table'], function () {
    var $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    table.render({
        elem: '#course'
        , url: '/course/courseScheduleServiceList'
        , cols: [[
             {field: 'startTime', title: '开始时间', align: 'center'}
            , {field: 'endTime', title: '结束时间', align: 'center'}
            , {field: 'mondayCourse', title: '周一', align: 'center'}
            , {field: 'tuesdayCourse', title: '周二', align: 'center'}
            , {field: 'wednesdayCourse', title: '周三', align: 'center'}
            , {field: 'thursdayCourse', title: '周四', align: 'center'}
            , {field: 'fridayCourse', title: '周五', align: 'center'}
            , {field: 'saturdayCourse', title: '周六', align: 'center'}
            , {field: 'sundayCourse', title: '周天', align: 'center'}
        ]]
    });

})
