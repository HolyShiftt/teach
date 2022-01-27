layui.use(['layer','table'], function () {
    var $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;

    table.render({
        elem: '#course'
        , url: '/course/courseScheduleList'
        , cols: [[
             {field: 'startTime', title: '开始时间', align: 'center'}
            , {field: 'endTime', title: '结束时间', align: 'center'}
            , {field: 'monday', title: '周一', align: 'center'}
            , {field: 'tuesday', title: '周二', align: 'center'}
            , {field: 'wednesday', title: '周三', align: 'center'}
            , {field: 'thursday', title: '周四', align: 'center'}
            , {field: 'friday', title: '周五', align: 'center'}
        ]]
    });

})
