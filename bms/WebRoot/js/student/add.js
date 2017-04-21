/**
 * AJAx新增用户
 * @returns
 */
var userFormSubmit=function(form){
	var queryString=[];
	var name=form.name.value;
	queryString.push("name="+name);
	var account=form.account.value;
	queryString.push("account="+account);
	var stateRadios=$("@state");
	
	var state;
	for(var i=0;i<stateRadios.length;i++){
		if(stateRadios[i].checked){
				state=stateRadios[i].value;
				break;
		}
		
	}
	queryString.push("state="+state);
	var remark=form.remark.value;
	queryString.push("remark="+remark);
	
	$.ajax(form.action,function(){
		var jsonStr=this.responseText;
		var responce=eval("("+jsonStr+")");
		alert(responce.message);
		//获取父窗口的传递的对话框参数（新增用户完成时的回调）
		var callback=window.dialogArguments;
		//如果存在回调，则执行回调
		if(callback){
			callback(responce.state);
		}	
		if(responce.state){//表示添加成功
			window.close();		
		}
	}).post(queryString.join("&"));
	
};



