$(document).ready(function(){
	$("#selectofsearchType").html($("#selectchildsearchType li:first").text());
	$("#search_content").attr("name",$("#selectchildsearchType li:first").attr("id"));
	$("#selectofsearchType").click(function(){
		toggleDisplay("selectchildsearchType");
	});
	$("#selectchildsearchType li[tag=searchTag]").click(function(){
		$("#selectofsearchType").html($(this).text());
		toggleDisplay("selectchildsearchType");
		$("#search_content").attr("name",$(this).attr("id"));
	});
	$("#Hsearch div[class='date tit']").click(function(){
		if($("#Hsearch div[class=hid]").css("display")=="none"){
			$("#Hsearch div[class=hid]").css("display","block");
		}else{
			$("#Hsearch div[class=hid]").css("display","none");
		}
	});
	$("input[tag=deptComponent").combotree({
	    url:basePath+"/background/dept/deptTree.json"
	});  
});
function toggleDisplay(id){
	if($("#"+id).css("display")=="none"){
		$("#"+id).css("display","block");
	}else{
		$("#"+id).css("display","none");
	}
}