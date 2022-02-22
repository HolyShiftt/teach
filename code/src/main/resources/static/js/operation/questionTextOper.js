layui.use(['layer', 'form', 'laydate','element'], function () {
    var $ = layui.$
        , layer = layui.layer
        , form = layui.form

    $.ajax("/questionText/questionTextInfo",{
        async : false,
        data : {
            id : parent.operId
        },
        success : function(d) {
            form.val("questionForm", d);
            $("#text").val(d.answer);
        }
    })
    form.render();

    $(document).ready(function() {
        // select下拉框选中触发事件
        form.on("select", function(data){
            $("#answerDiv").empty();
            for (let i = 1; i <= data.value; i++) {
                $("#answerDiv").append(`<div class="layui-form-item">
            <label class="layui-form-label">答案`+i+`<span style="color: red">*</span></label>
            <div class="layui-input-block">
                <input type="input" name="answer`+i+`" autocomplete="off" lay-verify="required" class="layui-input" />
            </div>
        </div>`)
            }
        });

    });
    form.on('submit(submit)', function (data) {
        layer.load();
        $("#subject").val(parent.thisSubject)
        var url;
        if (parent.operId===0){
            $("#id").val('')
            url = '/questionText/questionTextAdd'
        }else{
            $("#id").val(parent.operId)
            url = '/questionText/questionTextUpd'
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
