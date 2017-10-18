jQuery.validator.addMethod("byteMaxLength", function(value,
		element, param) {
	var length = value.length;
	for ( var i = 0; i < value.length; i++) {
		if (value.charCodeAt(i) > 127) {
			length++;
		}
	}
	return this.optional(element) || (length <= param);
}, $.validator.format("不能超过{0}个字节(一个中文字算2个字节)"));

jQuery.validator.addMethod("numFormat",function(value,element,param){
 return this.optional(element) ||  /^\d*$/.test(value);
},$.validator.format("请输入数字{0}位以内")
);

jQuery.validator.addMethod("stringCheck", function(value, element) {
	return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
}, "只能包括中文字、英文字母、数字和下划线");

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
}, "请确保输入的值在{0}-{1}个字节之间(一个中文字算2个字节)");
 
//number(9,3)
jQuery.validator.addMethod("numFormat63",function(value,element){
 return this.optional(element) || /^[0-9]{1,6}(\.\d{1,3})$/.test(value);
},$.validator.format("请输入合法数字,精度格式123456.0")
);

jQuery.validator.addMethod("than0less1",function(value,element){
	return this.optional(element) || /^0\.\d*[^0]\d*$/.test(value);
},$.validator.format("请输入大于零小于一的小数"));

jQuery.validator.addMethod("than0lessequal1",function(value,element){
	return this.optional(element) || /^(1|0\.\d*[^0]\d*)$/.test(value);
},$.validator.format("请输入大于零小于等于一的小数"));

jQuery.validator.addMethod("postcodeVal",function(value,element){
 return this.optional(element) || /^[0-9]\d{5}(?!\d)$/.test(value);
},$.validator.format("请输入合法的邮编")
);
jQuery.validator.addMethod("isEmail",function(value,element){
	 return this.optional(element) || /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(value);
	},$.validator.format("请输入合法的邮箱")
	);

jQuery.validator.addMethod("numberAndLettersVal",function(value,element){
 return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
},$.validator.format("请输入字母或数字")
);



jQuery.validator.addMethod("sfzhValidate",function(value,element){
 return this.optional(element) || /^(\d{14}|\d{17})(\d|[xX])$/.test(value);
},$.validator.format("请输入合法身份证号")
);



jQuery.validator.addMethod("valiEnglish",function(value,element){
 return this.optional(element) || /^[a-zA-Z ]*$/.test(value);
},$.validator.format("请输入字母或者空格")
);


// 手机号码验证       
jQuery.validator.addMethod("isMobile", function(value, element) {
	var length = value.length;
	var mobile = /^[1][2-9]\d{9}$/;
	return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写您的手机号码");

// 电话号码验证       
jQuery.validator.addMethod("isTel", function(value, element) {
	var tel = /^\d{3,4}-?\d{7,9}$/; //电话号码格式010-12345678   
	return this.optional(element) || (tel.test(value));
}, "请正确填写您的电话号码");

// 联系电话(手机/电话皆可)验证   
jQuery.validator.addMethod("isPhone", function(value, element) {
	var length = value.length;
	var mobile = /^[1][2-9]\d{9}$/;
	var tel = /^\d{3,4}-?\d{7,9}$/;
	return this.optional(element)
			|| (tel.test(value) || mobile.test(value));

}, "请正确填写您的联系电话");

//当等于某值时提醒。
jQuery.validator.addMethod("eqWarning", function(value, element) {
	return this.optional(element)!=value;
}, "不能为空");

jQuery.validator.addMethod("selectRegion",function(value,element){
	return this.optional(element) || value>0;
},$.validator.format("请选择区域"));

//校验中文名字，包括少数民族名字
jQuery.validator.addMethod("isName", function(value, element) {
	return this.optional(element) || /^[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*$/.test(value);
}, "请输入正确的姓名");


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
},'请选择完整的省市');

//远程异步校验
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

}, "此信息已存在");


jQuery.validator.addMethod("onlyNumber",function(value,element){
	 return this.optional(element) || /^[0-9]+$/.test(value);
	},$.validator.format("请输入数字")
	);

jQuery.validator.addMethod("isBankNo",function(value,element){
	 return this.optional(element) || (/^[0-9]{16,19}$/.test(value) );
	},$.validator.format("请输入合法的银行卡号")
	);

jQuery.validator.addMethod("numberFormat",function(value,element){
	return this.optional(element) || /^[0-9]{1,8}(\.\d{0,2})?$/.test(value);
	},$.validator.format("请输入合法数字")
	);

