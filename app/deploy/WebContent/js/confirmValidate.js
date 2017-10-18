//(1)required:true               �����ֶ�  
//(2)remote:"check.php"          ʹ��ajax��������check.php��֤����ֵ  
//(3)email:true                  ����������ȷ��ʽ�ĵ����ʼ�  
//(4)url:true                    ����������ȷ��ʽ����ַ  
//(5)date:true                   ����������ȷ��ʽ������  
//(6)dateISO:true                ����������ȷ��ʽ������(ISO)�����磺2009-06-23��1998/01/22 ֻ��֤��ʽ������֤��Ч��  
//(7)number:true                 ��������Ϸ�������(����С��)  
//(8)digits:true                 ������������  
//(9)creditcard:                 ��������Ϸ������ÿ���  
//(10)equalTo:"#field"           ����ֵ�����#field��ͬ  
//(11)accept:                    ����ӵ�кϷ���׺����ַ��ϴ��ļ��ĺ�׺��  
//(12)maxlength:5                ���볤�������5���ַ�(������һ���ַ�)  
//(13)minlength:10               ���볤����С��10���ַ�(������һ���ַ�)  
//(14)rangelength:[5,10]         ���볤�ȱ������ 5 �� 10 ֮����ַ�")(������һ���ַ�)  
//(15)range:[5,10]               ����ֵ������� 5 �� 10 ֮��  
//(16)max:5                      ����ֵ���ܴ���5  
//(17)min:10                     ����ֵ����С��10  

//����Ϣ
function validateJBXX(form){
	return $(form).validate({
    	rules : {
    		age:{number : true,required:true,range:[1,120]},
    		maritalStatus:{required:true},
    		mobile:{number : true,required:true,isMobile:true},
    		degree:{required:true},
    		familyRegCode:{required:true},
    		qq:{number:true},
    		tel:{number:true,isTel:true},
    		mail:{email : true},
    		familyReg:{required:true}
    	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
     }).form(); 
}
//��ͥ
function validateContact(form){
	return $(form).validate({
    	rules : {
    		age:{digits:true  },
    		mobile:{number : true,isMobile:true}
    		//certNo:{number : true}
    		//memo:{byteMaxLength:125*2},
    		//linkerIdNo:{sfzhValidate : true}
    	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
     }).form(); 
}
//��ҵ
function validateFirm(form){
	return $(form).validate({
    	rules : {
    		instCode:{number : true,required:true},
    		taxNo:{number : true,required:true},
    		regAmt:{number : true,required:true},
    		realAmt:{number : true,required:true}
    	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
     }).form(); 
}
//���߼���������Ϣ
function validateLaw(form){
	return $(form).validate({
    	rules : {
    		relatedAmt:{number : true,required:true},
    		//verdict:{byteMaxLength:60*2},
			//memo:{byteMaxLength:30*2},
    	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
     }).form(); 
}
//����
function validateHouse(form){
	return $(form).validate({
    	rules : {
    		buyPrice:{number : true,required:true},
    		houseOwnerNo:{number : true,required:true},
    		coverage:{number : true,required:true},
    		landCardNo:{number : true},
    		houseDeedNo:{number : true},
    		coverage:{number : true,required:true},
    		marketPrice:{number : true,required:true},
    		assessPrice:{number : true},
    		totalFloors:{number : true,required:true},
    		currFloor:{number : true,required:true},
    		cfmAmt:{number : true},
    		taxAmt:{number : true},
    		loanAmt:{number : true},
    		addr:{required:true},
    	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
     }).form(); 
}
//��
function validateCar(form){
	return $(form).validate({
    	rules : {
    		buyPrice:{number : true},
    		marketPrice:{number : true},
    		engineNo:{number : true},
    		idenCode:{number : true},
    		mileAge:{number : true},
    		useAge:{number : true},
    		frameNo:{number : true},
    		unpayAmt:{number : true},
    		guarantyCounts:{number : true},
    	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
     }).form(); 
}

//��Ӫ�ʲ�
function validateOtherasset(form){
	return $(form).validate({
  	rules : {
  		assetPrice:{number : true,required:true},
  	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
   }).form(); 
}
//��Ӫ�Ը�ծ
function validateDebt(form){
	return $(form).validate({
  	rules : {
  		debtAmt:{number : true,required:true},
  	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
   }).form(); 
}
//��ծ
function validateCreditloan(form){
	return $(form).validate({
  	rules : {
  		loanAmt:{number : true,required:true},
  		loanInterest:{number : true},
  		nopayAmt:{number : true}
  	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
   }).form(); 
}
//���ÿ�
function validateCreditcard(form){
	return $(form).validate({
  	rules : {
  		overdueAcctNum:{number : true},
  		overdueMonthNum:{number : true},
  		overdueMonthMaxAmt:{number : true},
  		overdueMonthMaxNum:{number : true},
  		cardInstNum:{number : true},
  		cardReprNum:{number : true},
  		currAcctNum:{number : true},
  		totalCreditAmt:{number : true},
  		minCreditAmt:{number : true},
  		maxCreditAmt:{number : true},
  		usedCreditAmt:{number : true},
  		monthUseAmt:{number : true},
  		nonNormalNum:{number : true},
  		usageRatio:{number : true},
  		currentOverdueAmt:{number : true},
  		
  	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
   }).form(); 
}
//���ⵣ�����
function validateGuarantee(form){
	return $(form).validate({
  	rules : {
  		loanAmt:{number : true,required:true},
  		guaranteeAmt:{number : true},
  		loanInterest:{number : true},
  		remainAmt:{number : true},
  		repayType:{required:true},
  	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
   }).form(); 
}
//���ڼ�¼ͳ��
function validateCreditDetail(form){
	return $(form).validate({
  	rules : {
  		dkm31:{digits : true},
  		dkm32:{digits : true},
  		dkm33:{digits : true},
  		dkm61:{digits : true},
  		dkm62:{digits:true},
  		dkm63:{digits:true},
  		dkm121:{digits : true},
  		dkm122:{digits : true},
  		dkm123:{digits : true},
  		dkm241:{digits : true},
  		dkm242:{digits:true},
  		dkm243:{digits:true},
  		xykm31:{digits : true},
  		xykm32:{digits : true},
  		xykm33:{digits : true},
  		xykm61:{digits : true},
  		xykm62:{digits:true},
  		xykm63:{digits:true},
  		xykm121:{digits : true},
  		xykm122:{digits : true},
  		xykm123:{digits : true},
  		xykm241:{digits : true},
  		xykm242:{digits:true},
  		xykm243:{digits:true},
  	},
		invalidHandler : function(form, validator) { ////δͨ��?��֤ ��ͨ��ص�
			return false;
		}
   }).form(); 
}
