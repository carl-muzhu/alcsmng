/**
 * 调用时间先导入一下js包
 * <script src="jquery-1.7.min.js" type="text/javascript"></script>
 * <script src="Area.js" type="text/javascript"></script>
 * <script src="AreaData_min.js" type="text/javascript"></script>
 * 
 * 
 * 调用示例：
 * <label>请选择省市地区：</label></br>
 * <select id="seachprov" name="seachprov" onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');"></select>&nbsp;
 * <select id="seachcity" name="homecity" onChange="changeCity(this.value,'seachdistrict','seachdistrict');"></select>&nbsp;
 * <span id="seachdistrict_div"><select id="seachdistrict" name="seachdistrict"></select></span>
 * <input type="button"  value="获取地区" onClick="showAreaID()"/>
 * <script type="text/javascript">
 * $(function (){
	initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array, '44', '0', '0');
	});
 * </script>
 * 
 */

//省选项变化时触发市和区下来列表数值变化(c为控件Id前缀)
function changeChooseProvince(v, c){
	var sub_array=[];
	$.ajaxSettings.async = false;
	$.getJSON(basePath+"/background/area/queryCity.do?provCode="+v, function(json) {
		sub_array[v]=[];
		sub_array[v][0]="请选择";
		$.each(json, function(i, node){     
			sub_array[v][node.code]=node.fullName;
		}); 
	});

	changeComplexProvince(v, sub_array, c+'City', c+'District');
}
//市选项变化时触发区下来列表数值变化 (c为控件Id前缀)
function changeChooseCity(v,c){
	var sub_arr=[];
	$.ajaxSettings.async = false;
	$.getJSON(basePath+"/background/area/queryArea.do?cityCode="+v, function(json) {
		sub_arr[v]=[];
		sub_arr[v][0]="请选择";
		$.each(json, function(i, node){     
			sub_arr[v][node.code]=node.fullName;
		}); 
	});

	changeCity(v,c+'District',sub_arr);
}

//初始化省市区三级联动 n为控件前缀，areaID地区码
function initArea(n,areaID) {
	var  index1=0,index2=0;index3=0;
	if(areaID.length == 2){
		index1 = areaID;
	}else if(areaID.length == 4){
		index1 = areaID.substring(0, 2);
		index2 = areaID.substring(0, 4);
	}else if(areaID.length == 6){
		index1 = areaID.substring(0, 2);
		index2 = areaID.substring(0, 4);
		index3 = areaID.substring(0, 6);
	}
	var area_array=[];
	$.ajaxSettings.async = false;
	$.getJSON(basePath+"/background/area/queryProvince.do", function(json) {
		area_array[0] = "请选择";
		$.each(json, function(i, node){    
			area_array[node.code] = node.fullName;
		}); 
	});
	var sub_array=[];
	if(index1!=0){
		$.getJSON(basePath+"/background/area/queryCity.do?provCode="+index1, function(json) {
			sub_array[index1]=[];
			sub_array[index1][0]="请选择";
			$.each(json, function(i, node){     
				sub_array[index1][node.code]=node.fullName;
			}); 
		});
	}
	
	var sub_arr=[];
	if(index2!=0){
		$.getJSON(basePath+"/background/area/queryArea.do?cityCode="+index2, function(json) {
			sub_arr[index2]=[];
			sub_arr[index2][0]="请选择";
			$.each(json, function(i, node){     
				sub_arr[index2][node.code]=node.fullName;
			}); 
		});	
	}
	initComplexArea(n+"Prov", n+"City", n+"District", area_array, sub_array,sub_arr, index1, index2, index3);
}

//得到地区码
function getAreaID(n){
	var area = "";          
	if($("#"+n+"District").val() != "0"){
		area = $("#"+n+"District").val();                
	}else if ($("#"+n+"City").val() != "0"){
		area = $("#"+n+"City").val();
	}else{
		area = $("#"+n+"Prov").val();
	}
	return area == "0"? "": area;
}


//根据地区码查询地区名
function getAreaNamebyID(areaID){
	var  index1=0,index2=0;index3=0;
	if(areaID.length == 2){
		index3=areaID;
	}else if(areaID.length == 4){
		index1 = areaID.substring(0, 2);
		index2 = areaID.substring(0, 4);
	}else if(areaID.length == 6){
		index1 = areaID.substring(0, 2);
		index2 = areaID.substring(0, 4);
		index3 = areaID.substring(0, 6);
	}
	var area_array=[];
	$.ajaxSettings.async = false;
	$.getJSON(basePath+"/background/area/queryProvince.do", function(json) {
		area_array[0] = "请选择";
		$.each(json, function(i, node){    
			area_array[node.code] = node.fullName;
		}); 
	});
	var sub_array=[];
	$.getJSON(basePath+"/background/area/queryCity.do?provCode="+index1, function(json) {
		sub_array[index1]=[];
		sub_array[index1][0]="请选择";
		$.each(json, function(i, node){     
			sub_array[index1][node.code]=node.fullName;
		}); 
	});
	
	var sub_arr=[];
	$.getJSON(basePath+"/background/area/queryArea.do?cityCode="+index2, function(json) {
		sub_arr[index2]=[];
		sub_arr[index2][0]="请选择";
		$.each(json, function(i, node){     
			sub_arr[index2][node.code]=node.fullName;
		}); 
	});	
	var areaName = "";
	if(areaID.length == 2){
		areaName = area_array[areaID];
	}else if(areaID.length == 4){
		var index1 = areaID.substring(0, 2);
		areaName = area_array[index1] +  sub_array[index1][areaID];
	}else if(areaID.length == 6){
		var index1 = areaID.substring(0, 2);
		var index2 = areaID.substring(0, 4);
		areaName = area_array[index1] +  sub_array[index1][index2] + sub_arr[index2][areaID];
	}
	return areaName;
}