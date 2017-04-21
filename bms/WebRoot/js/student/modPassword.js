/**
 * AJAx修改用户密码
 * @returns
 */
var modPasswordFormSubmit=function(form){
	var queryString=[];
	var oldPassword=form.oldPassword.value;
	queryString.push("oldPassword="+oldPassword);
	var newPassword=form.newPassword.value;
	queryString.push("newPassword="+newPassword);
	var confirmNewPassword=form.confirmNewPassword.value;
	queryString.push("confirmNewPassword="+confirmNewPassword);
	
	$.ajax(form.action,function(){
		var jsonStr=this.responseText;
		var responce=eval("("+jsonStr+")");
		alert(responce.message);
		//获取父窗口的传递的对话框参数
		var callback=window.dialogArguments;
		//如果存在回调，则执行回调
		if(callback){
			callback(responce.state);
		}	
		if(responce.state){//表示成功
			
			window.close();	
			
		}
	}).post(queryString.join("&"));
	
};



