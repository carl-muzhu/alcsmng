/**
 * ajax�ύ����
 */
bops.ajax = {
	//ͬ��Ո��
	async : function (submitBtnId, url, param, success){
		$.ajax({
			cache : false,
			type : "POST",
			url : url,
			async : true,
			dataType : 'json',
			data : param,	//����ֵ
			success : success,
			beforeSend:function(){  
				$("#submitBtnId").attr("disabled","disabled");
			},

			//ͨӍ�ɹ����{
			success:success,
			
			//ͨӍʧ�����{
			error : function() {
				window.wxc.xcConfirm("���������쳣","error");
			},
			
			complete : function() {
				$("#submitBtnId").removeAttr("disabled");
			}
		});
	},
	
	//�첽�ύ��
	submitForm: function (submitBtnId, formId, url, success) {
		$.ajax({
			url: url,
			data:$("#"+formId).serialize(),
			type:"POST",
			beforeSend:function(){  
				$("#submitBtnId").attr("disabled","disabled");
			},

			//ͨӍ�ɹ����{
			success:success,
			
			//ͨӍʧ�����{
			error : function() {
				window.wxc.xcConfirm("�ύ�������쳣","error");
			},
			
			complete : function() {
				$("#submitBtnId").removeAttr("disabled");
			}
		});
	}
};

