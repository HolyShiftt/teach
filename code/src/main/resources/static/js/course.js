var operId;
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#courseManage").addClass("layui-this");

    form.render();

    courseTable = table.render({
        elem: '#courseTable'
        , url: '/course/allCourseScheduleList'
        , page: true
        , cols: [[
            {field: 'grade', title: '年级', align: 'center'}
            , {field: 'sclass', title: '班级', align: 'center'}
            , {field: 'num', title: '节次', align: 'center'}
            , {field: 'monday', title: '周一', align: 'center'}
            , {field: 'tuesday', title: '周二', align: 'center'}
            , {field: 'wednesday', title: '周三', align: 'center'}
            , {field: 'thursday', title: '周四', align: 'center'}
            , {field: 'friday', title: '周五', align: 'center'}
            , {field: 'saturday', title: '周六', align: 'center'}
            , {field: 'sunday', title: '周天', align: 'center'}
            , {fixed: 'right', title: '操作', toolbar: '#operation'}
        ]]
    });


    $("#search").click(function () {
        courseTable.reload({
            where: {
                grade:$("#grade").val(),
                sclass:$("#sclass").val()
            }
        });
    })

    // 添加
    $("#addBtn").click(function () {
        operId=0
        layer.open({
            title: '添加',
            type: 2,
            area: ['25%', '75%'],
            content: '/courseOper'
        })
    })

    // 编辑和删除
    table.on('tool(courseTable)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del'){
            // 删除按钮
            layer.confirm('确定要删除这条记录吗', function (index) {
                $.ajax({
                    type: "POST",
                    data: {id: data.id},
                    url: "/course/courseDel",
                    success: function (d) {
                        if (d.code) {
                            layer.msg(d.msg, {time: 1000}, function () {
                                layer.closeAll();//关闭弹窗
                                courseTable.reload()//保存成功刷新
                            });
                        } else {
                            layer.alert(d.msg)
                        }
                    }
                });
                layer.close(index);
            })
        }else if (obj.event === 'edit'){
            operId=data.id
            layer.open({
                title: '编辑',
                type: 2,
                area: ['25%', '75%'],
                content: '/courseOper'
            })
        }
    })
})
