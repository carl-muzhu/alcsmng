$(document).ready(function(e) {
	//showScreenCover();
	$("#dialogIframe").load(function(){
		hideScreenCover();
	});
	$("a[tag=colorBoxLeftMenu]").click(function(){
		showScreenCover();
		$.each($(this).parent().parent().children(),function(n,collaNo) { 
			$(this).css("background","#fff");
		});
		$(this).parent().css("background","#dce9f9");
		var targetUrl = $(this).attr("target");
		var key = $(this).attr("key");
		if(key!=""){
			var arr= key.split(",");
			for(var i=0;i<arr.length;i++){
				if(arr[i]!=0){
					var newData = arr[i]+"="+$('#'+arr[i]).val()+"&";
					targetUrl = targetUrl.replace(arr[i]+"=&",newData);
				}
			}
		}
		$("#dialogIframe").attr("src",targetUrl);
		return false;
	});
});