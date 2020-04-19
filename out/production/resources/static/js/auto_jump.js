// DOM 加载完再执行
$(function() {

    $(document).ready(function() {
        function jump(count) {
            window.setTimeout(function(){
                count--;
                if(count > 0) {
                    $('#num').html(count);
                    jump(count);
                } else {
                    location.href="login.html";
                }
            }, 1000);
        }
        jump(5);
    });

    //点击立即登录
    $("#btn_test").click(function () {
        location.href="login.html";
    });
});
