var operId;
layui.use(['layer','form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table,
        transfer = layui.transfer;

    var radioList=[],tellList=[],textList=[]
    var subject = sessionStorage.getItem("subject");
    var teacherId = sessionStorage.getItem("id");
    $("#examTeacher").addClass("layui-this");

    $("#subject").val(subject)
    $.ajax({
        url:'/schoolClass/gradeList',
        async : false,
        success : function(d) {
            $.each(d, function (index, item) {
                $('#grade').append(new Option(item, item));
            });
        }
    })
    form.on('select(grade)', function (data) {
        $.ajax({
            url:'/schoolClass/classList?grade='+data.value,
            async : false,
            success : function(d) {
                $.each(d, function (index, item) {
                    $('#sclass').append(new Option(item, item));
                });
            }
        })
        form.render()
    });
    form.render()
    $(function () {
        choiceQuestion('text');
        choiceQuestion('radio');
        choiceQuestion('tell');
    })

    let choiceQuestion = function (type) {
        form.on('radio('+type+')', function (data) {
            if (data.value == 'choice') {
                $("#"+type+"Add").css("display", "block");
                $("#"+type+"Random").css("display", "none");
                $("#"+type+"Num").attr("disabled",true)
                if (type == 'radio'){
                    $("#"+type+"Num").val(radioList.length)
                }else if (type == 'tell'){
                    $("#"+type+"Num").val(tellList.length)
                }else if (type == 'text'){
                    $("#"+type+"Num").val(textList.length)
                }
                $("#"+type+"Sum").val($("#"+type+"Score").val()*$("#"+type+"Num").val())
                $("#sum").val(Number($("#radioSum").val())+Number($("#tellSum").val())+Number($("#textSum").val()))
            } else if (data.value == 'random') {
                if ($("#"+type+"Score").val() && $("#"+type+"Num").val()) {
                    $("#"+type+"Random").css("display", "block");
                    $("#"+type+"Add").css("display", "none");
                }
                $("#"+type+"Add").css("display", "none");
                $("#"+type+"Num").attr("disabled",false)
            }
        });
        $("#"+type+"Num").on("input", function (e) {
            if ($("#"+type+"Score").val() && $("#"+type+"Num").val()) {
                $("#"+type+"Random").css("display", "block");
                $("#"+type+"Sum").val($("#"+type+"Score").val()*$("#"+type+"Num").val())
            } else {
                $("#"+type+"Random").css("display", "none");
                $("#"+type+"Sum").val("")
            }
        });
        $("#"+type+"Score").on("input", function (e) {
            if ($("#"+type+"Num").val() && $("#"+type+"Score").val() && $("input[name="+type+"]:checked").val() == 'random' ) {
                $("#"+type+"Random").css("display", "block");
                $("#"+type+"Sum").val($("#"+type+"Score").val()*$("#"+type+"Num").val())
                $("#sum").val(Number($("#radioSum").val())+Number($("#tellSum").val())+Number($("#textSum").val()))
            } else {
                $("#"+type+"Random").css("display", "none");
                $("#"+type+"Sum").val("")
                $("#sum").val("")

            }
        });
        $("#"+type+"Add").click(function () {
            var dataList;
            if (type == 'radio'){
                dataList = radioList
            }else if (type == 'tell'){
                dataList = tellList
            }else if (type == 'text'){
                dataList = textList
            }
            $.get("/question/questionList",{type:type,subject:subject}, function (d) {
                transfer.render({
                    elem: '#editQuestion'  //绑定元素
                    ,data: d.data
                    ,id: 'editQuestion' //定义索引
                    ,value:dataList
                    , title: ['可选题目', '已选题目']
                    ,parseData: function(res){
                        return {
                            "value": res.id //数据值
                            ,"title": res.title //数据标题
                        }
                    }
                    ,width: 350
                    ,height: 600
                    ,showSearch: true
                });
                layer.open({
                    type: 1
                    , content: $("#editQuestion")
                    , area: ['850px', '780px']
                    , showSearch: true
                    , btn: ['确定', '重置', '关闭']
                    , yes: function(){
                        var dataList = transfer.getData('editQuestion'),dataList2=[];
                        for (let i = 0; i < dataList.length; i++) {
                            dataList2.push(dataList[i].value)
                        }
                        if (type == 'radio'){
                            radioList = dataList2
                        }else if (type == 'tell'){
                            tellList = dataList2
                        }else if (type == 'text'){
                            textList = dataList2
                        }
                        $("#"+type+"Num").val(dataList.length)
                        $("#"+type+"Sum").val($("#"+type+"Score").val()*$("#"+type+"Num").val())
                        $("#sum").val(Number($("#radioSum").val())+Number($("#tellSum").val())+Number($("#textSum").val()))
                        layer.closeAll()
                    }
                    ,btn2: function () {
                        transfer.reload('editQuestion', {
                            title: ['可选题目', '已选题目']
                            ,showSearch: true
                        })
                        if (type == 'radio'){
                            radioList = []
                        }else if (type == 'tell'){
                            tellList = []
                        }else if (type == 'text'){
                            textList = []
                        }
                        return false;
                    }
                });
            })

        })
        $("#"+type+"Random").click(function () {
            $.get("/question/questionList",{type:type,subject:subject}, function (d) {
                var dataList = [],arr=[],len = d.data.length,r
                for (let i = 0; i < d.data.length; i++) {
                    arr.push(d.data[i].id)
                }
                for(let i=0;i<$("#"+type+"Num").val();i++){
                    r=Math.floor(Math.random()*arr.length);
                    dataList.push(arr[r]);
                    arr.splice(r,1);
                }
                transfer.render({
                    elem: '#editQuestion'  //绑定元素
                    ,data: d.data
                    ,id: 'editQuestion' //定义索引
                    ,value:dataList
                    , title: ['可选题目', '已选题目']
                    ,parseData: function(res){
                        return {
                            "value": res.id //数据值
                            ,"title": res.title //数据标题
                        }
                    }
                    ,width: 350
                    ,height: 600
                    ,showSearch: true
                });
                layer.open({
                    type: 1
                    , content: $("#editQuestion")
                    , area: ['850px', '780px']
                    , btn: ['确定', '重置', '关闭']
                    , yes: function(){
                        var dataList = transfer.getData('editQuestion'),dataList2=[];
                        for (let i = 0; i < dataList.length; i++) {
                            dataList2.push(dataList[i].value)
                        }
                        if (type == 'radio'){
                            radioList = dataList2
                        }else if (type == 'tell'){
                            tellList = dataList2
                        }else if (type == 'text'){
                            textList = dataList2
                        }
                        $("#"+type+"Num").val(dataList.length)
                        $("#"+type+"Sum").val($("#"+type+"Score").val()*$("#"+type+"Num").val())
                        $("#sum").val(Number($("#radioSum").val())+Number($("#tellSum").val())+Number($("#textSum").val()))
                        layer.closeAll()
                    }
                    ,btn2: function () {
                        transfer.reload('editQuestion', {
                            title: ['可选题目', '已选题目']
                            ,showSearch: true
                        })
                        if (type == 'radio'){
                            radioList = []
                        }else if (type == 'tell'){
                            tellList = []
                        }else if (type == 'text'){
                            textList = []
                        }
                        return false;
                    }
                });
            })
        })
    };

    $("#preBtn").click(function () {
        $.get("/question/questionIds",{ids:JSON.stringify(radioList),subject:subject,type:'radio'}, function (d) {
            $("#questionContent").append(`<h1>选择题</h1>`)
            for (const question of d.data) {
                $("#questionContent").append(`<div class="layui-card">
                <div class="layui-card-header" style="display:flow-root;"><div class="layui-col-md10">`+question.title+`</div></div>
                <div class="layui-card-body">
                    A:`+question.answer1+`<br>
                    B:`+question.answer2+`<br>
                    C:`+question.answer3+`<br>
                    D:`+question.answer4+`
                </div>
            </div>`)
            }
            $.get("/question/questionIds",{ids:JSON.stringify(tellList),subject:subject,type:'tell'}, function (d) {
                $("#questionContent").append(`<h1>判断题</h1>`)
                for (const question of d.data) {
                    $("#questionContent").append(`<div class="layui-card">
                <div class="layui-card-header" style="display:flow-root;"><div class="layui-col-md10">`+question.title+`</div>                
            </div>`)
                }
                $.get("/question/questionIds",{ids:JSON.stringify(textList),subject:subject,type:'text'}, function (d) {
                    $("#questionContent").append(`<h1>填空题</h1>`)
                    for (const question of d.data) {
                        $("#questionContent").append(`<div class="layui-card">
                <div class="layui-card-header" style="display:flow-root;"><div class="layui-col-md10">`+question.title+`</div>
            </div>`)
                    }
                })
            })
        })

        layer.open({
            type: 1
            , content: $("#preDiv")
            , area: ['850px', '780px']
            ,end:function () {
                $("#questionContent").empty()
            }
            ,cancel:function () {
                $("#questionContent").empty()
            }
        })
        return false
    })

    form.on('submit(submit)', function (data) {
        // 判断时间
        var startD,endD,startH,endH;
        data.field.startTime = layui.util.toDateString(data.field.startTime, 'yyyy-MM-dd HH:mm')
        data.field.endTime = layui.util.toDateString(data.field.endTime, 'yyyy-MM-dd HH:mm')
        startD = layui.util.toDateString(data.field.startTime, 'yyyy-MM-dd')
        endD = layui.util.toDateString(data.field.endTime, 'yyyy-MM-dd')
        startH = layui.util.toDateString(data.field.startTime, 'HH:mm')
        endH = layui.util.toDateString(data.field.endTime, 'HH:mm')
        endD = endD.split("-");
        startD = startD.split("-");
        endH = endH.split(":");
        startH = startH.split(":");
        if (endD[2] != startD[2]){
            layer.alert("考试时间范围只能在当天")
        } else if(endH[0] < startH[0]){
            layer.alert("开始时间不能早于结束时间")
        } else if(endH[0] == startH[0] && endH[1] < startH[1] ){
            layer.alert("开始时间不能早于结束时间")
        } else{
            // 判断题目数量
            if ($("#radioNum").val()!=radioList.length && $("#tellNum").val()!=tellList.length && $("#textNum").val()!=textList.length ){
                layer.alert("题目数量出错")
            }else{
                $.ajax("/exam/examAdd", {
                    data: {
                        "name": $("#name").val()
                        , "startTime": $("#startTime").val()
                        , "endTime": $("#endTime").val()
                        , "subject": subject
                        , "grade": $("#grade").val()
                        , "sclass": $("#sclass").val()
                        , "teacherId": teacherId
                        , "radioList": radioList
                        , "radioScore": $("#radioScore").val()
                        , "tellList": tellList
                        , "tellScore": $("#tellScore").val()
                        , "textList": textList
                        , "textScore": $("#textScore").val()
                        , "sum": $("#sum")
                    },
                    success : function(d) {
                        return false;
                    }
                })
            }
        }
        return false;
    })
})
