$(function() {
	$("#PWD").focus(function() {
		$(this).hide();
		$("#password").val("").show().css("backgroundColor", "#fff").focus();
	});
	$("#password").blur(function() {
		$(this).show().css("backgroundColor", "#fff");
		$("#PWD").hide();
	});
	$("#UN").focus(function() {
		$(this).hide();
		$("#userName").val("").show().css("backgroundColor", "#fff").focus();
	});
	$("#userName").blur(function() {
		$(this).show().css("backgroundColor", "#fff");
		$("#UN").hide();
	});
});

$(function() {
	$("#loginuser").click(function() {
		$("#error").html("");
	});
	$("#loginpwd").click(function() {
		$("#error").html("");
	});

	$("#errorMsg").html("");
	$('.loginbox').css({
		'position' : 'absolute',
		'left' : ($(window).width() - 692) / 2
	});
	$(window).resize(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
	})
});
function checkUserForm() {
	var userName = $("#textfield").val();
	var userPassword = $("#textfield2").val();
	if (userName == "" || userPassword == "") {
		alert("用户名或密码不能为空");
		return false;
	}
	document.loginForm.submit();
}
// 按回车键
document.onkeydown = function(e) {
	var event = e || window.event;
	if (event.keyCode == 13) {
		checkUserForm();
	}
};
