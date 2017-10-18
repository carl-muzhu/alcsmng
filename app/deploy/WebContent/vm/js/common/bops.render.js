bops.render = {
	easyui:null,
	basePath : basePath,
	//异步渲染（参数可以跟在url后面，也可以放在param，但是中文参数值只能使用param）
	renderModule : function (moduleId,url,param,callback){
		$.ajax({
			url : bops.basePath + url,
			type : 'post',
			async : true,
			data : param,	//参数值
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
					+ 		"<legend>请求数据网络异常</legend>"
					+ 	"</fieldset>"
					+"</div>";
				$("#"+moduleId).html(error);
			}
		});
	},
	//延迟渲染，需要使用被加载的数据再次加载（ids含有错误的元素ID会导致setTimeout效果变成setInterval效果）
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
	//增加模块
	appendModule : function(markId,moduleId,url,param,callback){
		if(!param){
			param = new Object();
		}
		param['markId'] = "divno" + markId;
		$.ajax({
			url : bops.basePath + url,
			type : 'post',
			async : true,
			data : param,	//参数值
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
					+ 		"<legend>请求数据网络异常</legend>"
					+ 	"</fieldset>"
					+"</div>";
				$("#"+moduleId).append(error);
			}
		});
	},
	//删除模块
	removeModule : function(markId){
		$("#"+markId).remove();
	}
}

