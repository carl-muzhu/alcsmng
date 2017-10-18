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
			  return cutString(title,100);
			},opacity: 0.5,transition:'none',width:'80%',height:'80%',href:targetUrl,overlayClose:false,
			onClosed:function(){ 
				if(reload){
					window.location.reload();
				}
			}
			});
		return false;
	});
	//小弹窗1
	$("a[tag=openSmallDialog]").click(function(){
		var targetUrl = $(this).attr("targetUrl");
		var title = $(this).attr("title");
		var reload = $(this).attr("reload");
		$.colorbox({title:function(){
			  return title;
			},opacity: 0.5,transition:'none',width:'450px',height:'350px',href:targetUrl,overlayClose:false,
			onClosed:function(){ 
				if(reload){
					window.location.reload();
				}
			}
		});
		return false;
	});
	//小弹窗2
	$("a[tag=openSmallerDialog]").click(function(){
		var targetUrl = $(this).attr("targetUrl");
		var title = $(this).attr("title");
		var reload = $(this).attr("reload");
		$.colorbox({iframe:'true',title:function(){
			  return title;
			},opacity: 0.5,transition:'none',width:'750px',height:'400px',href:targetUrl,scrolling:false,overlayClose:false,
			onClosed:function(){ 
				if(reload){
					window.location.reload();
				}
			}
		});
		return false;
	});
	
	//小弹窗2
	$("a[tag=detailDialog]").click(function(){
		var targetUrl = $(this).attr("targetUrl");
		var title = $(this).attr("title");
		var reload = $(this).attr("reload");
		$.colorbox({iframe:'true',title:function(){
			  return title;
			},opacity: 0.5,transition:'none',width:'800px',height:'500px',href:targetUrl,scrolling:false,overlayClose:false,
			onClosed:function(){ 
				if(reload){
					window.location.reload();
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
			},opacity: 0.5,transition:'none',width:'80%',height:'80%',href:targetUrl,overlayClose:false,
			onClosed:function(){ 
				if(reload){
					window.location.reload();
				}
			}
		});
		return false;
	});
	$("input[class=datepicker]").keydown(function(){
		return false;
	});
	$("input[class=datepicker]").datepicker();
	
	//左侧菜单事件
    $('.sidebar2-subnav .text').on('click', function (e) {
        e = e || window.event;
        e.stopPropagation();
        var subMenu = $(this).siblings('.sidebar2-subnav-menu');
        var otherSubMenu = $(this).parent().siblings().find('.sidebar2-subnav-menu');
        otherSubMenu.stop().slideUp().parents('.sidebar2-subnav').removeClass('current');
        if (subMenu.is(':hidden')) {
            subMenu.stop().slideDown().parent().addClass('current');
        } else {
            subMenu.stop().slideUp().parent().removeClass('current');
        }
    });
    /*每次请求重新加载的方式不需要这段代码
    var localPath = location.pathname.split('/').slice(0, 3).join('/') + '/';
    var currentItem = $('.sidebar2-subnav-item').removeClass('current').filter(function () {
        var matchIndex = $('a', this).attr('href').indexOf(localPath);
        return matchIndex == 0;
    }).addClass('current');
    currentItem.parents('.sidebar2-subnav').addClass('current').addClass('module-current').siblings().removeClass('current');
    currentItem.parents('.sidebar2-subnav-menu').stop().slideDown();
	*/
    
//	//初始化页面宽高
	function initWH(){
//		var height = $(window).height();
//		height -= 41;//风险控制管理系统的高度
////		$("#left_area").height(height+"px");
////		$("#right_area").height(height+"px");
//		$(".box-content").css("max-height",(height-50)+"px");
//		
		//设置列表的高度
//		height -= 37 ;//目录导航条的高度
//		var header = $(".header")?$(".header").height()+7:0;//7是div的padding-top高度
//		var bottom = $(".bottom_page")?($(".bottom_page").height()+16):0;//16是div的padding上下高度
//		var tableHeight = height - header- bottom-75;//75是分页的高度
//		var table = $(".table_style01").height();
//		if(tableHeight<table){
//			$(".table_style01").css("max-height",tableHeight+"px");
//			$(".table_style01").css("border-top","1px solid #CCCCCC");
//		}
//		var rightWidth = $(window).width() - $("#left_area").width();
//		$("#right_area").css("width",rightWidth+"px");
	}
//	initWH();
//	//改变窗口大小，自适应
//	$(window).resize( function(){
//		initWH();
//	});
//	 $(".table_style01").scroll(function(){  
//         var $this =$(this),  
//         viewH =$(this).height(),//可见高度  
//         contentH =$(this).get(0).scrollHeight,//内容高度  
//         scrollTop =$(this).scrollTop();//滚动高度  
//        //if(contentH - viewH - scrollTop <= 100) { //到达底部100px时,加载新内容  
//        if(scrollTop==(contentH -viewH)||scrollTop==0){ //到达底部100px时,加载新内容  
//        	$(".table_style01").css("border-top","0px solid #CCCCCC");
//        	$(".table_style01").css("border-bottom","0px solid #CCCCCC");
//        }  else{
//        	$(".table_style01").css("border-top","1px solid #CCCCCC");
//        	$(".table_style01").css("border-bottom","1px solid #CCCCCC");
//        }
//     });  
});
//function loadDetail(target,url){
//	$.post(url,function(result) {
//		$( "#"+target ).html(result);
//		init();
//		$( "#"+target ).css("width","100%");
//		$( "#"+target ).css("width",$( "#"+target ).width()-20);
//		$( "#"+target ).css("height",jQuery("#right_area").height()*0.5);
//	});
//}

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


/**参数说明：
 * 根据长度截取先使用字符串，超长部分追加…
 * str 对象字符串
 * len 目标字节长度
 * 返回值： 处理结果字符串
 */
function cutString(str, len) {
	//length属性读出来的汉字长度为1
	if(str.length*2 <= len) {
		return str;
	}
	var strlen = 0;
	var s = "";
	for(var i = 0;i < str.length; i++) {
		s = s + str.charAt(i);
		if (str.charCodeAt(i) > 128) {
			strlen = strlen + 2;
			if(strlen >= len){
				return s.substring(0,s.length-1) + "...";
			}
		} else {
			strlen = strlen + 1;
			if(strlen >= len){
				return s.substring(0,s.length-2) + "...";
			}
		}
	}
	return s;
}
