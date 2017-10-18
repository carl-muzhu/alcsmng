bops.render = {
	easyui:null,
	basePath : basePath,
	//�첽��Ⱦ���������Ը���url���棬Ҳ���Է���param���������Ĳ���ֵֻ��ʹ��param��
	renderModule : function (moduleId,url,param,callback){
		$.ajax({
			url : bops.basePath + url,
			type : 'post',
			async : true,
			data : param,	//����ֵ
			success : function(result) {
				$("#"+moduleId).html(result);
				if (callback) {
					callback();
				}
			},
			error : function() {
				var error 
					="#set($layout='layout/iframe.vm')"
					+"<div class='table_style01'>"
					+ 	"<fieldset>"
					+ 		"<legend>�������������쳣</legend>"
					+ 	"</fieldset>"
					+"</div>";
				$("#"+moduleId).html(error);
			}
		});
	},
	//�ӳ���Ⱦ����Ҫʹ�ñ����ص������ٴμ��أ�ids���д����Ԫ��ID�ᵼ��setTimeoutЧ�����setIntervalЧ����
	delayRender : function(ids,moduleId,url,param,callback) {
		bops._timer = setTimeout(function(){
			if(ids!=null && ids!=undefined && ids.length>0){
				if(!param){
					param = new Object();
				}
				for(var i in ids){
					if ($("#"+ids[i]).val()==undefined) {
						bops.delayRender(ids,moduleId,url,param,callback);
						return;
					}
					param[ids[i]]=$("#"+ids[i]).val();
				}
				bops.renderModule(moduleId,url,param,callback);
			}
		}, 500);
	},
	//����ģ��
	appendModule : function(markId,moduleId,url,param,callback){
		if(!param){
			param = new Object();
		}
		param['markId'] = "divno" + markId;
		$.ajax({
			url : bops.basePath + url,
			type : 'post',
			async : true,
			data : param,	//����ֵ
			success : function(result) {
				$("#"+moduleId).append(result);
				if (callback) {
					callback();
				}
			},
			error : function() {
				var error 
					="<div class='table_style01' id='divno"+markId+"'>"
					+ 	"<fieldset>"
					+ 		"<legend>�������������쳣</legend>"
					+ 	"</fieldset>"
					+"</div>";
				$("#"+moduleId).append(error);
			}
		});
	},
	//ɾ��ģ��
	removeModule : function(markId){
		$("#"+markId).remove();
	}
}

