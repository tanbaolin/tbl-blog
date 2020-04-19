// DOM 加载完再执行
$(function() {

    //邮箱号校验
    $("#email").blur(function () {
        //console.log("---->"+$("#username").val()+"<------");
        if($.trim($("#email").val()) == ''){
            $("#email_check").css({color:"red"}).html("请输入你要注册的邮箱号！");
            return false;
        }
        $.ajax({
            url: "/checkemail?email="+ $("#email").val(),
            contentType : 'application/json',
            type: "get",
            success: function(status){
                if(status == 1){
                    $("#email_check").css({color:"red"}).html("抱歉，该邮箱已被注册！");
                }else {
                    $("#email_check").css({color:"green"}).html("邮箱号可用！");
                }
            },
            error : function() {
                toastr.error("出错啦！");
            }
        });
    });
});
