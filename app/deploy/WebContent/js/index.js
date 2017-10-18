/// <reference path="../index.html" />

!function() {

	var CVMOD = window.CVMOD = {};

	var _Config = {};

	var _CVMOD = {};
	
	var EDITARRAY = [];

	_CVMOD.getDefaultConfig = function() {
		return this;
	}

	_CVMOD.getConfig = function(name) {
		var cfg = _Config[name];
		if (cfg === undefined) {
			cfg = _Config[name] = {};
			var deft = this.getDefaultConfig();
			for ( var e in deft) {
				cfg[e] = deft[e];
			}

		}
		return cfg;
	}

	// �༭
	_CVMOD.editInfo = function(elm, name, id) {
//		var tmplate = $(
//				"#Template > div[data-template=" + this.tmplateEdit + "]")
//				.clone();
		var elm = $(elm).parents(".studyUnit");

		if(EDITARRAY.length>0){
			alert("���������һ���������?");
			return;
		}
		EDITARRAY.push(elm);
//		var data = {};
//
//		elm.find("[data-bind]").each(function() {
//			var bind = $(this).attr("data-bind");
//			data[bind] = $(this).html();
//		});
//
//		tmplate.find("[data-bind]").each(function() {
//			var bind = $(this).attr("data-bind");
//			$(this).val(data[bind]);
//		})

		// ��ӽ���˼���
		if (name == 'JKRJL'&&id!='0') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateWorkInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'JBXX') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateBaseInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'JTQK'&&id!='0') {//��ͥ���
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateContactInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'QYQK'&&id!='-1') {//��ҵ
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateFirmInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				//contentType:"application/x-www-form-urlencoded;charset=GBK", 
				scriptCharset: 'GB2312',
				dataType : 'html', // �������ݸ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'SSJQTBLXX'&&id!='0') {//��ҵ
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateLawInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.FC'&&id!='0') {//����
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateHouseInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.CL'&&id!='0') {//����
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateCarInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.JYZC'&&id!='0') {//��Ӫ���ʲ�
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateOtherassetInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.JYFZ'&&id!='0') {//��Ӫ���ʲ�
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateOtherdebtInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.FZ'&&id!='0') {//��ծ
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateCreditloanInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.YXK'&&id!='0') {//���ÿ�
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateCreditcardInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.DWDBQK'&&id!='0') {//������
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateGuaranteeInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		} else if (name == 'ZX.JQJLTJ' ) {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateCreditDetailInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'ZXCS'&&id!='0') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateCreditSumInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'ZXFXSM'&&id!='0') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateMediumDescInfo.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'JYQK'&&id!='0') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateMediumDesc_1Info.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'JKYT'&&id!='0') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateMediumDesc_2Info.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'BZRXX'&&id!='0') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateMediumDesc_3Info.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FXJSD'&&id!='0') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateMediumDesc_4Info.htm?id=" + id
					+ "&reqNo=" + reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		} else if (name == 'DY.FC'&&id!='0') {
//			var collateralId = $("#collateralId").val();//��Ѻ������
			var collaNo = $("#collaNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/houseConfirm/toUpdateCollaHouse.htm?id=" + id
					+"&collaNo="+collaNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.hide().before(data);
				},
				error : function(data) {
				}
			});
		}else{
			elm.hide().before(tmplate);
		}
			
	}

	// �޸ı���
	_CVMOD.eduSave = function(elm, name) {

		var elm = $(elm).parents(".studyUnit");

		var data = {};
		elm.find("[data-bind]").each(function() {
			var bind = $(this).attr("data-bind");
			data[bind] = $(this).val();
		});
		var template = elm.next();

		template.find("[data-bind]").each(function() {
			var bind = $(this).attr("data-bind");
			$(this).html(data[bind]);
		})

		this.editSubmit(function() {
			elm.remove();
			template.show();
		});
	}

	// ���
	_CVMOD.addInfo = function(elm, name) {
//		var tmplate = $(
//				"#Template > div[data-template=" + this.tmplateEdit + "]")
//				.clone();
		var elm = $(elm).parent().parent();
		if(EDITARRAY.length>0){
			alert("���������һ���������?");
			return;
		}
		EDITARRAY.push(elm);
		if (elm.is(".textNull")) {
			elm.removeClass("textNull");
			if(name == "ZX.JQJLTJ" || name == "ZXCS" || name == "ZXFXSM" || name == "JYQK" || name == "JKYT" || name == "BZRXX" || name == "FXJSD"){
				$(elm).html('');
			}
		} else {
			elm.before('<div class="lineSolid">&nbsp;</div>')
		}
		// ��ӽ���˼���
		if (name == 'JKRJL') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateWorkInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'JBXX') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateBaseInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'JTQK') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateContactInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'QYQK') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateFirmInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'SSJQTBLXX') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateLawInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.FC') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateHouseInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.CL') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateCarInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.JYZC') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateOtherassetInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.JYFZ') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateOtherdebtInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.FZ') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateCreditloanInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.YXK') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateCreditcardInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FZ.DWDBQK') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateGuaranteeInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'ZX.JQJLTJ') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateCreditDetailInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'ZXCS') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateCreditSumInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'ZXFXSM') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateMediumDescInfo.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'JYQK') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateMediumDesc_1Info.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'JKYT') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateMediumDesc_2Info.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'BZRXX') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateMediumDesc_3Info.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'FXJSD') {
			var reqNo = $("#bizNo").val();
			var clientNo = $("#clientNo").val();
			var url = basePath
					+ "/background/responsible/toUpdateMediumDesc_4Info.htm?reqNo="
					+ reqNo + "&clientNo=" + clientNo;

			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				success : function(data) {
					elm.before(data);
				},
				error : function(data) {
				}
			});
		}else if (name == 'DY.FC') {
//			$('#addrCode').val(getAreaID("addrCodeSel"));
			var params = $('#colla_form_add').serialize();
			var url = $("#colla_form_add").attr("action");
			var form = $("#colla_form_add");
//			if(validateHouse(form) && validateField(form)){
				$.ajax({
					url : url, // ��̨�������
					type : 'POST', // ���ݷ��ͷ�ʽ
					data : params, // Ҫ���ݵ�����
					dataType : 'html', // �������ݸ�ʽ
					success : function(data) {
						elm.before(data);
						elm.remove();
						EDITARRAY.pop();
					},
					error : function(data) {
						alert(data);
					}
				});
//			}
		}else {
			elm.before(tmplate);
		}
	}

	// ɾ��
	_CVMOD.deleteInfo = function(elm, name) {
		var elm = $(elm).parents(".studyUnit");
		var key = elm.attr("data-key");
		var template = $("#Template > div[data-template=" + this.tmplateShow + "]");
				
		var fn = function() {
			var isOver = true;
			if (elm.prev().is(".lineSolid")) {
				isOver = false;
				elm.prev().remove();
			}
			if (isOver && elm.next().is(".lineSolid")) {
				elm.next().remove();
			}
			if (isOver) {
				elm.remove();
				elm.next().addClass("textNull");
			}

			elm.remove();
			//cyj
			//EDITARRAY.pop();
		}

		if (key != "") {
			this.deleteSubmit(fn);
		} else {
			fn();
		}
	}

	// ��ӱ���
	_CVMOD.addSave = function(elm, name) {
		var elm = $(elm).parents(".studyUnit");

//		var data = {};

//		elm.find("[data-bind]").each(function() {
//			var bind = $(this).attr("data-bind");
//			data[bind] = $(this).val();
//		});
//		var template = $(
//				"#Template > div[data-template=" + this.tmplateShow + "]")
//				.clone();
//
//		template.find("[data-bind]").each(function() {
//			var bind = $(this).attr("data-bind");
//			$(this).html(data[bind]);
//		})
		this.editSubmit(function() {
			CKupdate();
			// ����˼���
			if (name == 'JKRJL') {
				var params = $('#Work_form_add_2').serialize();
				var url = $("#Work_form_add_2").attr("action");
				var form = $("#Work_form_add_2");
				if(validateField(form)){
				$.ajax({
					url : url, // ��̨�������
					type : 'POST', // ���ݷ��ͷ�ʽ
					data : params, // Ҫ���ݵ�����
					dataType : 'html', // �������ݸ�ʽ
					success : function(data) {
						elm.before(data);
						elm.remove();
						EDITARRAY.pop();
					},
					error : function(data) {
					}
				});
				}
			}else if (name == 'JBXX') {
				$('#currAddrCode').val(getAreaID("currAddr"));
				$('#familyRegCode').val(getAreaID("familyReg"));
				var params = $('#base_form_add_2').serialize();
				var url = $("#base_form_add_2").attr("action");
				var form = $("#base_form_add_2");
				if(validateJBXX(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
						}
					});
				}
			}else if (name == 'JTQK') {
				var params = $('#contact_form_add').serialize();
				var url = $("#contact_form_add").attr("action");
				var form = $("#contact_form_add");
				if(validateContact(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
						}
					});
				}
			     
			}else if (name == 'QYQK') {
				$('#regAddrCode').val(getAreaID("regAddrSel"));
				$('#optAddrCode').val(getAreaID("optAddrSel"));
				var params = $('#firm_form_add').serialize();
				var url = $("#firm_form_add").attr("action");
				var form = $("#firm_form_add");
				if(validateFirm(form) && validateField(form) ){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
							alert(data);
						}
					});
				}
			}else if (name == 'SSJQTBLXX') {
				var params = $('#law_form_add').serialize();
				var url = $("#law_form_add").attr("action");
				var form = $("#law_form_add");
				if(validateLaw(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
							alert(data);
						}
					});
				}
			}else if (name == 'FZ.FC') {
				$('#addrCode').val(getAreaID("addrCodeSel"));
				var params = $('#house_form_add').serialize();
				var url = $("#house_form_add").attr("action");
				var form = $("#house_form_add");
				if(validateHouse(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
							alert(data);
						}
					});
				}
			}else if (name == 'FZ.CL') {
				var params = $('#car_form_add').serialize();
				var url = $("#car_form_add").attr("action");
				var form = $("#car_form_add");
				if(validateCar(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
							alert(data);
						}
					});
				}
			}else if (name == 'FZ.JYZC') {
				var params = $('#otherasset_form_add').serialize();
				var url = $("#otherasset_form_add").attr("action");
				var form = $("#otherasset_form_add");
				if(validateOtherasset(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
							alert(data);
						}
					});
				}
			}else if (name == 'FZ.JYFZ') {
				var params = $('#otherdebt_form_add').serialize();
				var url = $("#otherdebt_form_add").attr("action");
				var form = $("#otherdebt_form_add");
				if(validateDebt(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
							alert(data);
						}
					});
				}
			}else if (name == 'FZ.FZ') {
				var params = $('#creditloan_form_add').serialize();
				var url = $("#creditloan_form_add").attr("action");
				var form = $("#creditloan_form_add");
				if(validateCreditloan(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
							alert(data);
						}
					});
				}
			}else if (name == 'FZ.YXK') {
				var params = $('#creditcard_form_add').serialize();
				var url = $("#creditcard_form_add").attr("action");
				var form = $("#creditcard_form_add");
				if(validateCreditcard(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
							alert(data);
						}
					});
				}
			}else if (name == 'FZ.DWDBQK') {
				var params = $('#guarantee_form_add').serialize();
				var url = $("#guarantee_form_add").attr("action");
				var form = $("#guarantee_form_add");
				if(validateGuarantee(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
							alert(data);
						}
					});
				}
			}else if (name == 'ZX.JQJLTJ') {
				var params = $('#creditDetail_form_add').serialize();
				var url = $("#creditDetail_form_add").attr("action");
				var form = $("#creditDetail_form_add");
				if(validateCreditDetail(form)){
				$.ajax({
					url : url, // ��̨�������
					type : 'POST', // ���ݷ��ͷ�ʽ
					data : params, // Ҫ���ݵ�����
					dataType : 'html', // �������ݸ�ʽ
					success : function(data) {
						elm.before(data);
						elm.remove();
						EDITARRAY.pop();
					},
					error : function(data) {
						alert(data);
					}
				});
				}
			}else if (name == 'ZXCS') {
				var params = $('#creditSum_form_add').serialize();
				var url = $("#creditSum_form_add").attr("action");
				
				$.ajax({
					url : url, // ��̨�������
					type : 'POST', // ���ݷ��ͷ�ʽ
					data : params, // Ҫ���ݵ�����
					dataType : 'html', // �������ݸ�ʽ
					success : function(data) {
						elm.before(data);
						elm.remove();
						EDITARRAY.pop();
					},
					error : function(data) {
						alert(data);
					}
				});
			}else if (name == 'ZXFXSM') {
				var params = $('#mediumDesc_form_add').serialize();
				var url = $("#mediumDesc_form_add").attr("action");
				
				$.ajax({
					url : url, // ��̨�������
					type : 'POST', // ���ݷ��ͷ�ʽ
					data : params, // Ҫ���ݵ�����
					dataType : 'html', // �������ݸ�ʽ
					success : function(data) {
						elm.before(data);
						elm.remove();
						EDITARRAY.pop();
					},
					error : function(data) {
						alert(data);
					}
				});
			}else if (name == 'JYQK') {
				var params = $('#mediumDesc_1_form_add').serialize();
				var url = $("#mediumDesc_1_form_add").attr("action");
				
				$.ajax({
					url : url, // ��̨�������
					type : 'POST', // ���ݷ��ͷ�ʽ
					data : params, // Ҫ���ݵ�����
					dataType : 'html', // �������ݸ�ʽ
					success : function(data) {
						elm.before(data);
						elm.remove();
						EDITARRAY.pop();
					},
					error : function(data) {
						alert(data);
					}
				});
			}else if (name == 'JKYT') {
				var params = $('#mediumDesc_2_form_add').serialize();
				var url = $("#mediumDesc_2_form_add").attr("action");
				
				$.ajax({
					url : url, // ��̨�������
					type : 'POST', // ���ݷ��ͷ�ʽ
					data : params, // Ҫ���ݵ�����
					dataType : 'html', // �������ݸ�ʽ
					success : function(data) {
						elm.before(data);
						elm.remove();
						EDITARRAY.pop();
					},
					error : function(data) {
						alert(data);
					}
				});
			}else if (name == 'BZRXX') {
				var params = $('#mediumDesc_3_form_add').serialize();
				var url = $("#mediumDesc_3_form_add").attr("action");
				
				$.ajax({
					url : url, // ��̨�������
					type : 'POST', // ���ݷ��ͷ�ʽ
					data : params, // Ҫ���ݵ�����
					dataType : 'html', // �������ݸ�ʽ
					success : function(data) {
						elm.before(data);
						elm.remove();
						EDITARRAY.pop();
					},
					error : function(data) {
						alert(data);
					}
				});
			}else if (name == 'FXJSD') {
				var params = $('#mediumDesc_4_form_add').serialize();
				var url = $("#mediumDesc_4_form_add").attr("action");
				
				$.ajax({
					url : url, // ��̨�������
					type : 'POST', // ���ݷ��ͷ�ʽ
					data : params, // Ҫ���ݵ�����
					dataType : 'html', // �������ݸ�ʽ
					success : function(data) {
						elm.before(data);
						elm.remove();
						EDITARRAY.pop();
					},
					error : function(data) {
						alert(data);
					}
				});
			} else if (name == 'DY.FC') {
//				$('#addrCode').val(getAreaID("addrCodeSel"));
				var params = $('#colla_form_add').serialize();
				var url = $("#colla_form_add").attr("action");
				var form = $("#colla_form_add");
//				if(validateHouse(form) && validateField(form)){
					$.ajax({
						url : url, // ��̨�������
						type : 'POST', // ���ݷ��ͷ�ʽ
						data : params, // Ҫ���ݵ�����
						dataType : 'html', // �������ݸ�ʽ
						success : function(data) {
							elm.before(data);
							elm.remove();
							EDITARRAY.pop();
						},
						error : function(data) {
							alert(data);
						}
					});
//				}
			}else {
				elm.before(template);
				elm.remove();
			}

		});
	}

	CVMOD.editInfo = function(elm, name, id) {
		var cfg = _CVMOD.getConfig(name);
		cfg.editInfo(elm, name, id)
	}

	CVMOD.addInfo = function(elm, name) {
		var cfg = _CVMOD.getConfig(name);
		cfg.addInfo(elm, name)
	}

	CVMOD.init = function() {
		$("#jMain").delegate(".studyUnit", "mouseenter", function() {
			if (!$(this).is("[lock]")) {
				$(this).addClass("studyUnitHover");
			}
		}).delegate(".studyUnit", "mouseleave", function() {
			if (!$(this).is("[lock]")) {
				$(this).removeClass("studyUnitHover");
			}
		})
	}

	CVMOD.addModuleConfig = function(name, config) {

		var cfg = _CVMOD.getConfig(name);

		for ( var e in config) {
			cfg[e] = config[e];
		}
	}

	CVMOD.eduSave = function(elm, name) {
		var cfg = _CVMOD.getConfig(name);
		cfg.eduSave(elm, name)
	}
	CVMOD.addSave = function(elm, name) {
		var cfg = _CVMOD.getConfig(name);
		cfg.addSave(elm, name)
	}

	CVMOD.deleteInfo = function(elm, name, id) {
		if (!confirm("�Ƿ�ȷ��ɾ��"))
			return;
		
		if(EDITARRAY.length>0 && id == '0'){
			//cyj
			EDITARRAY.pop();
		}
		
		var cfg = _CVMOD.getConfig(name);

		// ����˼���
		if (name == 'JKRJL' && id != '0') {
			var url = basePath
					+ "/background/responsible/deleteWorkInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {

				}
			});
		}else if (name == 'JTQK' && id != '0') {
			var url = basePath
			+ "/background/responsible/deleteContactInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {
		
				}
			});
		}else if (name == 'QYQK' && id != '0') {
			var url = basePath
			+ "/background/responsible/deleteFirmInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {
		
				}
			});
		}else if (name == 'SSJQTBLXX' && id != '0') {
			var url = basePath
			+ "/background/responsible/deleteLawInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {
		
				}
			});
		}else if (name == 'FZ.FC' && id != '0') {
			var url = basePath
			+ "/background/responsible/deleteHouseInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {
		
				}
			});
		}else if (name == 'FZ.CL' && id != '0') {
			var url = basePath
			+ "/background/responsible/deleteCarInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {
		
				}
			});
		}else if (name == 'FZ.JYZC' && id != '0') {
			var url = basePath
			+ "/background/responsible/deleteOtherassetInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {
		
				}
			});
		}else if (name == 'FZ.JYFZ' && id != '0') {
			var url = basePath
			+ "/background/responsible/deleteOtherdebtInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {
		
				}
			});
		}else if (name == 'FZ.FZ' && id != '0') {
			var url = basePath
			+ "/background/responsible/deleteCreditloanInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {
		
				}
			});
		}else if (name == 'FZ.YXK' && id != '0') {
			var url = basePath
			+ "/background/responsible/deleteCreditcardInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {
		
				}
			});
		}else if (name == 'FZ.DWDBQK' && id != '0') {
			var url = basePath
			+ "/background/responsible/deleteGuaranteeInfo.htm?id=" + id;
			$.ajax({
				url : url, // ��̨�������
				type : 'POST', // ���ݷ��ͷ�ʽ
				dataType : 'json', // �������ݸ�ʽ
				success : function(data) {
					if (typeof (data) != 'object') {
						data = eval('(' + data + ')');
					}
					if (data.success == true) {
						cfg.deleteInfo(elm, name);
					}
				},
				error : function(data) {
		
				}
			});
			
		}   else {
					cfg.deleteInfo(elm, name);
			}
	}
	
}();

$(function() {
	CVMOD.init();
});

// ������Ϣ
CVMOD.addModuleConfig("JBXX", {
	tmplateEdit : 0,
	tmplateShow : 100,
	editSubmit : function(fn) {
		fn();
	}
});

/*---------����˻������------------------------------*/
// ����˼���
CVMOD.addModuleConfig("JKRJL", {
	tmplateEdit : 1,
	tmplateShow : 2,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

// ��ͥ���
CVMOD.addModuleConfig("JTQK", {
	tmplateEdit : 3,
	tmplateShow : 4,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

// �����������ҵ��Ϣ
CVMOD.addModuleConfig("QYQK", {
	tmplateEdit : 5,
	tmplateShow : 6,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

// ���߼�����������Ϣ
CVMOD.addModuleConfig("SSJQTBLXX", {
	tmplateEdit : 7,
	tmplateShow : 8,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

/*-------------------�ʲ���ծ���-------------------------*/
// ����
CVMOD.addModuleConfig("FZ.FC", {
	tmplateEdit : 9,
	tmplateShow : 10,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

// ��Ѻ
CVMOD.addModuleConfig("DY.FC", {
	tmplateEdit : 9,
	tmplateShow : 10,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

// ����
CVMOD.addModuleConfig("FZ.CL", {
	tmplateEdit : 11,
	tmplateShow : 12,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})


// ��Ӫ���ʲ�
CVMOD.addModuleConfig("FZ.JYZC", {
	tmplateEdit : 15,
	tmplateShow : 16,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

// ��ծ
CVMOD.addModuleConfig("FZ.FZ", {
	tmplateEdit : 17,
	tmplateShow : 18,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

// ���ÿ�
CVMOD.addModuleConfig("FZ.YXK", {
	tmplateEdit : 19,
	tmplateShow : 20,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

// ��Ӫ�Ը�ծ
CVMOD.addModuleConfig("FZ.JYFZ", {
	tmplateEdit : 21,
	tmplateShow : 22,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

// ���ⵣ�����
CVMOD.addModuleConfig("FZ.DWDBQK", {
	tmplateEdit : 23,
	tmplateShow : 24,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

///*----------------------------������Ŀ----------------------------*/

// ���ڼ�¼ͳ��
CVMOD.addModuleConfig("ZX.JQJLTJ", {
	tmplateEdit : 25,
	tmplateShow : 26,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

// ���Ų�ѯ����
CVMOD.addModuleConfig("ZXCS", {
	tmplateEdit : 27,
	tmplateShow : 28,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})
// ���ŷ���˵��
CVMOD.addModuleConfig("ZXFXSM", {
	tmplateEdit : 51,
	tmplateShow : 50,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})
//��Ӫ���
CVMOD.addModuleConfig("JYQK", {
	tmplateEdit : 53,
	tmplateShow : 52,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})
//�����;
CVMOD.addModuleConfig("JKYT", {
	tmplateEdit : 55,
	tmplateShow : 54,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})
//��֤����Ϣ
CVMOD.addModuleConfig("BZRXX", {
	tmplateEdit : 57,
	tmplateShow : 56,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})
//���ս�ʾ��
CVMOD.addModuleConfig("FXJSD", {
	tmplateEdit : 59,
	tmplateShow : 58,
	editSubmit : function(fn) {
		fn(Math.random());
	},
	deleteSubmit : function(fn) {
		fn()
	}
})

 //����CKEDITOR��ֵ
function CKupdate() {
    for (instance in CKEDITOR.instances)
        CKEDITOR.instances[instance].updateElement();
}