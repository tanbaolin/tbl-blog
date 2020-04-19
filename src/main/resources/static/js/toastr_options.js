$(function() {

    //设置显示配置
    var messageOpts = {
        "closeButton" : true,//是否显示关闭按钮
        "debug" : false,//是否使用debug模式
        "positionClass" : "toast-top-center",//弹出窗的位置
        "onclick" : null,
        "showDuration" : "300",//显示的动画时间
        "hideDuration" : "1000",//消失的动画时间
        "timeOut" : "2000",//展现时间
        "extendedTimeOut" : "1000",//加长展示时间
        "showEasing" : "swing",//显示时的动画缓冲方式
        "hideEasing" : "linear",//消失时的动画缓冲方式
        "showMethod" : "fadeIn",//显示时的动画方式
        "hideMethod" : "fadeOut" //消失时的动画方式
    };
    toastr.options = messageOpts;

})

/*!
toast-top-left  顶端左边
toast-top-right    顶端右边
toast-top-center  顶端中间
toast-top-full-width 顶端，宽度铺满整个屏幕
toast-botton-right
toast-bottom-left
toast-bottom-center
toast-bottom-full-width
 */