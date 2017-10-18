/**
 * ������UI�M��
 */
bops.easyui = {
	loadUser:function (id,selectedCallback){
		$('#'+id).combogrid({
			panelWidth: 320,
			idField: "userId",
			textField: "userRealname",
			url: basePath+"/background/user/searchUser.json",
			method: "POST",
			onBeforeLoad: function(param){
				//���ڻ���ԭֵ�����һ��ҳ��������userComponent����Ҫ����д��������ԵĻ�ȫ���ǵ�һ�������ֵ
				var userId = $('#'+id).val();
				if(userId!=null && userId!=undefined){
					param.userId=userId;
				}
				var deptId = $('#'+id).attr("deptId");
				if(deptId!=undefined){
					param.deptId = deptId;
				}
			},
		    onSelect: function (index, row) {  
		    	selectedCallback(row.userId);
		    },
			columns: [[
				{field:"userName",title:"�û���",width:98},
				{field:"userRealname",title:"����",width:100},
				{field:"userPhone",title:"�ֻ�����",width:100}
			]],
			mode: "remote"
		});
	},
	reloadData:function (id){
		$('#'+id).combogrid('grid').datagrid('load');
	},
	loadData:function(id, dataArray){
		$('#'+id).combogrid("grid").datagrid("loadData", dataArray);
	},
	loadClient:function (id,selectedCallback,changeCallback){
		$('#'+id).combogrid({
			panelWidth: 300,
			idField: "clientNo",
			textField: "clientName",
			contentType: "application/x-www-form-urlencoded; charset=GBK", 
			url: basePath+"/background/client/searchClient.json",
			method: "POST",
			onBeforeLoad: function(param){
				var clientNo = $('#'+id).val();
				if(clientNo!=null && clientNo!=undefined){
					param.clientNo=clientNo;
				}
				var userId = $('#'+id).attr("userId");
				if(userId!=undefined){
					param.userId = userId;
				}
				var clientShare = $('#'+id).attr("clientShare");
				if(clientShare!=undefined){
					param.clientShare = clientShare;
				}
			},
			onSelect: function (index, row) {  
				if(selectedCallback){
					selectedCallback(row.clientNo,row.clientName,row.mobile);
				}
		    },
		    onChange:function(newValue, oldValue){
		    	if(changeCallback){
		    		changeCallback(newValue,oldValue);
		    	}
		    },
			columns: [[
				{field:"clientName",title:"����",width:190},
				{field:"mobile",title:"�ֻ�����",width:88}
			]],
			mode: "remote"
		});
	},
	loadLenderCardClient:function(id,selectedCallback){
		$('#'+id).combogrid({
			panelWidth: 300,
			idField: "id",
			textField: "ownerName",
			url: basePath+"/background/lenderCard/searchLenderCardClient.json",
			method: "POST",
			onBeforeLoad: function(param){
			},
		    onSelect: function (index, row) {  
		    	if(selectedCallback){
					selectedCallback(row);
				}
		    } ,  
			columns: [[ 
			    {field:"ownerName",title:"����������",width:143},
				{field:"ownerIdNo",title:"֤������",width:135}
			]],
			mode: "remote"
			
		});
	},
	loadLenderCard:function(id,selectedCallback){
		$('#'+id).combogrid({
			panelWidth: 420,
			idField: "id",
			textField: "ownerName",
			url: basePath+"/background/lenderCard/searchLenderCard.json",
			method: "POST",
			onBeforeLoad: function(param){
				var certNo = $('#'+id).attr("certNo");
				if(certNo!=undefined){
					param.certNo = certNo;
				}
			},
		    onSelect: function (index, row) {  
		    	if(selectedCallback){
					selectedCallback(row);
				}
		    } ,  
			columns: [[ 
			    {field:"ownerName",title:"����������",width:133},
				{field:"ownerIdNo",title:"֤������",width:135},
				{field:"bankAccount",title:"�����˺�",width:140}
			]],
			mode: "remote"
			
		});
	},
	loadCollaPledge:function(id,selectedCallback){
		$('#'+id).combogrid({
			panelWidth: 300,
			idField: "id",
			textField: "pledgeeName",
			url: basePath+"/background/collaPledgee/searchCollaPledgee.json",
			method: "POST",
			onBeforeLoad: function(param){
			},
			
		    onSelect: function (index, row) {  
		    	if(selectedCallback){
					selectedCallback(row);
				}
		    },  
		 
			columns: [[ 
			    {field:"pledgeeName",title:"��ѺȨ������",width:143},
				{field:"certCode",title:"֤������",width:135}
			]],
			mode: "remote"
		});
	},
	loadClientAsset:function(id,selectedCallback){
		$('#'+id).combogrid({
			panelWidth: 400,
			idField: "assetNo",
			textField: "addr",
			url: basePath+"/background/collateral/searchPledgeAsset.json",
			method: "POST",
			onBeforeLoad: function(param){
				var clientNo = $('#'+id).attr("clientNo");
				if(clientNo!=undefined){
					param.clientNo = clientNo;
				}
			},
		    onSelect: function (index, row) {  
		    	if(selectedCallback){
					selectedCallback(row);
				}
		    },
			columns: [[ 
				{field:'assetNo',title:'�ʲ����',width:146},
				{field:"addr",title:"�ʲ�����",width:250},
			]]
		});
	},
	loadColla:function(id,selectCallback,unselectCallback,loadCallback){
		$("#"+id).combogrid({
			panelWidth: 560,
			idField: "collaNo",
			textField: "collaNo",
			//multiple:true, //��ѡtrue��ѡfalse
			url:basePath+"/background/collateral/getCollateralByClientNo.do",
			contentType: "application/x-www-form-urlencoded; charset=GBK", 
			method: "POST",
			rownumbers:true,
			onBeforeLoad: function(param){
				var clientNo = $('#'+id).attr("clientNo");
				if(clientNo!=undefined && clientNo!=0){
					param.clientNo = clientNo;
				}
				var partyClients = $('#'+id).attr("partyClients");
				if(partyClients!=undefined && partyClients!=0){
					param.partyClients = partyClients;
				}
			},
		    onSelect: function (index, row) {  
		    	if(selectCallback){
		    		selectCallback(row.collaNo);
				}
		    } ,  
		    onUnselect: function (index, row) {  
		    	if(unselectCallback){
		    		unselectCallback(row.collaNo);
				}
		    },
		    onLoadSuccess:function(node, data){
		    	if(loadCallback){
		    		loadCallback();
		    	}
		    },
		    frozenColumns:[[{field:'1',checkbox:true,width:10,align:'center'}]],
			columns: [[
				{field:"clientName",title:"�ͻ�����",width:135},
				{field:"collaNo",title:"��Ѻ���",width:135},
				{field:"collaTypeName",title:"��Ѻ����",width:65},
				{field:"collaAmt",title:"��Ѻ��ʹ�ö��(Ԫ)",width:120},
				{field:"collaDesc",title:"��Ѻ����",width:240}
			]],
			mode: "remote"
		});
	}
};
