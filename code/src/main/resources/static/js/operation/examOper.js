layui.use(['layer', 'form', 'laydate','element'], function () {
    var $ = layui.$
        , layer = layui.layer
        , form = layui.form

    $.ajax("/exam/questionInfo",{
        async : false,
        data : {
            id : parent.operId
        },
        success : function(d) {
            form.val("questionForm", d);
            $("#radio").val(d.answer);
        }
    })

    $('#close').click(function () {
        parent.layer.close(parent.layer.getFrameIndex(window.name))
    })
})
