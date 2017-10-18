function validateField(form){
	var result = true;
	var message = "±ØÌî×Ö¶Î";
	$(form).find("span[style='color:red']").each(function(){
		    var filedId = $(this).parent().attr("for");
		    if(filedId){
		    	var obj;
		    	if($("[name="+filedId+"]").eq(0)){
		    		obj=$("[name="+filedId+"]");
		    	}else if($("#"+filedId)){
		    		obj=$("#"+filedId);
		    	}
		    	if(obj&&!obj.val()){
		    		result =false;
		    		if(obj.parent().prop("nodeName")=="SPAN"){
		    			if(obj.parent().parent().children("p").text()!=message){
		    				obj.parent().parent().append("<p style='color:red'>"+message+"</p>");
		    			}
		    		}else if(obj.attr("tag")=="clientComponent"||obj.attr("tag")=="userComponent"||filedId=="loanLimit"){
		    			if(obj.parent().children("p").text()!=message){
		    				obj.parent().append("<p style='color:red'>"+message+"</p>");
		    			}
		    		}else if(obj.parent().children("p").text()!=message){
		    			obj.parent().append("<p style='color:red'>"+message+"</p>");
		    		}
		    	}else if(obj&&(obj.next("p").text()==message||obj.parent().children("p").text()==message)){
		    			obj.parent().children("p").remove();
		    	}
		    }
	});
	return result;
}