var operId,thisType="",thisSubject;
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#question").addClass("layui-this");

    thisSubject = sessionStorage.getItem("subject")
    $("#subjectH1").html(thisSubject)


    window.showType = function(type){
        thisType = type;
        $(".layui-card").empty()
        $.get("/question/questionList",{type:type,subject:thisSubject}, function (d) {
            showList(d)
        })
    }
    $("#radioType").click();

    // 搜索
    $("#search").click(function () {
        $(".layui-card").empty()
        $.get("/question/questionList",{type:thisType,subject:thisSubject,search:$("#title").val()}, function (d) {
            showList(d)
        })
    })

    function showList(d) {
        for (const question of d.data) {
            if (question.answerInfo==null || question.answerInfo==""){
                question.answerInfo = "略"
            }
            if (thisType == 'radio'){
                $("#questionContent").append(`<div class="layui-card">
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
            }else if (thisType == 'tell'){
                question.answer == 1?question.answer="对":question.answer="错"
                $("#questionContent").append(`<div class="layui-card">
                <div class="layui-card-header" style="display:flow-root;"><div class="layui-col-md10">`+question.title+`</div>
                <div style="text-align: right;"><a style="color: red;" onclick="getOne(`+question.id+`)">编辑</a><a style="color: red;margin-left: 30px" onclick="del(`+question.id+`)">删除</a></div></div>
                <div class="layui-card-body">
                    正确答案:`+question.answer+`<br>
                    解析:`+question.answerInfo+`
                </div>
            </div>`)
            }else if (thisType == 'text'){
                var answer;
                if (question.answer3){
                    answer = question.answer1+","+question.answer2+","+question.answer3
                }else if (question.answer2){
                    answer = question.answer1+","+question.answer2
                }else{
                    answer = question.answer1
                }
                $("#questionContent").append(`<div class="layui-card">
                <div class="layui-card-header" style="display:flow-root;"><div class="layui-col-md10">`+question.title+`</div>
                <div style="text-align: right;"><a style="color: red;" onclick="getOne(`+question.id+`)">编辑</a><a style="color: red;margin-left: 30px" onclick="del(`+question.id+`)">删除</a></div></div>
                <div class="layui-card-body">
                    正确答案:`+answer+`<br>
                    解析:`+question.answerInfo+`
                </div>
            </div>`)
            }

        }
    }

    window.getOne= function(id) {
        operId = id;
        layer.open({
            title : '修改',
            type : 2,
            area : [ '40%', '75%' ],
            content : "/question"+thisType+"Oper",
            end:function () {
                $("#"+thisType+"Type").click()
            }
        })
    }

    // 添加
    $("#addQ").click(function () {
        operId = 0;
        layer.open({
            title: '添加',
            type: 2,
            area: [ '40%', '75%' ],
            content: "/question"+thisType+"Oper",
            end:function () {
                $("#"+thisType+"Type").click()
            }
        })
    })

    window.del= function(id) {
        var url;
        if (thisType == "radio"){
            url = "/questionRadio/questionRadioDel";
        }else if (thisType == "tell"){
            url = "/questionTell/questionTellDel";
        }else if (thisType == "text"){
            url = "/questionText/questionTextDel";
        }
        layer.confirm('确定要删除这个题目吗', function (index) {
            $.ajax({
                type: "POST",
                data: {id: id},
                url: url,
                success: function (d) {
                    if (d.code) {
                        layer.msg(d.msg, {time: 1000}, function () {
                            layer.closeAll();//关闭弹窗
                            $("#"+thisType+"Type").click()
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

