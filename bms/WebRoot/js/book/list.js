
/**
 * 全选/全不选
 * @returns
 */
var fToggleCheckRow=function(evt){
	evt=evt||window.event;
	//获取事件源
	var $target=evt.srcElement||evt.target;
	//获取所有checkbox
	var $bookCheckBoxs=$("@bookId");
	for ( var i = 0; i <$bookCheckBoxs.length; i++) {
		//如果不一样，则设置为一样
		if($bookCheckBoxs[i].checked!==$target.checked){
			$bookCheckBoxs[i].checked=$target.checked;
		}
	}
};



/**
 * 删除按钮点击事件处理
 * @returns void
 */
var fDelBook=function(){
	
	//获取所用checkbox
	var $bookCheckBoxs=$("@bookId");
	//定义删除图书的数组
	var checksbookIds=[];
	for ( var i = 0; i <$bookCheckBoxs.length; i++) {
		//如果图书被选中
		if($bookCheckBoxs[i].checked){
			//保存到被删除图书数组，注意保存的是图书id
			checksbookIds.push($bookCheckBoxs[i].value);
		}
	}
	//如果一个都没选中，则忽略此次点击事件
	if(checksbookIds.length==0){
		return;
	}
	//删除操作比较危险，我们一般会再一次确认此操作。
	if(!window.confirm("确认删除所选图书？")){
		//取消删除动作，直接返回。
		return;
	}
	$("deleteForm").submit();
	
	
};






