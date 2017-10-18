$(document).ready(function() {
	var pageCount = parseInt($("input[name='pageCount']").val());
	var pageNow = parseInt($("input[name='pageNow']").val());
	if(pageCount>10){
		if(pageNow>3){
			$("#pagination ul li:eq(1)").append("<li><a class='page-crt'>...</a></li>");
		}
		for(var i=(pageNow-2);i<(pageNow+3);i++){
			if(i>0&&i<=pageCount){
				var li = "<li><a  ";
				if(i==pageNow) {
					li += "class='page-cur'" ;
				}
				li +="href='#' page="+i+">"+i+"</a></li>";
				$("#pagination ul li:eq(1)").append(li);
			}
		}
		if(pageNow<pageCount-2){
			$("#pagination ul li:eq(1)").append("<li><a class='page-crt'>...</a></li>");
		}
	}else{
		for(var i=1;i<=pageCount;i++){
			var li = "<li><a  ";
			if(i==pageNow) {
				li += "class='page-cur'" ;
			}
			li +="href='#' page="+i+">"+i+"</a></li>";
			$("#pagination ul li:eq(1)").append(li);
		}
	}
	$("#pagination a").bind('click',function(){
		var page = $(this).attr('page');
		if($("#pageSize").val()<1){
			$("#pageSize").val(5);
		}
		if(!page){
			return false;
		}
		$("#pagination input[name=pageNow]").val(page);
		if(page<1||page>pageCount||page==pageNow){
			return false;
		}
		//var submitForm = $(this).closest("form").prevAll("#advanced_Search_form:first");
		var submitForm = $("#advanced_Search_form");
		if(submitForm.length > 0){
			submitForm.append("<input type='hidden' name='pageNow' value='"+page+"'>");
			submitForm.append("<input type='hidden' name='pageSize' value='"+$("#pageSize").val()+"'>");
			submitForm.submit();
		}else{
			 $(this).closest("form").submit();
		}
	});
	$("#pageSize").change(function(){
		if($("#pageSize").val()<1){
			$("#pageSize").val(5);
		}
		$.each($(':input[name=pageSize]'),function(n,e) { 
			$(this).val($("#pageSize").val());
		});
		reloadCurPage(1);
	});
});

function reloadCurPage(pageNow){
	var pageCount = parseInt($("input[name='pageCount']").val());
	if(!pageNow){
		pageNow = parseInt($("input[name='pageNow']").val());
		if(pageNow<1||pageNow>pageCount){
			return false;
		}
	}
	var submitForm = $("#advanced_Search_form");
	if(submitForm.length > 0){
		submitForm.append("<input type='hidden' name='pageNow' value='"+pageNow+"'>");
		submitForm.append("<input type='hidden' name='pageSize' value='"+$("#pageSize").val()+"'>");
		submitForm.submit();
	}
}