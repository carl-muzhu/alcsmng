$(document).ready(function() {
	$.datepicker.regional['zh-HK'] = {
            closeText: '关闭',
            prevText: '&#x3c;上月',
            nextText: '下月&#x3e;',
            currentText: '今天',
            monthNames: ['一月','二月','三月','四月','五月','六月',
            '七月','八月','九月','十月','十一月','十二月'],
            monthNamesShort: ['一','二','三','四','五','六',
            '七','八','九','十','十一','十二'],
            dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
            dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
            dayNamesMin: ['日','一','二','三','四','五','六'],
            weekHeader: '周',
            dateFormat: 'yy-mm-dd',
            firstDay: 0,
            isRTL: false,
            showMonthAfterYear: false,
            yearSuffix: '年'};
    $.datepicker.setDefaults($.datepicker.regional['zh-HK']);
	//返回列表按钮事件绑定
	$('button[tag=returnList]').bind('click',function(){
		window.location=$(this).attr('href');
		return false;
	});
	//重置按钮
	$('input[type=reset]').bind('click',function(){
		$(this).closest('form').find('input').not(':button, :submit, :reset').each(function(){
			this.defaultValue='';
			$(this).val(this.defaultValue).removeAttr('checked').removeAttr('selected');
		})
		$(this).closest('form').find('select').each(function(){
			this.defaultValue='';
			$(this).val(this.defaultValue).find('option').removeAttr('selected');
		})
	});
	//返回按钮
	$('button[tag=goBack]').bind('click',function(){
		history.back();
	});
	//弹窗
	$("a[tag=openDialog]").click(function(){
		var targetUrl = $(this).attr("targetUrl");
		var title = $(this).attr("title");
		var reload = $(this).attr("reload");
		$.colorbox({title:function(){
			  return title;
			},opacity: 0.5,transition:'none',width:'80%',height:'80%',href:targetUrl,
			onClosed:function(){ 
				if(reload){
					location=location;
				}
			}
			});
		return false;
	});
	//小弹窗
	$("a[tag=openSmallDialog]").click(function(){
		var targetUrl = $(this).attr("targetUrl");
		var title = $(this).attr("title");
		var reload = $(this).attr("reload");
		$.colorbox({title:function(){
			  return title;
			},opacity: 0.5,transition:'none',width:'450px',height:'350px',href:targetUrl,
			onClosed:function(){ 
				if(reload){
					location=location;
				}
			}
		});
		return false;
	});
	
	//iframe弹窗
	$("a[tag=openDialogIframe]").click(function(){
		var targetUrl = $(this).attr("targetUrl");
		var title = $(this).attr("title");
		var reload = $(this).attr("reload");
		$.colorbox({iframe:true,title:function(){
			  return title;
			},opacity: 0.5,transition:'none',width:'80%',height:'80%',href:targetUrl,
			onClosed:function(){ 
				if(reload){
					location=location;
				}
			}
		});
		return false;
	});
	$("input[class=datepicker]").keydown(function(){
		return false;
	});
	$("input[class=datepicker]").datepicker();
	//初始化页面宽高
	initBottomBar();
	jQuery.ajaxSetup({     
	    contentType:"application/x-www-form-urlencoded;charset=utf-8",     
	    error:function(XMLHttpRequest,textStatus,errorMsg){  
	        // 统一处理ajax登陆超时，登陆超时的两个特征：403，以及返回超时的信息
	    	if(top.sessionTimeoutProcess)
	        top.sessionTimeoutProcess(XMLHttpRequest,textStatus,errorMsg);
	    }    
	});
});

//弹出隐藏层  
function showScreenCover() {
    var showdiv = document.getElementById("fullScreenCover");
    if (showdiv == undefined) {  
        return;  
    }  
    var cntdiv = document.getElementById("fullScreenCoverContent");
    cntdiv.style.marginLeft = ($(window).width()-200)/2+"px";
    cntdiv.style.marginTop = ($(window).height()-80)/2 + "px";
    showdiv.style.display = 'block';  
};  
//关闭弹出层  
function hideScreenCover() {
    document.getElementById("fullScreenCover").style.display = 'none';  
}; 
function initBottomBar(){
	if($("#right_area").find(".diaDivBottom").length>0){
		var hei = $("#right_area").height();
		$("#right_area").height(hei-41-10);
	}
}