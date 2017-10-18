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
	case "CAR"://��
		$.get(basePath + "/background/asset/"+temp+"/carInfo.htm", {
			index : index,
			clientNo : clientNo,
			assetId : assetId
		}, function(data) {
			$("#Car_List").append(data);
		}, "html");
		break;
	case "HOUSE"://��
		$.get(basePath + "/background/asset/"+temp+"/houseInfo.htm", {
			index : index,
			clientNo : clientNo,
			assetId : assetId
		}, function(data) {
			$("#House_List").append(data);
		}, "html");
		break;
	case "OTHERASSET"://�����ʲ�
		$.get(basePath + "/background/asset/"+temp+"/otherAssetInfo.htm", {
			index : index,
			clientNo : clientNo,
			assetId : assetId
		}, function(data) {
			$("#OtherAsset_List").append(data);
		}, "html");
		break;
		
	case "GOODS"://����ʲ�
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

//���ñ༭״̬ flag��true��ʾ���Ա༭��false��ʾ�����Ա༭
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


//�༭
function edit(submitBtnId, editBtnId, formId) {
	setEditStatus(submitBtnId, editBtnId, formId, true);
}

//�������ݳ�ʼ��
function init(assetId, submitBtnId, editBtnId, formId, flag) {
	var asset = $("#"+assetId).val();
	if(asset) {
		setEditStatus(submitBtnId, editBtnId, formId, false);
	} else {
		setEditStatus(submitBtnId, editBtnId, formId, true);
	}
}

//ɾ�������ʲ���¼
function deleteItem(assetId, type, index, url){
	var asset = $("#"+assetId).val();
	if(asset) {
		$.dialog.confirm('��ȷ��Ҫɾ����', function(){
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
            			$.dialog.tips('ɾ���ɹ�');
        			} else {
        				$.dialog.tips("�h��ʧ�ܣ�"+result.err_msg);
        			}
        		}
    		});
		}, function(){
		    $.dialog.tips('��ȡ���˲���');
		});
	} else {
		deleteInfo(type,index);
	}
}

//�첽�ύ��
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
				$.dialog.tips('�ύ�ɹ�');
			} else {
				$.dialog.alert('�ύʧ�ܣ�'+result.err_msg);
			} 
		}
	});
}



