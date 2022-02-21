layui.use(['layer', 'form', 'laydate'], function () {
    var $ = layui.$
        , layer = layui.layer
        , form = layui.form;

    if (parent.operId !== 0){
        // 获取该行数据
        $.ajax('/notice/noticeInfo', {
            async : false,
            data : {
                id : parent.operId
            },
            success : function(d) {
                form.val("noticeForm", d);
            }
        });
    }
    form.render();

    form.on('submit(submit)', function (data) {
        layer.load();
        var url;
        if (parent.operId===0){
            $("#id").val('')
            url = '/notice/noticeAdd'
        }else{
            $("#id").val(parent.operId)
            url = '/notice/noticeUpd'
        }
        $.ajax({
            url: url,
            data: $("#noticeForm").serialize(),
            success: function (d) {
                if (d.code) {
                    layer.msg(d.msg, {
                        icon: 6,
                        time: 2000
                    }, function () {
                        parent.layer.close(parent.layer.getFrameIndex(window.name))
                        parent.noticeTable.reload();
                    })
                } else {
                    layer.alert(d.msg)
                    layer.closeAll('loading');
                }
            },
        });
        return false;
    })

    $('#close').click(function () {
        parent.layer.close(parent.layer.getFrameIndex(window.name))
    })

})
