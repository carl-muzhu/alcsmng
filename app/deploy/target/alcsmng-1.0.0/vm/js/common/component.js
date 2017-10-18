$(document).ready(function(){
	var initUser = true;
	var initClient = true;
	//���������
	$("input[tag=deptComponent]").combotree({
	    url:basePath+"/background/dept/deptTree.json",
	    panelWidth: 300,
	    panelHeight:300
	});
	//���в��������
	$("input[tag=allDeptComponent]").combotree({
	    url:basePath+"/background/dept/allDeptTree.json",
	    panelWidth: 300,
	    panelHeight:300
	});
	
	//�û�ѡ����������������û�
	var selectRow;
	var artChanged;
	$("input[tag=userComponent]").combogrid({
		panelWidth: 320,
		idField: "userId",
		textField: "userRealname",
		url: basePath+"/background/user/searchUser.json",
		method: "POST",
		onBeforeLoad: function(param){
			//���ڻ���ԭֵ�����һ��ҳ��������userComponent����Ҫ����д��������ԵĻ�ȫ���ǵ�һ�������ֵ
			if(initUser&&$("input[tag=userComponent]")){
				initUser = false;
				param.userId = $("input[tag=userComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
	        artChanged = true;//��¼�Ƿ��иı䣨���ֶ�����ʱ����)  
	    },
	    onSelect: function (index, row) {  
	        selectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (artChanged) {  
	            if (selectRow ==null  || t != selectRow.userId) {//û��ѡ�����ѡ����ʱ�������  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something...  
	            }  
	        }  
	        artChanged = false;  
	        selectRow = null;  
	    },  
		columns: [[
			{field:"userName",title:"�û���",width:98},
			{field:"userRealname",title:"����",width:100},
			{field:"userPhone",title:"�ֻ�����",width:100}
		]],
		mode: "remote"
	});
	//�û�ѡ������������û�
	var allUserSelectRow;
	var allUserArtChanged;
	$("input[tag=allUserComponent]").combogrid({
		panelWidth: 320,
		idField: "userId",
		textField: "userRealname",
		url: basePath+"/background/user/searchUser.json?allUsers=true",
		method: "POST",
		onBeforeLoad: function(param){
			//���ڻ���ԭֵ�����һ��ҳ��������allUserComponent����Ҫ����д��������ԵĻ�ȫ���ǵ�һ�������ֵ
			if(initUser&&$("input[tag=allUserComponent]")){
				initUser = false;
				param.userId = $("input[tag=allUserComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			allUserArtChanged = true;//��¼�Ƿ��иı䣨���ֶ�����ʱ����)  
	    },
	    onSelect: function (index, row) {  
	    	allUserSelectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (allUserArtChanged) {  
	            if (allUserSelectRow ==null  || t != allUserSelectRow.userId) {//û��ѡ�����ѡ����ʱ�������  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something...  
	            }  
	        }  
	        allUserArtChanged = false;  
	        allUserSelectRow = null;  
	    },  
//	    onLoadSuccess:function(data){  
//	    	if(typeof(user)!="undefined"&&user&&initUser){
//	    		initUser = false;
//	    		var hasRow = false;
//	    		$(data.rows).each(function(i,n){
//	    			if(user.userName==n.userName){
//	    				hasRow = true;
//	    			}
//	    		});
//	    		if(!hasRow){
//	    			data.rows.push(user);
//	    			data.total +=1;
//	    		}
//	    		$(this).combogrid("grid").datagrid("loadData", data.rows);
//	    		$(this).combogrid("setValue", user.userId);  
//	    	}
//	    },
		columns: [[
			{field:"userName",title:"�û���",width:98},
			{field:"userRealname",title:"����",width:100},
			{field:"userPhone",title:"�ֻ�����",width:100}
		]],
		mode: "remote"
	});

	//��Ӧ��ѡ�����
	var selectRowCoop;
	var artChangedCoop;
	$("input[tag=coopComponent]").combogrid({
		panelWidth: 247,
		idField: "clientNo",
		textField: "name",
		url: basePath+"/background/cooperation/searchCoopInfos.json",
		method: "POST",
		onChange: function (newValue, oldValue) {
			artChangedCoop = true;//��¼�Ƿ��иı䣨���ֶ�����ʱ����)  
	    },
	    onSelect: function (index, row) {
	    	selectRowCoop = row;  
	    } ,  
		onHidePanel: function () {
	        var t = $(this).combogrid("getValue");  
	        if (artChangedCoop) {  
	            if (selectRowCoop ==null  || t != selectRowCoop.clientNo) {//û��ѡ�����ѡ����ʱ�������  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something...  
	            }  
	        }  
	        artChangedCoop = false;  
	        selectRowCoop = null;  
	    },  
		columns: [[
			{field:"name",title:"����",width:68},
			{field:"linker",title:"��ϵ��",width:64},
			{field:"linkerTel",title:"�ֻ���",width:88}
			
		]],
		mode: "remote"
	});
	var selectClientRow;
	var artClientChanged;
	$("input[tag=clientComponent]").combogrid({
		panelWidth: 300,
		idField: "clientNo",
		textField: "clientName",
//		multiple:true, 
		contentType: "application/x-www-form-urlencoded; charset=GBK", 
		url: basePath+"/background/client/searchClient.json",
		method: "POST",
		onBeforeLoad: function(param){
			//���ڻ���ԭֵ�����һ��ҳ��������clientComponent����Ҫ����д��������ԵĻ�ȫ���ǵ�һ�������ֵ
			if(initClient&&$("input[tag=clientComponent]")){
				initClient = false;
				param.clientNo = $("input[tag=clientComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			artClientChanged = true;//��¼�Ƿ��иı䣨���ֶ�����ʱ����)  
	    },
	    onSelect: function (index, row) {  
	    	selectClientRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (artClientChanged) {  
	            if (selectClientRow ==null  || t != selectClientRow.clientNo) {//û��ѡ�����ѡ����ʱ�������  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something...  
	            }  
	        }  
	        artClientChanged = false;  
	        selectClientRow = null;  
	    },  
		columns: [[
			{field:"clientName",title:"����",width:190},
			{field:"mobile",title:"�ֻ�����",width:88}
		]],
		mode: "remote"
	});
	//�������пͻ�
	var selectAllClientRow;
	var artAllClientChanged;
	$("input[tag=allClientComponent]").combogrid({
		panelWidth: 300,
		idField: "clientNo",
		textField: "clientName",
		contentType: "application/x-www-form-urlencoded; charset=GBK", 
		url: basePath+"/background/client/searchClient.json?searchAllClient=true",
		method: "POST",
		onBeforeLoad: function(param){
			//���ڻ���ԭֵ�����һ��ҳ��������allClientComponent����Ҫ����д��������ԵĻ�ȫ���ǵ�һ�������ֵ
			if(initClient&&$("input[tag=allClientComponent]")){
				initClient = false;
				param.clientNo = $("input[tag=allClientComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			selectAllClientRow = true;//��¼�Ƿ��иı䣨���ֶ�����ʱ����)  
	    },
	    onSelect: function (index, row) {  
	    	artAllClientChanged = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (selectAllClientRow) {  
	            if (artAllClientChanged ==null  || t != artAllClientChanged.clientNo) {//û��ѡ�����ѡ����ʱ�������  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something...  
	            }  
	        }  
	        selectAllClientRow = false;  
	        artAllClientChanged = null;  
	    }, 
	    /*onLoadSuccess:function(data){  
	    	if(typeof(client)!="undefined"&&client&&initFlag){
	    		initFlag = false;
	    		var hasRow = false;
	    		$(data.rows).each(function(i,n){
	    			if(client.clientNo==n.clientNo){
	    				hasRow = true;
	    			}
	    		});
	    		if(!hasRow){
	    			data.rows.push(client);
	    			data.total +=1;
	    		}
	    		$(this).combogrid("grid").datagrid("loadData", data.rows);
	    		$(this).combogrid("setValue", client.clientNo);  
	    	}
	    },*/
		columns: [[
			{field:"clientName",title:"����",width:190},
			{field:"mobile",title:"�ֻ�����",width:88}
		]],
		mode: "remote"
	});
	
	
	//�û�ѡ���������ѺȨ��
	var rightUserSelectRow;
	var rightUserArtChanged;
	$("input[tag=rightUserComponent]").combogrid({
		panelWidth: 300,
		idField: "userId",
		textField: "userRealname",
		url: basePath+"/background/user/searchRightUser.json",
		method: "POST",
		onBeforeLoad: function(param){
			//���ڻ���ԭֵ�����һ��ҳ��������allUserComponent����Ҫ����д��������ԵĻ�ȫ���ǵ�һ�������ֵ
			if(initUser&&$("input[tag=rightUserComponent]")){
				initUser = false;
				param.userId = $("input[tag=rightUserComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			rightUserArtChanged = true;//��¼�Ƿ��иı䣨���ֶ�����ʱ����)  
	    },
	    onSelect: function (index, row) {  
	    	rightUserSelectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (rightUserArtChanged) {  
	            if (rightUserSelectRow ==null  || t != rightUserSelectRow.userId) {//û��ѡ�����ѡ����ʱ�������  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something... 
	            	
	            	$('#collaRightCode').val(rightUserSelectRow.collaRightCode);
	            	$('#collaAccOwner').val(rightUserSelectRow.collaAccOwner);
	            	$('#collaAccBank').val(rightUserSelectRow.collaAccBank);
	            	$('#collaAcc').val(rightUserSelectRow.collaAcc);
	            }  
	        }  
	        rightUserArtChanged = false;  
	        rightUserSelectRow = null;  
	    },  
//	    onLoadSuccess:function(data){  
//	    	if(typeof(user)!="undefined"&&user&&initUser){
//	    		initUser = false;
//	    		var hasRow = false;
//	    		$(data.rows).each(function(i,n){
//	    			if(user.userName==n.userName){
//	    				hasRow = true;
//	    			}
//	    		});
//	    		if(!hasRow){
//	    			data.rows.push(user);
//	    			data.total +=1;
//	    		}
//	    		$(this).combogrid("grid").datagrid("loadData", data.rows);
//	    		$(this).combogrid("setValue", user.userId);  
//	    	}
//	    },
		columns: [[ 
		    {field:"collaAccOwner",title:"�˻���",width:143},
			{field:"userRealname",title:"BD����",width:135}
		]],
		mode: "remote"
	});
	
	//��ѺȨ��ѡ�����
	var collaPledgeeSelectRow;
	var collaPledgeeArtChanged;
	$("input[tag=collaPledgeeComponent]").combogrid({
		panelWidth: 300,
		idField: "id",
		textField: "pledgeeName",
		url: basePath+"/background/collaPledgee/searchCollaPledgee.json",
		method: "POST",
		onBeforeLoad: function(param){
			//���ڻ���ԭֵ�����һ��ҳ��������allUserComponent����Ҫ����д��������ԵĻ�ȫ���ǵ�һ�������ֵ
			if(initUser&&$("input[tag=collaPledgeeComponent]")){
				initUser = false;
				param.userId = $("input[tag=collaPledgeeComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			collaPledgeeArtChanged = true;//��¼�Ƿ��иı䣨���ֶ�����ʱ����)  
	    },
	    onSelect: function (index, row) {  
	    	collaPledgeeSelectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (collaPledgeeArtChanged) {  
	            if (collaPledgeeSelectRow ==null  || t != collaPledgeeSelectRow.id) {//û��ѡ�����ѡ����ʱ�������  
	                $(this).combogrid("setValue", "");  
	            } else {  
	            	//$('#collaAcc').val(rightUserSelectRow.collaAcc);
	            }  
	        }  
	        collaPledgeeArtChanged = false;  
	        collaPledgeeSelectRow = null;  
	    },  
		columns: [[ 
		    {field:"pledgeeName",title:"��ѺȨ������",width:143},
			{field:"certCode",title:"֤������",width:135}
		]],
		mode: "remote"
	});
	
	//������
	var lenderCardSelectRow;
	var lenderCardArtChanged;
	$("input[tag=lenderCardComponent]").combogrid({
		panelWidth: 300,
		idField: "id",
		textField: "ownerName",
		url: basePath+"/background/lenderCard/searchLenderCard.json",
		method: "POST",
		onBeforeLoad: function(param){
			//���ڻ���ԭֵ�����һ��ҳ��������lenderCardComponent����Ҫ����д��������ԵĻ�ȫ���ǵ�һ�������ֵ
			if(initUser&&$("input[tag=lenderCardComponent]")){
				initUser = false;
				param.userId = $("input[tag=lenderCardComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			lenderCardArtChanged = true;//��¼�Ƿ��иı䣨���ֶ�����ʱ����)  
	    },
	    onSelect: function (index, row) {  
	    	lenderCardSelectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (lenderCardArtChanged) {  
	            if (lenderCardSelectRow ==null  || t != lenderCardSelectRow.id) {//û��ѡ�����ѡ����ʱ�������  
	                $(this).combogrid("setValue", "");  
	            } else {  
	            	$('#lenderCardBankAccount').val(lenderCardSelectRow.bankAccount);
	            }  
	        }  
	        lenderCardChanged = false;  
	        lenderCardctRow = null;  
	    },  
		columns: [[ 
		    {field:"ownerName",title:"����������",width:143},
			{field:"bankAccount",title:"�����ʺ�",width:135}
		]],
		mode: "remote"
	});
	
	
	//��Ŀѡ�����
	var tenderSelectRow;
	var tenderArtChanged;
	$("input[tag=tenderComponent]").combogrid({
		panelWidth: 220,
		idField: "reqNo",
		textField: "tenderName",
		url: basePath+"/background/user/searchTender.json",
		method: "POST",
		onBeforeLoad: function(param){
			//���ڻ���ԭֵ�����һ��ҳ��������userComponent����Ҫ����д��������ԵĻ�ȫ���ǵ�һ�������ֵ
			if(initUser&&$("input[tag=tenderComponent]")){
				initUser = false;
				param.reqNo = $("input[tag=tenderComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			tenderArtChanged = true;//��¼�Ƿ��иı䣨���ֶ�����ʱ����)  
	    },
	    onSelect: function (index, row) {  
	    	tenderSelectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (tenderArtChanged) {  
	            if (tenderSelectRow ==null  || t != tenderSelectRow.reqNo) {//û��ѡ�����ѡ����ʱ�������  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something...  
	            	if(t != "" && $(this).attr('id') == 'reqNo'){
		            	$.ajax({  
		                    url: basePath+"/background/user/searchRepayPlan.json?reqNo="+t,    //��̨webservice��ķ�������  
		                    type: "post",  
		                    dataType: "json",  
		                    contentType: "application/json",  
		                    traditional: true,  
		                    success: function (data) {
		                    		if(data.length==0){
		                    			alert("��Ŀδ�ſ����Ŀ�ѻ��壡"); 
		                    		}else{
		                            var optionstring = "";  
			                    	jQuery.each(data, function(i,item){
			                    		
			                                optionstring += "<option value=\"" + item.currentPeriod+","+item.repayDate + "\" >��" + item.currentPeriod + "��  | "+ item.repayDate+"</option>";  
			                    		});  
		                            $("#currentPeriod").html("<option value=''>��ѡ��</option> "+optionstring);  
		                    		}
	                    		
		                    	},  
		                    error: function (msg) {  
		                        alert("�����ˣ�");  
		                    }  
		                });    
	            	}
	            }  
	        }  
	        tenderArtChanged = false;  
	        tenderSelectRow = null;  
	    },  
		columns: [[
			{field:"reqNo",title:"�����",width:98},
			{field:"tenderName",title:"��Ŀ��",width:100},
		]],
		mode: "remote"
	});
});
