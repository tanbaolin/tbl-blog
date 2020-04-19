// DOM 加载完再执行
$(function() {

    function checkusername() {
        /**
         * （1）同步调用 （2）且在ajax对全局变量进行设值 (3)ajax函数外将变量return
         * 结果：返回 2。成功获取返回值
         * 成功原因：先执行result = status;再往下执行return result;
         */
        var result = 0;
        $.ajax({
            url: "/checkname?username=" + $("#username").val(),
            contentType: 'application/json',
            type: "get",
            async:false,
            success: function (status) {
                result = status;
            },
            error: function () {
                toastr.error("出错啦！");
            }
        });
        return result;
    }

    function checkemail() {
        var result = 0;
        $.ajax({
            url: "/checkemail?email=" + $("#email").val(),
            contentType: 'application/json',
            type: "get",
            async:false,
            success: function (status) {
                result = status;
            },
            error: function () {
                toastr.error("出错啦！");
            }
        });
        return result;
    }

    //提交数据时，校验个属性值为空和属性的唯一性
    $("#btn_submit").click(function () {
        var username = $("#username").val();
        var email = $("#email").val();
        var name = $("#name").val();
        var password = $("#password").val();
        if(username=='' || email=='' || name=='' || password==''){
            $("#error_msg").html("请将信息填写完整！");
            return false;
        }
        if(checkusername() == 1){
            $("#remind_msg").css({color:"red"}).html("该用户名已被注册！");
            return false;
        }

        if(checkemail() == 1){
            $("#email_check").css({color:"red"}).html("该邮箱已被注册！");
            return false;
        }
    });


    $("#username").blur(function () {
        //console.log("---->"+$("#username").val()+"<------");
        if($.trim($("#username").val()) == ''){
            $("#remind_msg").css({color:"red"}).html("请输入你要注册的账号！");
            return false;
        }
        $.ajax({
            url: "/checkname?username="+ $("#username").val(),
            contentType : 'application/json',
            type: "get",
            success: function(status){
                if(status == 1){
                    $("#remind_msg").css({color:"red"}).html("抱歉，该账号已被注册！");
                }else {
                    $("#remind_msg").css({color:"green"}).html("账号可用！");
                }
            },
            error : function() {
                toastr.error("出错啦！");
            }
        });
    });

    $("#name").blur(function () {
        if($.trim($("#name").val()) == ''){
            $("#name_msg").css({color:"red"}).html("姓名不能为空！");
            return false;
        }
    });

    $("#password").blur(function () {
        if($.trim($("#password").val()) == ''){
            $("#password_msg").css({color:"red"}).html("密码不能为空！");
            return false;
        }
    });

});
