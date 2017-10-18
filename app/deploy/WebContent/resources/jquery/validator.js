/*******************************************************************************
 * Validator v1.01 code by 我佛山人 wfsr@cunite.com http://www.cunite.com
 *
 * /^((\(\d{3}\))|(\d{3}\-))?13\d{9}$/,老版手机验证
 ******************************************************************************/
Validator = {
	/*
	 * //角色名称,目录名称,服务名称,服务模块名称,数据库名称 Require :/^$/,//必填字段，字母、数字、下划线、中文
	 * //账号,密码,服务名称(en),服务代码,异常类型(code),数据库用户名,数据库密码,表名(en),列名(en) CodeRequire
	 * :/^$/,//字母、数字、下划线 //服务名称(ch),异常类型(ch),表名(ch),列名(ch) NameRequire
	 * :/^$/,//中文、数字、下划线 //工号,目录序号,服务并发数 Integer :/^[-\+]?\d+$/,
	 *
	 * Username :/^$/,//用户名称,中文或英文 Phone
	 * :/^((\(\d{3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}$/,//电话，区号-号码，4位-8位
	 * Mobile :/^(13[0-9]|15[0|1|2|3|6|7|8|9]|18[6|7|8|9])\d{8}$/,//手机，11位 Email
	 * :/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,//电子邮箱，字母、数字和下划线@字母、数字和下划线。字母、数字和下划线
	 *
	 * Versions :/^$/,//版本号，数字和小数点 Serverlocation :/^$/,//服务url， JDBCurl
	 * :/^$/,//数据库url， Tablerecord :/^$/,//
	 */

	Require : /.+/,
	Email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
	Phone : /^((\(\d{3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}$/,
	Mobile : /^(13[0-9]|15[0-9]|18[0-9])\d{8}$/,
	Url : /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,
	IdCard : /^\d{15}(\d{2}[A-Za-z0-9])?$/,
	Currency : /^\d+(\.\d+)?$/,
	Number : /^\d+$/,
	Zip : /^[1-9]\d{5}$/,
	QQ : /^[1-9]\d{4,8}$/,
	Integer : /^[-\+]?\d+$/,
	Double : /^[-\+]?\d+(\.\d+)?$/,
	English : /^[A-Za-z]+$/,
	EnglishName: /^(?!_)(?!.*?_$)[a-zA-Z_]+$/,
	Chinese : /^[\u0391-\uFFE5]+$/,
	FilePath : /^[a-zA-Z]:(((\\(?! )[0-9a-zA-Z]+)+\\?)|(\\))\s*$/, 
	SpecialSymbols :/^[^%_]+$/,
	UnSafe : /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/,
	Ip:/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/,
	Integer2:/^[0-9]*[1-9][0-9]*$/,
	Ip2:/^(?:(?:[1-9]?[0-9]|1[0-9]{2}|2(?:[0-4][0-9]|5[0-5]))\.){3}(?:[1-9]?[0-9]|1[0-9]{2}|2(?:[0-4][0-9]|5[0-5]))$/,
	IsSafe : function(str) {
		return !this.UnSafe.test(str);
	},
	SafeString : "this.IsSafe(value)",
	Limit : "this.limit(value.length,getAttribute('min'), getAttribute('max'))",
	LimitB : "this.limit(this.LenB(value), getAttribute('min'), getAttribute('max'))",
	Date : "this.IsDate(value, getAttribute('min'), getAttribute('format'))",
	Repeat : "value == document.getElementsByName(getAttribute('to'))[0].value",
	Range : "getAttribute('min') < value && value < getAttribute('max')",
	Compare : "this.compare(value,getAttribute('operator'),getAttribute('to'))",
	Custom : "this.Exec(value, getAttribute('regexp'))",
	Group : "this.MustChecked(getAttribute('name'), getAttribute('min'), getAttribute('max'))",
	ErrorItem : [document.forms[0]],
	ErrorMessage : ["以下原因导致提交失败：/t/t/t/t"],
	Validate : function(theForm, mode) {
		var obj = theForm || event.srcElement;
		var count = obj.elements.length;
		this.ErrorMessage.length = 1;
		this.ErrorItem.length = 1;
		this.ErrorItem[0] = obj;
		for (var i = 0; i < count; i++) {
			with (obj.elements[i]) {
				var _dataType = getAttribute("dataType");
				if ( typeof (_dataType) == "object" || typeof (this[_dataType]) == "undefined")
					continue;
				this.ClearState(obj.elements[i]);
				if (getAttribute("require") == "false" && value == "")
					continue;
				switch (_dataType) {
					case "Date":
						if (getAttribute("msg") == null) {
							// 删除前面的红点
							// $("span").remove(".Error");
							this.AddError(i, "日期不存在");
						}
						break;
					case "Repeat":
					case "Range":
					case "Compare":
					case "Custom":
					case "Group":
					case "Limit":
					case "LimitB":
					case "SafeString":
						if (!eval(this[_dataType])) {
							// 删除前面的红点
							// $("span").remove(".Error");
							this.AddError(i, getAttribute("msg"));
						}
						break;
						
					default:
				
						if (!this[_dataType].test(value?$.trim(value):value)) {  //非空校验严格
							if (_dataType == "Require" && getAttribute("msg") == null) {
								// 删除前面的红点
								// $("span").remove(".Error");
								this.AddError(i, "不允许为空");
							} else {
								// 删除前面的红点
								// $("span").remove(".Error");
								this.AddError(i, getAttribute("msg"));
							}
						}
						break;
				}
			}
		}
		if (this.ErrorMessage.length > 1) {
			mode = mode || 1;
			var errCount = this.ErrorItem.length;
			switch (mode) {
				case 2:
					for (var i = 1; i < errCount; i++)
						this.ErrorItem[i].style.color = "red";
				case 1:
					alert(this.ErrorMessage.join("\n"));
					if (this.ErrorItem[1].type != 'hidden') {
						this.ErrorItem[1].focus();
					}
					break;
				case 3:
					for (var i = 1; i < errCount; i++) {
						try {
							var span = document.createElement("SPAN");
							span.id = "__ErrorMessagePanel";
							span.style.color = "red";
							this.ErrorItem[i].parentNode.appendChild(span);
							span.innerHTML = this.ErrorMessage[i].replace(/\d+:/, "\n");
							// 原来\n*

						} catch (e) {
							alert(e.description);
						}
					}
					if (this.ErrorItem[1].type != 'hidden') {
						this.ErrorItem[1].focus();
					}
					break;
				default:
					alert(this.ErrorMessage.join("\n"));
					break;
			}
			return false;
		}
		return true;
	},
	limit : function(len, min, max) {
		min = min || 0;
		max = max || Number.MAX_VALUE;
		return min <= len && len <= max;
	},
	LenB : function(str) {
		return str.replace(/[^\x00-\xff]/g, "**").length;
	},
	ClearState : function(elem) {
		with (elem) {
			if (style.color == "red")
				style.color = "";
			var lastNode = parentNode.childNodes[parentNode.childNodes.length - 1];
			if (lastNode.id == "__ErrorMessagePanel")
				parentNode.removeChild(lastNode);
		}
	},
	AddError : function(index, str) {
		this.ErrorItem[this.ErrorItem.length] = this.ErrorItem[0].elements[index];
		this.ErrorMessage[this.ErrorMessage.length] = this.ErrorMessage.length + ":" + str;
	},
	Exec : function(op, reg) {
		return new RegExp(reg, "g").test(op);
	},
	compare : function(op1, operator, op2) {
		switch (operator) {
			case "NotEqual":
				return (op1 != op2);
			case "GreaterThan":
				return (op1 > op2);
			case "GreaterThanEqual":
				return (op1 >= op2);
			case "LessThan":
				return (op1 < op2);
			case "LessThanEqual":
				return (op1 <= op2);
			default:
				return (op1 == op2);
		}
	},
	MustChecked : function(name, min, max) {
		var groups = document.getElementsByName(name);
		var hasChecked = 0;
		min = min || 1;
		max = max || groups.length;
		for (var i = groups.length - 1; i >= 0; i--)
			if (groups[i].checked)
				hasChecked++;
		return min <= hasChecked && hasChecked <= max;
	},
	IsDate : function(op, formatString) {
		formatString = formatString || "ymd";
		var m, year, month, day;
		switch (formatString) {
			case "ymd":
				m = op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
				if (m == null)
					return false;
				day = m[6];
				month = m[5]--;
				year = (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));
				break;
			case "dmy":
				m = op.match(new RegExp("^(\\d{1,2})([-./])(\\d{1,2})\\2((\\d{4})|(\\d{2}))$"));
				if (m == null)
					return false;
				day = m[1];
				month = m[3]--;
				year = (m[5].length == 4) ? m[5] : GetFullYear(parseInt(m[6], 10));
				break;
			default:
				break;
		}
		if (!parseInt(month))
			return false;
		month = month == 12 ? 0 : month;
		var date = new Date(year, month, day);
		return ( typeof (date) == "object" && year == date.getFullYear() && month == date.getMonth() && day == date.getDate());
		function GetFullYear(y) {
			return ((y < 30 ? "20" : "19") + y) | 0;
		}

	}
};
