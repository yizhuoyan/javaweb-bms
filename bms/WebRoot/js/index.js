/***
 * 页面加载完成事件处理
 */
window.onload=function(){
	//给菜单新增点击事件
	fMenuBindClickListener();
};

/**
 * 给所有菜单绑定点击事件
 * @returns void
 */
var fMenuBindClickListener=function(){
	//获取所有菜单标签li元素
	var links=$("<li>",$("menu"));
	for(var i=0;i<links.length;i++){
		//调用commom.js定义的工具方法	绑定点击事件，fMenuClickHandler为处理方法
		$.bind(links[i],"click",fMenuClickHandler);				
	}
};
/**
 * 菜单点击事件处理方法
 * @param evt IE不会传递此参数，非IE传递
 * 
 * @returns void
 */
var fMenuClickHandler = function(evt) {
		evt = evt || window.event;
		var $target = evt.srcElement || evt.$target;
		var $oldSelected = $("mainFrame").selected;
		$("mainFrame").src = $target.getAttribute("url");
		if ($target == $oldSelected) {
			return;
		}
		if ($oldSelected) {
			$oldSelected.className = "";
			$("<strong>", $oldSelected).innerHTML = "✧";
		}
		$target.className = "selected";
		var $strong = $("<strong>", $target);
		$strong.innerHTML = "✦";
		$("mainFrame").selected = $target;
};

/**
 * 修改密码
 * @returns
 */
var fModPassword=function(){
	$.window("jsp/user/modPassword.jsp",function(bSuccessful,redirectURL){
		if(bSuccessful){//成功，则页面跳转到登录页面
			var baseURL=$("<base>")[0].href;
			window.location.href=baseURL+"login.jsp";
		}
		
	});
}