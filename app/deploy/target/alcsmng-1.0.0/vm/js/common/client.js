function showinfo(info_id) {
	$("#" + info_id + "_info").toggle();
	$("#" + info_id + "_show").toggle();
	$("#" + info_id + "_hidden").toggle();
}

function addNew(type, clientNo, clientType){
	var index = $("#"+type+"_num").val();
	addInfo(type,index,clientNo, clientType);
	index++;
	$("#"+type+"_num").val(index);
}

function deleteInfo(type,index){
	$("#"+type+"_info"+index).remove();	
}

function addInfo(type, index, clientNo, clientType, assetId) {
	var info = type.toUpperCase();
	var temp = 'person';
	if(clientType == "INST") temp = "inst";
	switch (info) {
	case "CAR"://车
		$.get(basePath + "/background/asset/"+temp+"/carInfo.htm", {
			index : index,
			clientNo : clientNo,
			assetId : assetId
		}, function(data) {
			$("#Car_List").append(data);
		}, "html");
		break;
	case "HOUSE"://房
		$.get(basePath + "/background/asset/"+temp+"/houseInfo.htm", {
			index : index,
			clientNo : clientNo,
			assetId : assetId
		}, function(data) {
			$("#House_List").append(data);
		}, "html");
		break;
	case "OTHERASSET"://其它资产
		$.get(basePath + "/background/asset/"+temp+"/otherAssetInfo.htm", {
			index : index,
			clientNo : clientNo,
			assetId : assetId
		}, function(data) {
			$("#OtherAsset_List").append(data);
		}, "html");
		break;
		
	case "GOODS"://存货资产
		$.get(basePath + "/background/asset/"+temp+"/goodsInfo.htm", {
			index : index,
			clientNo : clientNo,
			assetId : assetId,
			timeStamp : new Date().getTime()
		}, function(data) {
			$("#Goods_List").append(data);
		}, "html");
		break;	
	}
}

//设置编辑状态 flag：true表示可以编辑，false表示不可以编辑
function setEditStatus(submitBtnId, editBtnId, formId, flag) {
	if(flag) {
		$('#'+submitBtnId).show();
		$('#'+editBtnId).hide();
	} else {
		$('#'+submitBtnId).hide();
		$('#'+editBtnId).show();
	}
	$("form[id="+formId+"] select").prop("disabled", !flag);
	$("form[id="+formId+"] input[type!='button']").prop("disabled", !flag);
	$("form[id="+formId+"] textarea").prop("disabled", !flag);
}


//编辑
function edit(submitBtnId, editBtnId, formId) {
	setEditStatus(submitBtnId, editBtnId, formId, true);
}

//加载数据初始化
function init(assetId, submitBtnId, editBtnId, formId, flag) {
	var asset = $("#"+assetId).val();
	if(asset) {
		setEditStatus(submitBtnId, editBtnId, formId, false);
	} else {
		setEditStatus(submitBtnId, editBtnId, formId, true);
	}
}

//删除单条资产记录
function deleteItem(assetId, type, index, url){
	var asset = $("#"+assetId).val();
	if(asset) {
		$.dialog.confirm('你确定要删除吗？', function(){
			$.ajax({
    			url:url,
    			data:{
    				assetId : asset
    			},
    			type:"POST",
    			beforeSend:function(){  
    				//$('#submitButton').hide();
    				//$('#editRealMsgImg').show();
    			},

        		success:function(result) {
        			if (typeof(result) != 'object') {
        				result = eval('(' + result + ')');
        			}
        			if(result.succ){
        				deleteInfo(type,index);
            			$.dialog.tips('删除成功');
        			} else {
        				$.dialog.tips("刪除失败："+result.err_msg);
        			}
        		}
    		});
		}, function(){
		    $.dialog.tips('你取消了操作');
		});
	} else {
		deleteInfo(type,index);
	}
}

//异步提交表单
function ajaxSubmitForm(url, formId, submitBtnId, editBtnId, assetId) {
	$.ajax({
		url: url,
		data:$("#"+formId).serialize(),
		type:"POST",
		beforeSend:function(){  
			//$('#submitButton').hide();
			//$('#editRealMsgImg').show();
		},

		success:function(result) {
			if (typeof(result) != 'object') {
				result = eval('(' + result + ')');
			} 
			if(result.succ == true){
				setEditStatus(submitBtnId, editBtnId, formId, false);
				$("#"+assetId).val(result.id);
				$.dialog.tips('提交成功');
			} else {
				$.dialog.alert('提交失败：'+result.err_msg);
			} 
		}
	});
}



