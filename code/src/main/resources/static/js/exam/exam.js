var operId;
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table;

    $("#exam").addClass("layui-this");
    var sub="";
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
            if (!question.answer_info){
                question.answer_info = "略"
            }
            $("#question").append(`<div class="layui-card">
                <div class="layui-card-header"><div class="layui-col-md6">`+question.id+`.`+question.title+`</div>
                <div style="text-align: right;"><a style="color: red;" onclick="getOne(`+question.id+`)">编辑</a></div></div>
                <div class="layui-card-body">
                    A:`+question.answer1+`<br>
                    B:`+question.answer2+`<br>
                    C:`+question.answer3+`<br>
                    D:`+question.answer4+`
                </div>
                <div class="layui-card-header" style="height: 0"></div>
                <div class="layui-card-body">
                    正确答案:`+question.answer+`<br>
                    解析:`+question.answer_info+`
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
            content : "/examOper"
        })
    }

})

