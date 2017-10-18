/**
 * 統一提示框
 */
bops.alert = {
		//成功提示框
		success : function (asyncFlag, msg, okcallback){
			if(asyncFlag) {
				myAlert("success","提示",msg); 
			} else {
				window.wxc.xcConfirm(msg, "success", {onOk : okcallback});	
			}
		},
		
		//普通提示框
		info : function (asyncFlag, msg, okcallback){
			if(asyncFlag) {
				myAlert("info","提示",msg); 
			} else {
				window.wxc.xcConfirm(msg, "info", {onOk : okcallback});	
			}
		},
				
		//錯誤提示框
		error : function (asyncFlag, msg, okcallback){
			if(asyncFlag) {
				myAlert("error","提示",msg); 
			} else {
				window.wxc.xcConfirm(msg, "error", {onOk : okcallback});
			}

		},
			
		//警告提示框
		warn : function (asyncFlag, msg, okcallback){
			if(asyncFlag) {
				myAlert("warning","警告",msg); 
			} else {
				window.wxc.xcConfirm(msg, "warning", {onOk : okcallback});
			}
		},
		
		//確認提示框
		confirm : function (msg, okcallback){
			window.wxc.xcConfirm(msg, "confirm", {onOk : okcallback});
		}
		
};

