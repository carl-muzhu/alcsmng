jQuery.validator.addMethod("byteMaxLength", function(value,
		element, param) {
	var length = value.length;
	for ( var i = 0; i < value.length; i++) {
		if (value.charCodeAt(i) > 127) {
			length++;
		}
	}
	return this.optional(element) || (length <= param);
}, $.validator.format("���ܳ���{0}���ֽ�(һ����������2���ֽ�)"));

jQuery.validator.addMethod("numFormat",function(value,element,param){
 return this.optional(element) ||  /^\d*$/.test(value);
},$.validator.format("����������{0}λ����")
);

jQuery.validator.addMethod("stringCheck", function(value, element) {
	return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
}, "ֻ�ܰ��������֡�Ӣ����ĸ�����ֺ��»���");

jQuery.validator.addMethod("byteRangeLength", function(value, element,
		param) {
	var length = value.length;
	for (var i = 0; i < value.length; i++) {
		if (value.charCodeAt(i) > 127) {
			length++;
		}
	}
	return this.optional(element)
			|| (length >= param[0] && length <= param[1]);
}, "��ȷ�������ֵ��{0}-{1}���ֽ�֮��(һ����������2���ֽ�)");
 
//number(9,3)
jQuery.validator.addMethod("numFormat63",function(value,element){
 return this.optional(element) || /^[0-9]{1,6}(\.\d{1,3})$/.test(value);
},$.validator.format("������Ϸ�����,���ȸ�ʽ123456.0")
);

jQuery.validator.addMethod("than0less1",function(value,element){
	return this.optional(element) || /^0\.\d*[^0]\d*$/.test(value);
},$.validator.format("�����������С��һ��С��"));

jQuery.validator.addMethod("than0lessequal1",function(value,element){
	return this.optional(element) || /^(1|0\.\d*[^0]\d*)$/.test(value);
},$.validator.format("�����������С�ڵ���һ��С��"));

jQuery.validator.addMethod("postcodeVal",function(value,element){
 return this.optional(element) || /^[0-9]\d{5}(?!\d)$/.test(value);
},$.validator.format("������Ϸ����ʱ�")
);
jQuery.validator.addMethod("isEmail",function(value,element){
	 return this.optional(element) || /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(value);
	},$.validator.format("������Ϸ�������")
	);

jQuery.validator.addMethod("numberAndLettersVal",function(value,element){
 return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
},$.validator.format("��������ĸ������")
);



jQuery.validator.addMethod("sfzhValidate",function(value,element){
 return this.optional(element) || /^(\d{14}|\d{17})(\d|[xX])$/.test(value);
},$.validator.format("������Ϸ����֤��")
);



jQuery.validator.addMethod("valiEnglish",function(value,element){
 return this.optional(element) || /^[a-zA-Z ]*$/.test(value);
},$.validator.format("��������ĸ���߿ո�")
);


// �ֻ�������֤       
jQuery.validator.addMethod("isMobile", function(value, element) {
	var length = value.length;
	var mobile = /^[1][2-9]\d{9}$/;
	return this.optional(element) || (length == 11 && mobile.test(value));
}, "����ȷ��д�����ֻ�����");

// �绰������֤       
jQuery.validator.addMethod("isTel", function(value, element) {
	var tel = /^\d{3,4}-?\d{7,9}$/; //�绰�����ʽ010-12345678   
	return this.optional(element) || (tel.test(value));
}, "����ȷ��д���ĵ绰����");

// ��ϵ�绰(�ֻ�/�绰�Կ�)��֤   
jQuery.validator.addMethod("isPhone", function(value, element) {
	var length = value.length;
	var mobile = /^[1][2-9]\d{9}$/;
	var tel = /^\d{3,4}-?\d{7,9}$/;
	return this.optional(element)
			|| (tel.test(value) || mobile.test(value));

}, "����ȷ��д������ϵ�绰");

//������ĳֵʱ���ѡ�
jQuery.validator.addMethod("eqWarning", function(value, element) {
	return this.optional(element)!=value;
}, "����Ϊ��");

jQuery.validator.addMethod("selectRegion",function(value,element){
	return this.optional(element) || value>0;
},$.validator.format("��ѡ������"));

//У���������֣�����������������
jQuery.validator.addMethod("isName", function(value, element) {
	return this.optional(element) || /^[\u4E00-\u9FA5]{2,5}(?:��[\u4E00-\u9FA5]{2,5})*$/.test(value);
}, "��������ȷ������");


jQuery.validator.addMethod("completeAddr",function(prefix, element,param){
	var m = document.getElementById(param[0]+"Prov").value;
	var o = document.getElementById(param[0]+"City").value;
	var n = document.getElementById(param[0]+"District").value;
	
	if(m == '0'){
		return true;
	}
	if(o == '0'){
		return false;
	}
	return true;
},'��ѡ��������ʡ��');

//Զ���첽У��
jQuery.validator.addMethod("remoteCheck", function(value,element,param) {
	var flag = 1;
	var data_ = param[1]+"="+value+"&primaryKey="+param[2];
	if(value == '' || value== 'null' || value == undefined){
		return true;
	}
    $.ajax({  
        type:'POST',
        url:param[0],
        async:false, 
        cache : false,
        dataType : 'json',
        data: data_,
        success: function(result){
        	if (result.succ) {
        		flag = 0;
			}
        }  
    });
    if(flag == 0){
        return false;
    }else{  
        return true;
    }  

}, "����Ϣ�Ѵ���");


jQuery.validator.addMethod("onlyNumber",function(value,element){
	 return this.optional(element) || /^[0-9]+$/.test(value);
	},$.validator.format("����������")
	);

jQuery.validator.addMethod("isBankNo",function(value,element){
	 return this.optional(element) || (/^[0-9]{16,19}$/.test(value) );
	},$.validator.format("������Ϸ������п���")
	);

jQuery.validator.addMethod("numberFormat",function(value,element){
	return this.optional(element) || /^[0-9]{1,8}(\.\d{0,2})?$/.test(value);
	},$.validator.format("������Ϸ�����")
	);

