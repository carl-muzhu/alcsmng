//ʡѡ��仯ʱ�����к��������б���ֵ�仯(cΪ�ؼ�Idǰ׺)
function changeBizChooseProvince(v, c){
	var biz_sub_array=[];
	$.ajaxSettings.async = false;
	$.getJSON(basePath+"/background/area/queryCity.do?provCode="+v, function(json) {
		biz_sub_array[v]=[];
		biz_sub_array[v][0]="��ѡ��";
		$.each(json, function(i, node){     
			biz_sub_array[v][node.code]=node.fullName;
		}); 
	});
	changeComplexProvince(v, biz_sub_array, c+'City', c+'District');
}
//��ѡ��仯ʱ�����������б���ֵ�仯 (cΪ�ؼ�Idǰ׺)
function changeBizChooseCity(v,c){
	var biz_sub_arr=[];
	$.ajaxSettings.async = false;
	$.getJSON(basePath+"/background/area/queryArea.do?cityCode="+v, function(json) {
		biz_sub_arr[v]=[];
		biz_sub_arr[v][0]="��ѡ��";
		$.each(json, function(i, node){     
			biz_sub_arr[v][node.code]=node.fullName;
		}); 
	});
	changeCity(v,c+'District', biz_sub_arr);
}
//��ʼ��ʡ������������ nΪ�ؼ�ǰ׺��areaID������
function initBizArea(n,areaID) {
	
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
	var biz_area_array=[];
	$.ajaxSettings.async = false;
	$.getJSON(basePath+"/background/area/queryProvince.do", function(json) {
		biz_area_array[0] = "��ѡ��";
		$.each(json, function(i, node){    
			biz_area_array[node.code] = node.fullName;
		}); 
	});
	var biz_sub_array=[];
	$.getJSON(basePath+"/background/area/queryCity.do?provCode="+index1, function(json) {
		biz_sub_array[index1]=[];
		biz_sub_array[index1][0]="��ѡ��";
		$.each(json, function(i, node){     
			biz_sub_array[index1][node.code]=node.fullName;
		}); 
	});
	
	var biz_sub_arr=[];
	$.getJSON(basePath+"/background/area/queryArea.do?cityCode="+index2, function(json) {
		biz_sub_arr[index2]=[];
		biz_sub_arr[index2][0]="��ѡ��";
		$.each(json, function(i, node){     
			biz_sub_arr[index2][node.code]=node.fullName;
		}); 
	});

	initComplexArea(n+"Prov", n+"City", n+"District", biz_area_array, biz_sub_array,biz_sub_arr, index1, index2, index3);
}
