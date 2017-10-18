var infoObj ;
function myAlert(type,result,content,target,position,timeout){
	hideAll();
	$("div[tag="+type+"]").find("strong:first").html(result);
	$("div[tag="+type+"]").find("p:first").html(content);
	infoObj = $( "div[tag="+type+"]" );
	if(target){
		if(!position){
			position="after"
		}
		if(position=="after"){
			$("#"+target).after( infoObj);
		}else if(position=="before"){
			$("#"+target).before( infoObj);
		}
	}
	$("div[tag="+type+"]" ).css("display","block");
	if(timeout){
		setTimeout("hideInfo()",timeout);
	}
}
function hideAll(){
	$("div[tag=success]" ).css("display","none");
	$("div[tag=error]" ).css("display","none");
	$("div[tag=warning]" ).css("display","none");
	$("div[tag=info]" ).css("display","none");
}
function hideInfo(){
	infoObj.css("display","none");
}
$(document).ready(function(e) {
	$("button[class=close]").click(function(){
		$(this).parent().css("display","none");
	});
});

