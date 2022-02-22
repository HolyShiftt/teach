layui.use(['layer','table'], function () {
    var $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;
    var role = sessionStorage.getItem("role")
    var stuclass = sessionStorage.getItem("class");
    var grade = sessionStorage.getItem("grade");
    if (role != 3){
        $("#courseDiv").attr("style","display:none")
    }

    table.render({
        elem: '#course'
        , url: '/course/courseScheduleList'
        , where:{grade:grade,sclass:stuclass}
        , cols: [[
             {field: 'startTime', title: '开始时间', align: 'center'}
            , {field: 'endTime', title: '结束时间', align: 'center'}
            , {field: 'monday', title: '周一', align: 'center'}
            , {field: 'tuesday', title: '周二', align: 'center'}
            , {field: 'wednesday', title: '周三', align: 'center'}
            , {field: 'thursday', title: '周四', align: 'center'}
            , {field: 'friday', title: '周五', align: 'center'}
        ]]
    });

    $("#courseClass").html(grade+"年级("+stuclass+")班课程表")
    $.ajax({
        url:'/notice/noticeList',
        data:{limit:5},
        async : false,
        success : function(d) {
            $.each(d.data, function (index, item) {
                $('#noticeList').append(`<li onclick="openNotice(`+item.id+`)">
                                    <span class="pointer"></span>
                                    <span style="padding-left:20px;cursor: pointer;">`+item.title+`</span>
                                    <p>`+item.createTime+`</p>
                                </li>`);
            });
        }
    })

    window.openNotice = function(id){
        $.ajax('/notice/noticeInfo', {
            async : false,
            data : {
                id : id
            },
            success : function(d) {
                $("#title").empty();
                $("#content").empty();
                $("#noticeTime").empty();

                $("#title").append(d.title);
                $("#content").append(d.content);
                $("#noticeTime").append(d.createTime);
                layer.open({
                    title: '公告查看',
                    type: 1,
                    area: ['25%', '45%'],
                    content: $(".noticeOpen")
                })
            }
        });

    }
    // $("#moreNotice").click(function (){
    //     window.location="notice"
    // })

})
