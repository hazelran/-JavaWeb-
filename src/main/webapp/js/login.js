function check(form) {
	if (document.forms.myform.username.value == "") {
		alert("123");
		document.forms.myform.username.focus();
		return false;
	}
	if (document.forms.myform.userpass.value == "") {
		alert("请输入密码 ");
		document.forms.myform.userpass.focus();
		return false;
	}
}
