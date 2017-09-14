//加载
jQuery.fn.showLoading = function(options) {
    var loadingDiv = jQuery('<div class="loading-overlay"><span class="glyphicon glyphicon-refresh glyphicon-animation"></span></div>');
    $(this).append(loadingDiv);
};
jQuery.fn.hideLoading = function(options) {
    $(".loading-overlay").remove();
};
/**
 * post请求
 * options:{func:,object:}
 */
CommonOperation = {};
CommonOperation.ajaxRequest = function(url,data,options){
    options = options||{};
    $.ajax({
        url: url,
        data: data,
        dataType: 'json',
        beforeSend: function(XHR){
            options.element&&$(options.element).showLoading();
        },
        complete: function(XHR, TS){
            options.element&&$(options.element).hideLoading();
        },
        success: function(result){
            if(result&&(typeof result === "string")&&result.indexOf("错误:")>=0){
                alert(result.substr(3));
                return;
            }
            if(typeof options === "function"){
                options.call(window,result);
            }else if(typeof options === "object"&&options.func){
                options.func.call(options.object,result);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            var responseText = XMLHttpRequest.responseText||"";
            var notEmpty = (!responseText&&""!=responseText);
            if(notEmpty&&(typeof responseText === "string")&&responseText.indexOf("错误:")>=0){
                if(options.errorFunc){
                    options.errorFunc.call(options.object,responseText.substr(3));
                }else{
                    alert(responseText.substr(3));
                }
                return;
            }
            alert("请求发生错误:"+responseText);
        }
    });
};
$(function(){
    if($.validator&&$.validator.messages){
        $.extend($.validator.messages, {
            required: "必填字段",
            remote: "请修正该字段",
            email: "请输入正确格式的电子邮件",
            url: "请输入合法的网址",
            date: "请输入合法的日期",
            dateISO: "请输入合法的日期 (ISO).",
            number: "请输入合法的数字",
            digits: "只能输入整数",
            creditcard: "请输入合法的信用卡号",
            equalTo: "请再次输入相同的值",
            accept: "请输入拥有合法后缀名的字符串",
            maxlength: $.validator.format("请输入一个长度最多是 {0} 的字符串"),
            minlength: $.validator.format("请输入一个长度最少是 {0} 的字符串"),
            rangelength: $.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
            range: $.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
            max: $.validator.format("请输入一个最大为 {0} 的值"),
            min: $.validator.format("请输入一个最小为 {0} 的值")
        });
        //手机号码的验证
        $.validator.addMethod("phone", function(value, element, param){
            if(value == null || value == "") return true;
            var pattern = /^1[34578]\d{9}$/;
            return pattern.test(value)
        }, "请输入合法的11位手机号");
        //身份证号的验证
        $.validator.addMethod("idCard", function(value, element, param){
            var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            return pattern.test(value);
        }, "请输入合法的身份证号");
    }
});