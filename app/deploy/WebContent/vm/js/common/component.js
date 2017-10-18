$(document).ready(function(){
	var initUser = true;
	var initClient = true;
	//部门树组件
	$("input[tag=deptComponent]").combotree({
	    url:basePath+"/background/dept/deptTree.json",
	    panelWidth: 300,
	    panelHeight:300
	});
	//所有部门树组件
	$("input[tag=allDeptComponent]").combotree({
	    url:basePath+"/background/dept/allDeptTree.json",
	    panelWidth: 300,
	    panelHeight:300
	});
	
	//用户选择组件，仅本部门用户
	var selectRow;
	var artChanged;
	$("input[tag=userComponent]").combogrid({
		panelWidth: 320,
		idField: "userId",
		textField: "userRealname",
		url: basePath+"/background/user/searchUser.json",
		method: "POST",
		onBeforeLoad: function(param){
			//用于回显原值，如果一个页面包含多个userComponent，需要重新写，否则回显的会全部是第一个组件的值
			if(initUser&&$("input[tag=userComponent]")){
				initUser = false;
				param.userId = $("input[tag=userComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
	        artChanged = true;//记录是否有改变（当手动输入时发生)  
	    },
	    onSelect: function (index, row) {  
	        selectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (artChanged) {  
	            if (selectRow ==null  || t != selectRow.userId) {//没有选择或者选项不相等时清除内容  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something...  
	            }  
	        }  
	        artChanged = false;  
	        selectRow = null;  
	    },  
		columns: [[
			{field:"userName",title:"用户名",width:98},
			{field:"userRealname",title:"姓名",width:100},
			{field:"userPhone",title:"手机号码",width:100}
		]],
		mode: "remote"
	});
	//用户选择组件，所有用户
	var allUserSelectRow;
	var allUserArtChanged;
	$("input[tag=allUserComponent]").combogrid({
		panelWidth: 320,
		idField: "userId",
		textField: "userRealname",
		url: basePath+"/background/user/searchUser.json?allUsers=true",
		method: "POST",
		onBeforeLoad: function(param){
			//用于回显原值，如果一个页面包含多个allUserComponent，需要重新写，否则回显的会全部是第一个组件的值
			if(initUser&&$("input[tag=allUserComponent]")){
				initUser = false;
				param.userId = $("input[tag=allUserComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			allUserArtChanged = true;//记录是否有改变（当手动输入时发生)  
	    },
	    onSelect: function (index, row) {  
	    	allUserSelectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (allUserArtChanged) {  
	            if (allUserSelectRow ==null  || t != allUserSelectRow.userId) {//没有选择或者选项不相等时清除内容  
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
			{field:"userName",title:"用户名",width:98},
			{field:"userRealname",title:"姓名",width:100},
			{field:"userPhone",title:"手机号码",width:100}
		]],
		mode: "remote"
	});

	//供应商选择组件
	var selectRowCoop;
	var artChangedCoop;
	$("input[tag=coopComponent]").combogrid({
		panelWidth: 247,
		idField: "clientNo",
		textField: "name",
		url: basePath+"/background/cooperation/searchCoopInfos.json",
		method: "POST",
		onChange: function (newValue, oldValue) {
			artChangedCoop = true;//记录是否有改变（当手动输入时发生)  
	    },
	    onSelect: function (index, row) {
	    	selectRowCoop = row;  
	    } ,  
		onHidePanel: function () {
	        var t = $(this).combogrid("getValue");  
	        if (artChangedCoop) {  
	            if (selectRowCoop ==null  || t != selectRowCoop.clientNo) {//没有选择或者选项不相等时清除内容  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something...  
	            }  
	        }  
	        artChangedCoop = false;  
	        selectRowCoop = null;  
	    },  
		columns: [[
			{field:"name",title:"名称",width:68},
			{field:"linker",title:"联系人",width:64},
			{field:"linkerTel",title:"手机号",width:88}
			
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
			//用于回显原值，如果一个页面包含多个clientComponent，需要重新写，否则回显的会全部是第一个组件的值
			if(initClient&&$("input[tag=clientComponent]")){
				initClient = false;
				param.clientNo = $("input[tag=clientComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			artClientChanged = true;//记录是否有改变（当手动输入时发生)  
	    },
	    onSelect: function (index, row) {  
	    	selectClientRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (artClientChanged) {  
	            if (selectClientRow ==null  || t != selectClientRow.clientNo) {//没有选择或者选项不相等时清除内容  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something...  
	            }  
	        }  
	        artClientChanged = false;  
	        selectClientRow = null;  
	    },  
		columns: [[
			{field:"clientName",title:"姓名",width:190},
			{field:"mobile",title:"手机号码",width:88}
		]],
		mode: "remote"
	});
	//检索所有客户
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
			//用于回显原值，如果一个页面包含多个allClientComponent，需要重新写，否则回显的会全部是第一个组件的值
			if(initClient&&$("input[tag=allClientComponent]")){
				initClient = false;
				param.clientNo = $("input[tag=allClientComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			selectAllClientRow = true;//记录是否有改变（当手动输入时发生)  
	    },
	    onSelect: function (index, row) {  
	    	artAllClientChanged = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (selectAllClientRow) {  
	            if (artAllClientChanged ==null  || t != artAllClientChanged.clientNo) {//没有选择或者选项不相等时清除内容  
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
			{field:"clientName",title:"姓名",width:190},
			{field:"mobile",title:"手机号码",width:88}
		]],
		mode: "remote"
	});
	
	
	//用户选择组件，抵押权人
	var rightUserSelectRow;
	var rightUserArtChanged;
	$("input[tag=rightUserComponent]").combogrid({
		panelWidth: 300,
		idField: "userId",
		textField: "userRealname",
		url: basePath+"/background/user/searchRightUser.json",
		method: "POST",
		onBeforeLoad: function(param){
			//用于回显原值，如果一个页面包含多个allUserComponent，需要重新写，否则回显的会全部是第一个组件的值
			if(initUser&&$("input[tag=rightUserComponent]")){
				initUser = false;
				param.userId = $("input[tag=rightUserComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			rightUserArtChanged = true;//记录是否有改变（当手动输入时发生)  
	    },
	    onSelect: function (index, row) {  
	    	rightUserSelectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (rightUserArtChanged) {  
	            if (rightUserSelectRow ==null  || t != rightUserSelectRow.userId) {//没有选择或者选项不相等时清除内容  
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
		    {field:"collaAccOwner",title:"账户名",width:143},
			{field:"userRealname",title:"BD名称",width:135}
		]],
		mode: "remote"
	});
	
	//抵押权人选择组件
	var collaPledgeeSelectRow;
	var collaPledgeeArtChanged;
	$("input[tag=collaPledgeeComponent]").combogrid({
		panelWidth: 300,
		idField: "id",
		textField: "pledgeeName",
		url: basePath+"/background/collaPledgee/searchCollaPledgee.json",
		method: "POST",
		onBeforeLoad: function(param){
			//用于回显原值，如果一个页面包含多个allUserComponent，需要重新写，否则回显的会全部是第一个组件的值
			if(initUser&&$("input[tag=collaPledgeeComponent]")){
				initUser = false;
				param.userId = $("input[tag=collaPledgeeComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			collaPledgeeArtChanged = true;//记录是否有改变（当手动输入时发生)  
	    },
	    onSelect: function (index, row) {  
	    	collaPledgeeSelectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (collaPledgeeArtChanged) {  
	            if (collaPledgeeSelectRow ==null  || t != collaPledgeeSelectRow.id) {//没有选择或者选项不相等时清除内容  
	                $(this).combogrid("setValue", "");  
	            } else {  
	            	//$('#collaAcc').val(rightUserSelectRow.collaAcc);
	            }  
	        }  
	        collaPledgeeArtChanged = false;  
	        collaPledgeeSelectRow = null;  
	    },  
		columns: [[ 
		    {field:"pledgeeName",title:"抵押权人名称",width:143},
			{field:"certCode",title:"证件号码",width:135}
		]],
		mode: "remote"
	});
	
	//出借人
	var lenderCardSelectRow;
	var lenderCardArtChanged;
	$("input[tag=lenderCardComponent]").combogrid({
		panelWidth: 300,
		idField: "id",
		textField: "ownerName",
		url: basePath+"/background/lenderCard/searchLenderCard.json",
		method: "POST",
		onBeforeLoad: function(param){
			//用于回显原值，如果一个页面包含多个lenderCardComponent，需要重新写，否则回显的会全部是第一个组件的值
			if(initUser&&$("input[tag=lenderCardComponent]")){
				initUser = false;
				param.userId = $("input[tag=lenderCardComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			lenderCardArtChanged = true;//记录是否有改变（当手动输入时发生)  
	    },
	    onSelect: function (index, row) {  
	    	lenderCardSelectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (lenderCardArtChanged) {  
	            if (lenderCardSelectRow ==null  || t != lenderCardSelectRow.id) {//没有选择或者选项不相等时清除内容  
	                $(this).combogrid("setValue", "");  
	            } else {  
	            	$('#lenderCardBankAccount').val(lenderCardSelectRow.bankAccount);
	            }  
	        }  
	        lenderCardChanged = false;  
	        lenderCardctRow = null;  
	    },  
		columns: [[ 
		    {field:"ownerName",title:"出借人名称",width:143},
			{field:"bankAccount",title:"银行帐号",width:135}
		]],
		mode: "remote"
	});
	
	
	//项目选择组件
	var tenderSelectRow;
	var tenderArtChanged;
	$("input[tag=tenderComponent]").combogrid({
		panelWidth: 220,
		idField: "reqNo",
		textField: "tenderName",
		url: basePath+"/background/user/searchTender.json",
		method: "POST",
		onBeforeLoad: function(param){
			//用于回显原值，如果一个页面包含多个userComponent，需要重新写，否则回显的会全部是第一个组件的值
			if(initUser&&$("input[tag=tenderComponent]")){
				initUser = false;
				param.reqNo = $("input[tag=tenderComponent]").val();
			}
		},
		onChange: function (newValue, oldValue) {  
			tenderArtChanged = true;//记录是否有改变（当手动输入时发生)  
	    },
	    onSelect: function (index, row) {  
	    	tenderSelectRow = row;  
	    } ,  
		onHidePanel: function () {  
	        var t = $(this).combogrid("getValue");  
	        if (tenderArtChanged) {  
	            if (tenderSelectRow ==null  || t != tenderSelectRow.reqNo) {//没有选择或者选项不相等时清除内容  
	                $(this).combogrid("setValue", "");  
	            } else {  
	                //do something...  
	            	if(t != "" && $(this).attr('id') == 'reqNo'){
		            	$.ajax({  
		                    url: basePath+"/background/user/searchRepayPlan.json?reqNo="+t,    //后台webservice里的方法名称  
		                    type: "post",  
		                    dataType: "json",  
		                    contentType: "application/json",  
		                    traditional: true,  
		                    success: function (data) {
		                    		if(data.length==0){
		                    			alert("项目未放款或项目已还清！"); 
		                    		}else{
		                            var optionstring = "";  
			                    	jQuery.each(data, function(i,item){
			                    		
			                                optionstring += "<option value=\"" + item.currentPeriod+","+item.repayDate + "\" >第" + item.currentPeriod + "期  | "+ item.repayDate+"</option>";  
			                    		});  
		                            $("#currentPeriod").html("<option value=''>请选择</option> "+optionstring);  
		                    		}
	                    		
		                    	},  
		                    error: function (msg) {  
		                        alert("出错了！");  
		                    }  
		                });    
	            	}
	            }  
	        }  
	        tenderArtChanged = false;  
	        tenderSelectRow = null;  
	    },  
		columns: [[
			{field:"reqNo",title:"借款编号",width:98},
			{field:"tenderName",title:"项目名",width:100},
		]],
		mode: "remote"
	});
});
