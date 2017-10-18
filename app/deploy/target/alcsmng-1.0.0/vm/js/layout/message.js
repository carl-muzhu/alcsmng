$(document).ready(function() { 
    jump(3); 
}); 
function jump(count) { 
    window.setTimeout(function(){ 
        count--; 
        if(count > 0) { 
            $('#num').html( count); 
            jump(count); 
        } else { 
        	//返回并刷新页面
        	window.location.href=document.referrer; 
        } 
    }, 1000); 
}