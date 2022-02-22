layui.use(['layer', 'form', 'laydate','element'], function () {
    var $ = layui.$
        , layer = layui.layer
        , form = layui.form

    $.ajax("/questionRadio/questionRadioInfo",{
        async : false,
        data : {
            id : parent.operId
        },
        success : function(d) {
            form.val("questionForm", d);
            $("#radio").val(d.answer);
        }
    })
    form.render();

    form.on('submit(submit)', function (data) {
        layer.load();
        $("#subject").val(parent.sub)
        var url;
        if (parent.operId===0){
            $("#id").val('')
            url = '/questionRadio/questionRadioAdd'
        }else{
            $("#id").val(parent.operId)
            url = '/questionRadio/questionRadioUpd'
        }
        $.ajax({
            url: url,
            data: $("#questionForm").serialize(),
            success: function (d) {
                if (d.code) {
                    layer.msg(d.msg, {
                        icon: 6,
                        time: 2000
                    }, function () {
                        parent.layer.close(parent.layer.getFrameIndex(window.name))
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
