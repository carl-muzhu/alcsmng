/**
 * �yһ��ʾ��
 */
bops.alert = {
		//�ɹ���ʾ��
		success : function (asyncFlag, msg, okcallback){
			if(asyncFlag) {
				myAlert("success","��ʾ",msg); 
			} else {
				window.wxc.xcConfirm(msg, "success", {onOk : okcallback});	
			}
		},
		
		//��ͨ��ʾ��
		info : function (asyncFlag, msg, okcallback){
			if(asyncFlag) {
				myAlert("info","��ʾ",msg); 
			} else {
				window.wxc.xcConfirm(msg, "info", {onOk : okcallback});	
			}
		},
				
		//�e�`��ʾ��
		error : function (asyncFlag, msg, okcallback){
			if(asyncFlag) {
				myAlert("error","��ʾ",msg); 
			} else {
				window.wxc.xcConfirm(msg, "error", {onOk : okcallback});
			}

		},
			
		//������ʾ��
		warn : function (asyncFlag, msg, okcallback){
			if(asyncFlag) {
				myAlert("warning","����",msg); 
			} else {
				window.wxc.xcConfirm(msg, "warning", {onOk : okcallback});
			}
		},
		
		//�_�J��ʾ��
		confirm : function (msg, okcallback){
			window.wxc.xcConfirm(msg, "confirm", {onOk : okcallback});
		}
		
};

