var websocket = null;

layui.use(function () {
    var $ = layui.jquery;

    $("#chat").addClass("layui-this");
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket'in window) {
        websocket = new WebSocket("ws:/localhost:8080/websocket");
    } else {
        alert('Not support websocket')
    }
    //连接发生错误的回调方法
    websocket.onerror = function() {
        setMessageInnerHTML("error");
    };
    //连接成功建立的回调方法
    websocket.onopen = function(event) {
    }
    //接收到消息的回调方法
    websocket.onmessage = function(event) {
        setMessageInnerHTML(event.data);
    }
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function() {
        websocket.close();
    }

    $.ajax("/notice/chatList",{
        success : function(d) {
            for (let i = 0; i < d.length; i++) {
                document.getElementById('messag').innerHTML +=d[i].username+":"+ d[i].msg + '<br/>';
            }
        }})
    //发送消息
    window.send = function () {
        var message = document.getElementById('text').value;
        $.ajax("/notice/addChat?username="+sessionStorage.getItem("realName")+"&msg="+message,{
        })
        setMessageInnerHTML(message);

        document.getElementById('text').value = null
    }
})
// 将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    document.getElementById('messag').innerHTML +=sessionStorage.getItem("realName")+":"+ innerHTML + '<br/>';
}

