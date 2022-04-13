var operId;
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#notice").addClass("layui-this");

    form.render();

    noticeTable = table.render({
        elem: '#noticeTable'
        , url: '/notice/noticeList'
        , page: true
        , cols: [[
            {field: 'title', title: '标题', align: 'center'}
            , {field: 'content', title: '内容', align: 'center'}
            , {field: 'createTime', title: '创建时间', align: 'center'}
            , {fixed: 'right', title: '操作', toolbar: '#operation'}
        ]]
    });

    // 添加
    $("#addNotice").click(function () {
        operId=0
        layer.open({
            title: '添加',
            type: 2,
            area: ['25%', '45%'],
            content: '/noticeOper'
        })
    })

    // 编辑和删除
    table.on('tool(noticeTable)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del'){
            // 删除按钮
            layer.confirm('确定要删除这条公告吗', function (index) {
                $.ajax({
                    type: "POST",
                    data: {id: data.id},
                    url: "/notice/noticeDel",
                    success: function (d) {
                        if (d.code) {
                            layer.msg(d.msg, {time: 1000}, function () {
                                layer.closeAll();//关闭弹窗
                                noticeTable.reload()//保存成功刷新
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
                area: ['25%', '45%'],
                content: '/noticeOper'
            })
        }
    })


    $("#search").click(function () {
        noticeTable.reload({
            where: {
                title:$("#title").val(),
            }
        });
    })
})
