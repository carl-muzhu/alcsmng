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
        	//���ز�ˢ��ҳ��
        	window.location.href=document.referrer; 
        } 
    }, 1000); 
}