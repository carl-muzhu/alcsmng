/**
 * 公共的UI組件
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
				//用于回显原值，如果一个页面包含多个userComponent，需要重新写，否则回显的会全部是第一个组件的值
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
				{field:"userName",title:"用户名",width:98},
				{field:"userRealname",title:"姓名",width:100},
				{field:"userPhone",title:"手机号码",width:100}
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
				{field:"clientName",title:"姓名",width:190},
				{field:"mobile",title:"手机号码",width:88}
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
			    {field:"ownerName",title:"出借人名称",width:143},
				{field:"ownerIdNo",title:"证件号码",width:135}
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
			    {field:"ownerName",title:"出借人名称",width:133},
				{field:"ownerIdNo",title:"证件号码",width:135},
				{field:"bankAccount",title:"银行账号",width:140}
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
			    {field:"pledgeeName",title:"抵押权人名称",width:143},
				{field:"certCode",title:"证件号码",width:135}
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
				{field:'assetNo',title:'资产编号',width:146},
				{field:"addr",title:"资产详情",width:250},
			]]
		});
	},
	loadColla:function(id,selectCallback,unselectCallback,loadCallback){
		$("#"+id).combogrid({
			panelWidth: 560,
			idField: "collaNo",
			textField: "collaNo",
			//multiple:true, //多选true单选false
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
				{field:"clientName",title:"客户名称",width:135},
				{field:"collaNo",title:"抵押编号",width:135},
				{field:"collaTypeName",title:"抵押类型",width:65},
				{field:"collaAmt",title:"抵押可使用额度(元)",width:120},
				{field:"collaDesc",title:"抵押描述",width:240}
			]],
			mode: "remote"
		});
	}
};
