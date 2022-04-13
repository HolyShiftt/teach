layui.use(['layer', 'form'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        table = layui.table,
        element = layui.element;
    var stuclass = sessionStorage.getItem("class");
    var grade = sessionStorage.getItem("grade");
    var realName = sessionStorage.getItem("realName");
    $("#stuInfo1").html(realName)
    $("#stuInfo2").html(grade + "年级(" + stuclass + ")班")
    var radioList, tellList, textList, examList

    // 设置倒计时
    var div = document.getElementById("showTime");
    setInterval(function () {
        div.innerHTML = showtime(sessionStorage.getItem("endTime"));
        for (let i = radioList.length + tellList.length; i < examList.length; i++) {
            var num = Number(i) + 1;
            if ($("#" + i).val()) {
                $("#btn" + num).css("background-color", '#009688').css("color", 'white')
                $("#btn" + num).addClass("done")
                element.progress('demo', toPercent(document.getElementsByClassName('done').length / examList.length));
            }
        }
        if (showtime(sessionStorage.getItem("endTime")) == "0:0:0") {
            sub("考试时间结束，已自动交卷");
        }
    }, 1000);  //反复执行函数本身


    $.ajax('/exam/showExamQuestion', {
        sync: false,
        success: function (d) {
            $("#stuInfo3").html(d.examName)
            for (let i = 0; i < d.questionSum; i++) {
                var num = i + 1
                $("#questionNumList").append(`<button class="layui-btn layui-col-md2" style="background-color: #F2F4F7;color:black" 
                    id="btn` + num + `" onclick="btnClick(` + num + `)">` + num + `</button>`)
            }
            radioList = d.questionRadioList
            tellList = d.questionTellList
            textList = d.questionTextList
            examList = radioList.concat(tellList, textList)
            if (d.questionRadioList != null) {
                for (let i = 0; i < radioList.length; i++) {
                    appendRadio(i)
                }
                for (let i = radioList.length; i < radioList.length + tellList.length; i++) {
                    appendTell(i)
                }
                for (let i = radioList.length + tellList.length; i < examList.length; i++) {
                    appendText(i)
                }
            } else if (d.questionTellList != null) {
                for (let i = 0; i < tellList.length; i++) {
                    appendTell(i)
                }
                for (let i = tellList.length; i < examList.length; i++) {
                    appendText(i)
                }
            } else {
                for (let i = 0; i < textList.length; i++) {
                    appendText(i)
                }
            }
            btnClick(1)
        }


    });

    window.appendRadio = function (num) {
        var num2 = num + 2, btn
        if (num + 1 == examList.length) {
            btn = `<div style="text-align: center;margin-top: 30px"><button class="layui-btn" onclick="sub('交卷成功')">交卷</button> </div>`
        } else if (num + 1 < examList.length) {
            btn = `<div style="text-align: center;margin-top: 30px"><button class="layui-btn" onclick="btnClick(` + num2 + `)">下一题</button> </div>`
        }
        $("#questionContent").append(`<div class="layui-card" style="display: none" id="content` + num + `">
                <div class="layui-card-header" style="display:flow-root;text-align: center;font-size: 20px;">` + examList[num].title + `</div>
                <div class="layui-card-body" style="text-align: center;font-size: 20px;" >
                <form class="layui-form">
                        <input type="radio" id ="` + num + `" name="` + examList[num].id + `" lay-filter="question" value="A" title="A:` + examList[num].answer1 + `"><br>
                        <input type="radio" id ="` + num + `" name="` + examList[num].id + `" lay-filter="question" value="B" title="B:` + examList[num].answer2 + `"><br>
                        <input type="radio" id ="` + num + `" name="` + examList[num].id + `" lay-filter="question" value="C" title="C:` + examList[num].answer3 + `"><br>
                        <input type="radio" id ="` + num + `" name="` + examList[num].id + `" lay-filter="question" value="D" title="D:` + examList[num].answer4 + `"><br>
                </form>` + btn + `
                </div>
            </div>`)
        form.render()
    }

    window.appendTell = function (num) {
        var num2 = num + 2, btn
        if (num + 1 == examList.length) {
            btn = `<div style="text-align: center;margin-top: 30px"><button class="layui-btn" onclick="sub('交卷成功')">交卷</button> </div>`
        } else if (num + 1 < examList.length) {
            btn = `<div style="text-align: center;margin-top: 30px"><button class="layui-btn" onclick="btnClick(` + num2 + `)">下一题</button> </div>`
        }
        $("#questionContent").append(`<div class="layui-card" style="display: none" id="content` + num + `">
                <div class="layui-card-header" style="display:flow-root;text-align: center;font-size: 20px;">` + examList[num].title + `</div>
                <div class="layui-card-body" style="text-align: center;font-size: 20px;" >
                <form class="layui-form">
                        <input type="radio" id ="` + num + `" name="` + examList[num].id + `" lay-filter="question" value="true" title="对"><br>
                        <input type="radio" id ="` + num + `" name="` + examList[num].id + `" lay-filter="question" value="false" title="错"><br>
                </form>` + btn + `
                </div>
            </div>`)
        form.render()
    }

    window.appendText = function (num) {
        var num2 = num + 2, btn
        var ansInput
        if (examList[num].answer3) {
            ansInput = `<label class="layui-form-label">1.</label><div class="layui-input-block"><input type="text" class="layui-input" id ="` + num + `" name="first` + examList[num].id + `"></div><br>
                        <label class="layui-form-label">2.</label><div class="layui-input-block"><input type="text" class="layui-input" id ="` + num + `" name="second` + examList[num].id + `"></div><br>
                        <label class="layui-form-label">3.</label><div class="layui-input-block"><input type="text" class="layui-input" id ="` + num + `" name="third` + examList[num].id + `"></div><br>`
        } else if (examList[num].answer2) {
            ansInput = `<label class="layui-form-label">1.</label><div class="layui-input-block"><input type="text" class="layui-input" id ="` + num + `" name="first` + examList[num].id + `"></div><br>
                        <label class="layui-form-label">2.</label><div class="layui-input-block"><input type="text" class="layui-input" id ="` + num + `" name="second` + examList[num].id + `"></div><br>`
        } else {
            ansInput = `<label class="layui-form-label">1.</label><div class="layui-input-block"><input type="text" class="layui-input" id ="` + num + `" name="first` + examList[num].id + `"></div><br>`
        }
        if (num + 1 == examList.length) {
            btn = `<div style="text-align: center;margin-top: 30px"><button class="layui-btn" onclick="sub('交卷成功')">交卷</button> </div>`
        } else if (num + 1 < examList.length) {
            btn = `<div style="text-align: center;margin-top: 30px"><button class="layui-btn" onclick="btnClick(` + num2 + `)">下一题</button> </div>`
        }
        $("#questionContent").append(`<input type="text" class="layui-input" style="display:none"  name=` + examList[num].id + `">
                <div class="layui-card" style="display: none" id="content` + num + `">
                <div class="layui-card-header" style="display:flow-root;text-align: center;font-size: 20px;">` + examList[num].title + `</div>
                <div class="layui-card-body" style="text-align: center;font-size: 20px;" >
                <form class="layui-form">` + ansInput + `</form>
                ` + btn + `
                </div>
            </div>`)
        form.render()
    }

    window.btnClick = function (num) {
        var num2 = Number(num) - 1
        $(".layui-card").css("display", "none")
        $("#content" + num2).css("display", 'block')
    }

    form.on('radio(question)', function (data) {
        var num = Number(data.elem.id) + 1
        $("#btn" + num).css("background-color", '#009688').css("color", 'white')
        $("#btn" + num).addClass("done")
        element.progress('demo', toPercent(document.getElementsByClassName('done').length / examList.length));
    });

    window.sub = function () {
        for (let i = 0; i < examList.length; i++) {
            if (i >= radioList.length + tellList.length) {
                var a = $("input[name=first" + examList[i].id + "]").val() + ","
                    + $("input[name=second" + examList[i].id + "]").val() + "," + $("input[name=third" + examList[i].id + "]").val()
                $("input[name=" + examList[i].id + "]:checked").val(a)
            }
            console.log($("input[name=" + examList[i].id + "]:checked").val())
        }
    }


    function toPercent(point) {
        if (point == 0) {
            return 0;
        }
        var str = Number(point * 100).toFixed();
        str += "%";
        return str;
    }

    var showtime = function (endtime) {
        var nowtime = new Date();
        endtime = new Date(endtime);
        var lefttime = endtime.getTime() - nowtime.getTime(),  //距离结束时间的毫秒数
            lefth = Math.floor(lefttime / (1000 * 60 * 60) % 24),  //计算小时数
            leftm = Math.floor(lefttime / (1000 * 60) % 60),  //计算分钟数
            lefts = Math.floor(lefttime / 1000 % 60);  //计算秒数
        return lefth + ":" + leftm + ":" + lefts;  //返回倒计时的字符串
    }


    sub = function (msg) {
        $.post("/111",{data:form.field}, function (data) {
            layer.msg(msg, {
                icon: 6,
                time: 2000
            }, function () {

            })
        });
    }

})
