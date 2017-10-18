/**
 * ajax提交函數
 */
bops.ajax = {
	//同步請求
	async : function (submitBtnId, url, param, success){
		$.ajax({
			cache : false,
			type : "POST",
			url : url,
			async : true,
			dataType : 'json',
			data : param,	//参数值
			success : success,
			beforeSend:function(){  
				$("#submitBtnId").attr("disabled","disabled");
			},

			//通訊成功回調
			success:success,
			
			//通訊失敗回調
			error : function() {
				window.wxc.xcConfirm("请求数据异常","error");
			},
			
			complete : function() {
				$("#submitBtnId").removeAttr("disabled");
			}
		});
	},
	
	//异步提交表单
	submitForm: function (submitBtnId, formId, url, success) {
		$.ajax({
			url: url,
			data:$("#"+formId).serialize(),
			type:"POST",
			beforeSend:function(){  
				$("#submitBtnId").attr("disabled","disabled");
			},

			//通訊成功回調
			success:success,
			
			//通訊失敗回調
			error : function() {
				window.wxc.xcConfirm("提交表单数据异常","error");
			},
			
			complete : function() {
				$("#submitBtnId").removeAttr("disabled");
			}
		});
	}
};

