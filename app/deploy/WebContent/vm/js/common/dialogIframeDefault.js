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
	//С����
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
	
	//iframe����
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
	//��ʼ��ҳ����
	initBottomBar();
	jQuery.ajaxSetup({     
	    contentType:"application/x-www-form-urlencoded;charset=utf-8",     
	    error:function(XMLHttpRequest,textStatus,errorMsg){  
	        // ͳһ����ajax��½��ʱ����½��ʱ������������403���Լ����س�ʱ����Ϣ
	    	if(top.sessionTimeoutProcess)
	        top.sessionTimeoutProcess(XMLHttpRequest,textStatus,errorMsg);
	    }    
	});
});

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
function initBottomBar(){
	if($("#right_area").find(".diaDivBottom").length>0){
		var hei = $("#right_area").height();
		$("#right_area").height(hei-41-10);
	}
}