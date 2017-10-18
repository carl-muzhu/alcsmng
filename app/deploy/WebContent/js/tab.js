 function resetTabs(){
        $("#tab_content > div").hide(); // Hide all tab_content
        $("#tabs a").attr("id",""); // Reset id's
    }

    var myUrl = window.location.href; // get URL
    var myUrlTab = myUrl.substring(myUrl.indexOf("#")); // For
														// localhost/tabs.html#tab2,
														// myUrlTab = #tab2
    var myUrlTabName = myUrlTab.substring(0,4); // For the above example,
												// myUrlTabName = #tab
    (function(){
        $("#tab_content > div").hide(); // Initially hide all tab_content
        
        var currTabName = $("#currTabName").val();
        if(currTabName){//tab切换历史bug，通过name查询靠谱 cyj
        	$("#tabs li a[name=#"+currTabName+"]").attr("id","current");
        	$("#tab_content > div[id="+currTabName+"]").fadeIn();
        }else{
        	var curIndex=0;
            if( $("#currIndex").length > 0){
            	curIndex=parseInt($("#currIndex").val());
            }
            var ll= $("#tabs li")[curIndex];
            	$(ll).find("a").attr("id","current"); // Activate first tab
            var dd=$("#tab_content > div")[curIndex];
            	$(dd).fadeIn(); // Show first tab tab_content
        }
        
        $("#tabs a").on("click",function(e) {
        	$($(this).attr('name')+"_detail").css('display','none'); 
            e.preventDefault();
            if ($(this).attr("id") == "current"){ // detection for current tab
             return       
            }
            else{             
            resetTabs();
            $(this).attr("id","current"); // Activate this
            $($(this).attr('name')).fadeIn(); // Show tab_content for current
												// tab
            try{if(callbackFunc)callbackFunc($(this).attr('name'));}catch(e){}
            }
        });

        for (i = 1; i <= $("#tabs li").length; i++) {
          if (myUrlTab == myUrlTabName + i) {
              resetTabs();
              $("a[name='"+myUrlTab+"']").attr("id","current"); // Activate url
																// tab
              $(myUrlTab).fadeIn(); // Show url tab tab_content
          }
        }
    })()
    
    
    function gotoTab(tabName){
    	 resetTabs();
              $("a[name='"+tabName+"']").attr("id","current"); // Activate url
																// tab
              $(tabName).fadeIn(); // Show url tab tab_content
    }