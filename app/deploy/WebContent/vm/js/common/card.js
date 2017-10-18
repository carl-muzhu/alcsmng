var provciteJson;
var bankList;
$(function() {
	$('#recieveAccProvCode').change(function(event,city) {
		$('#recieveAccProvince').val($('#recieveAccProvCode').find("option:selected").text());
		//重新选择省市地区后，支行信息清空
		$("#recieveAccSubBank").val("");
		$("#recieveAccSubCode").val("");
		var proviteCode = $(this).val();
		if (proviteCode == '') {
			$('#recieveAccCityCode').empty();
		} else {
			$('#recieveAccCityCode').empty();
			if (provciteJson == null) {
				// 对象为空，主动初始化一次
				initSelectActive('recieveAccProvCode',$('#recieveAccProvince').val());
			} else {
				$.each(provciteJson.provs, function(kid, vojb) {
					if (vojb.co == proviteCode) {
						$.each(vojb.cities, function(cid, cojb) {
							if(city==cojb.co){
								$('#recieveAccCityCode').append("<option value='" + cojb.co + "' selected>" + cojb.na + "</option>");
								$('#recieveAccCity').val(cojb.na);
							}else{
								$('#recieveAccCityCode').append("<option value='" + cojb.co + "'>" + cojb.na + "</option>");
							}
						});
						if(!city){
							$('#recieveAccCityCode option:nth-child(1)').attr('selected','selected');
							$('#recieveAccCity').val($('#recieveAccCityCode option:nth-child(1)').text());
						}
					}
				});
			}
		}
	});
	$('#recieveAccCityCode').change(function(){
		$("#recieveAccCity").val($('#recieveAccCityCode').find("option:selected").text());
		$("#recieveAccSubBank").val("");		
		$("#recieveAccSubCode").val("");
	});
	$("#recieveAccCode").change(function(){
		$("#recieveAccBank").val($("#recieveAccCode").find("option:selected").text());
		$("#recieveAccSubBank").val("");		
		$("#recieveAccSubCode").val("");
	});		
	$("#recieveAccSubBank").autocomplete({
		source : function(request, response) {
			$.post(basePath + "/background/bankCard/querySubBank.do", {
				'bankCode' : $('#recieveAccCode').val(),
				'provCode' : $('#recieveAccProvCode').val(),
				'cityCode' : $('#recieveAccCityCode').val(),
				'keyWord' : $('#recieveAccSubBank').val()
			}, function(data, textStatus) {
				response($.map(data.subs, function(item) {
					return {
						code : item.code,
						value : item.name
					}
				}));
			}, "json");
		},
		minLength : 1,
		matchContains : false,
		select : function(event, ui) {
			$("#recieveAccSubCode").val(ui.item.code);
			$("#recieveAccSubBank").val(ui.item.value);
		}
	});
	
	//当输入框内容变化时code自动清空
	$("#recieveAccSubBank").change(function() {
		$("#recieveAccSubCode").val("");
	});
	$('#repayAccProvCode').change(function(event,city) {
		$('#repayAccProvince').val($('#repayAccProvCode').find("option:selected").text());
		//重新选择省市地区后，支行信息清空
		$("#repayAccSubBank").val("");
		$("#repayAccSubCode").val("");
		var proviteCode = $(this).val();
		if (proviteCode == '') {
			$('#repayAccCityCode').empty();
		} else {
			$('#repayAccCityCode').empty();
			if (provciteJson == null) {
				// 对象为空，主动初始化一次
				initSelectActive('repayAccProvCode',$('#repayAccProvCode').val());
			} else {
				$.each(provciteJson.provs, function(kid, vojb) {
					if (vojb.co == proviteCode) {
						$.each(vojb.cities, function(cid, cojb) {
							if(city==cojb.co){
								$('#repayAccCityCode').append("<option value='" + cojb.co + "' selected>" + cojb.na + "</option>");
								$('#repayAccCity').val(cojb.na);
							}else{
								$('#repayAccCityCode').append("<option value='" + cojb.co + "'>" + cojb.na + "</option>");
							}
						});
						if(!city){
							$('#repayAccCityCode option:nth-child(1)').attr('selected','selected');
							$('#repayAccCity').val($('#repayAccCityCode option:nth-child(1)').text());
						}
					}
				});
			}
		}
	});
	$('#repayAccCityCode').change(function(){
		$("#repayAccCity").val($('#repayAccCityCode').find("option:selected").text());
		$("#repayAccSubBank").val("");		
		$("#repayAccSubCode").val("");
	});
	$("#repayAccBankCode").change(function(){
		$("#repayAccBank").val($("#repayAccBankCode").find("option:selected").text());
		$("#repayAccSubBank").val("");		
		$("#repayAccSubCode").val("");
	});		
	$("#repayAccSubBank").autocomplete({
		source : function(request, response) {
			$.post(basePath + "/background/bankCard/querySubBank.do", {
				'bankCode' : $('#repayAccBankCode').val(),
				'provCode' : $('#repayAccProvCode').val(),
				'cityCode' : $('#repayAccCityCode').val(),
				'keyWord' : $('#repayAccSubBank').val()
			}, function(data, textStatus) {
				response($.map(data.subs, function(item) {
					return {
						code : item.code,
						value : item.name
					}
				}));
			}, "json");
		},
		minLength : 1,
		matchContains : false,
		select : function(event, ui) {
			$("#repayAccSubCode").val(ui.item.code);
			$("#repayAccSubBank").val(ui.item.value);
		}
	});
	
	//当输入框内容变化时code自动清空
	$("#repayAccSubBank").change(function() {
		$("#repayAccSubCode").val("");
	});

});

$('#openProvCode').change(function(event,city) {
	$('#openProvName').val($('#openProvCode').find("option:selected").text());
	$("openSubBankName").val("");
	$("openSubBankCode").val("");
	var proviteCode = $(this).val();
	if (proviteCode == '') {
		$('#openCityCode').empty();
	} else {
		$('#openCityCode').empty();
		if (provciteJson == null) {
			initSelectActive('openProvCode',$('#openProvCode').val());
		} else {
			$.each(provciteJson.provs, function(kid, vojb) {
				if (vojb.co == proviteCode) {
					$.each(vojb.cities, function(cid, cojb) {
						if(city==cojb.co){
							$('#openCityCode').append("<option value='" + cojb.co + "' selected>" + cojb.na + "</option>");
							$('#openCityName').val(cojb.na);
						}else{
							$('#openCityCode').append("<option value='" + cojb.co + "'>" + cojb.na + "</option>");
						}
					});
					if(!city){
						$('#openCityCode option:nth-child(1)').attr('selected','selected');
						$('#openCityName').val($('#openCityCode option:nth-child(1)').text());
					}
				}
			});
		}
	}
});
$('#openCityCode').change(function(){
	$("#openCityName").val($('#openCityCode').find("option:selected").text());
	$("#openSubBankName").val("");		
	$("#openSubBankCode").val("");
});
$("#openBankCode").change(function(){
	$("#openBankName").val($("#openBankCode").find("option:selected").text());
	$("#openSubBankName").val("");		
	$("#openSubBankCode").val("");
});		
$("#openSubBankName").autocomplete({
	source : function(request, response) {
		$.post(basePath + "/background/bankCard/querySubBank.do", {
			'bankCode' : $('#openBankCode').val(),
			'provCode' : $('#openProvCode').val(),
			'cityCode' : $('#openCityCode').val(),
			'keyWord' : $('#openSubBankName').val()
		}, function(data, textStatus) {
			response($.map(data.subs, function(item) {
				return {
					code : item.code,
					value : item.name
				}
			}));
		}, "json");
	},
	minLength : 1,
	matchContains : false,
	select : function(event, ui) {
		$("#openSubBankCode").val(ui.item.code);
		$("#openSubBankName").val(ui.item.value);
	}
});

$("#openSubBankName").change(function() {
	$("#openSubBankCode").val("");
});
// 初始化级联控件
function initSelectActive(id,pro,city,callback) {
	$.getJSON(basePath+"/background/bankCard/queryProvcites.do", function(json) {
		if (typeof (json) != "undefined") {
			provciteJson = json;
		}
		$('#'+id).append("<option value=''>--请选择--</option>");
		$.each(json.provs,
				function(kid, vojb) {
					if(vojb.co==pro){
						$('#'+id).append("<option value='" + vojb.co + "' selected>" + vojb.na + "</option>");
						$('#'+id).trigger('change',city);
					}else{
						$('#'+id).append("<option value='" + vojb.co + "'>" + vojb.na + "</option>");
					}
				});
		if(callback){
			callback();
		}
	});
}
//初始化银行列表
function initBankList(id,val,callback) {
	$.getJSON(basePath+"/background/bankCard/queryBankInfo.do", function(json) {
		if (typeof (json) != "undefined") {
			bankList = json;
		}
		$('#'+id).append("<option value=''>--请选择--</option>");
		$.each(json.banks,
				function(kid, vojb) {
					if(vojb.code==val){
						$('#'+id).append("<option value='" + vojb.code + "' selected>" + vojb.name+ "</option>");
						$('#'+id).trigger('change',val);
					}else{
						$('#'+id).append("<option value='" + vojb.code + "'>" + vojb.name+ "</option>");
					}
				});
		if(callback){
			callback();
		}
	});
}
