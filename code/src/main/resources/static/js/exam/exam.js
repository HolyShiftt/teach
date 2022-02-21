var operId,sub="";
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#exam").addClass("layui-this");
    window.showSub = function(subject){
        sub= subject;
        $(".layui-card").empty()
        $.get("/exam/questionList",{subject:subject}, function (d) {
            showList(d)
        })
    }

    // 搜索
    $("#search").click(function () {
        if (sub==""){
            layer.msg("请先选择科目");
        }else{
            $(".layui-card").empty()
            $.get("/exam/questionList",{subject:sub,search:$("#title").val()}, function (d) {
                showList(d)
            })
        }

    })

    function showList(d) {
        for (const question of d.data) {
            if (question.answerInfo==null){
                question.answerInfo = "略"
            }
            $("#question").append(`<div class="layui-card">
                <div class="layui-card-header" style="display:flow-root;"><div class="layui-col-md10">`+question.title+`</div>
                <div style="text-align: right;"><a style="color: red;" onclick="getOne(`+question.id+`)">编辑</a><a style="color: red;margin-left: 30px" onclick="del(`+question.id+`)">删除</a></div></div>
                <div class="layui-card-body">
                    A:`+question.answer1+`<br>
                    B:`+question.answer2+`<br>
                    C:`+question.answer3+`<br>
                    D:`+question.answer4+`
                </div>
                <div class="layui-card-header" style="height: 0"></div>
                <div class="layui-card-body">
                    正确答案:`+question.answer+`<br>
                    解析:`+question.answerInfo+`
                </div>
            </div>`)
        }
    }

    window.getOne= function(id) {
        operId = id;
        layer.open({
            title : '修改',
            type : 2,
            area : [ '40%', '75%' ],
            content : "/examOper",
            end:function () {
                $("#"+sub).click()
            }
        })
    }

    // 添加
    $("#addQ").click(function () {
        operId = 0;
        if (sub==""){
            layer.msg("请先选择科目");
        }else{
            layer.open({
                title: '添加',
                type: 2,
                area: [ '40%', '75%' ],
                content: "/examOper",
                end:function () {
                    $("#"+sub).click()
                }
            })
        }
    })

    window.del= function(id) {
        layer.confirm('确定要删除这个题目吗', function (index) {
            $.ajax({
                type: "POST",
                data: {id: id},
                url: "/exam/questionDel",
                success: function (d) {
                    if (d.code) {
                        layer.msg(d.msg, {time: 1000}, function () {
                            layer.closeAll();//关闭弹窗
                            $("#"+sub).click()
                        });
                    } else {
                        layer.alert(d.msg)
                    }
                }
            });
            layer.close(index);
        })
    }
})

