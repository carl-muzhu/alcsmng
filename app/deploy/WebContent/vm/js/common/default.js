$(document).ready(function() {
	$.datepicker.regional['zh-HK'] = {
            closeText: '�ر�',
            prevText: '&#x3c;����',
            nextText: '����&#x3e;',
            currentText: '����',
            monthNames: ['һ��','����','����','����','����','����',
            '����','����','����','ʮ��','ʮһ��','ʮ����'],
            monthNamesShort: ['һ','��','��','��','��','��',
            '��','��','��','ʮ','ʮһ','ʮ��'],
            dayNames: ['������','����һ','���ڶ�','������','������','������','������'],
            dayNamesShort: ['����','��һ','�ܶ�','����','����','����','����'],
            dayNamesMin: ['��','һ','��','��','��','��','��'],
            weekHeader: '��',
            dateFormat: 'yy-mm-dd',
            firstDay: 0,
            isRTL: false,
            showMonthAfterYear: false,
            yearSuffix: '��'};
    $.datepicker.setDefaults($.datepicker.regional['zh-HK']);
	//�����б�ť�¼���
	$('button[tag=returnList]').bind('click',function(){
		window.location=$(this).attr('href');
		return false;
	});
	//���ð�ť
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
	//���ذ�ť
	$('button[tag=goBack]').bind('click',function(){
		history.back();
	});
	//����
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
	//С����1
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
	//С����2
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
	
	//С����2
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
	
	//iframe����
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
	
	//���˵��¼�
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
    /*ÿ���������¼��صķ�ʽ����Ҫ��δ���
    var localPath = location.pathname.split('/').slice(0, 3).join('/') + '/';
    var currentItem = $('.sidebar2-subnav-item').removeClass('current').filter(function () {
        var matchIndex = $('a', this).attr('href').indexOf(localPath);
        return matchIndex == 0;
    }).addClass('current');
    currentItem.parents('.sidebar2-subnav').addClass('current').addClass('module-current').siblings().removeClass('current');
    currentItem.parents('.sidebar2-subnav-menu').stop().slideDown();
	*/
    
//	//��ʼ��ҳ����
	function initWH(){
//		var height = $(window).height();
//		height -= 41;//���տ��ƹ���ϵͳ�ĸ߶�
////		$("#left_area").height(height+"px");
////		$("#right_area").height(height+"px");
//		$(".box-content").css("max-height",(height-50)+"px");
//		
		//�����б�ĸ߶�
//		height -= 37 ;//Ŀ¼�������ĸ߶�
//		var header = $(".header")?$(".header").height()+7:0;//7��div��padding-top�߶�
//		var bottom = $(".bottom_page")?($(".bottom_page").height()+16):0;//16��div��padding���¸߶�
//		var tableHeight = height - header- bottom-75;//75�Ƿ�ҳ�ĸ߶�
//		var table = $(".table_style01").height();
//		if(tableHeight<table){
//			$(".table_style01").css("max-height",tableHeight+"px");
//			$(".table_style01").css("border-top","1px solid #CCCCCC");
//		}
//		var rightWidth = $(window).width() - $("#left_area").width();
//		$("#right_area").css("width",rightWidth+"px");
	}
//	initWH();
//	//�ı䴰�ڴ�С������Ӧ
//	$(window).resize( function(){
//		initWH();
//	});
//	 $(".table_style01").scroll(function(){  
//         var $this =$(this),  
//         viewH =$(this).height(),//�ɼ��߶�  
//         contentH =$(this).get(0).scrollHeight,//���ݸ߶�  
//         scrollTop =$(this).scrollTop();//�����߶�  
//        //if(contentH - viewH - scrollTop <= 100) { //����ײ�100pxʱ,����������  
//        if(scrollTop==(contentH -viewH)||scrollTop==0){ //����ײ�100pxʱ,����������  
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

//�������ز�  
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
//�رյ�����  
function hideScreenCover() {
    document.getElementById("fullScreenCover").style.display = 'none';  
}; 


/**����˵����
 * ���ݳ��Ƚ�ȡ��ʹ���ַ�������������׷�ӡ�
 * str �����ַ���
 * len Ŀ���ֽڳ���
 * ����ֵ�� �������ַ���
 */
function cutString(str, len) {
	//length���Զ������ĺ��ֳ���Ϊ1
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
