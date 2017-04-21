
/**
 * 全选/全不选
 * @returns
 */
var fToggleCheckRow=function(evt){
	evt=evt||window.event;
	//获取事件源
	var $target=evt.srcElement||evt.target;
	//获取所有checkbox
	var $studentCheckBoxs=$("@studentId");
	for ( var i = 0; i <$studentCheckBoxs.length; i++) {
		//如果不一样，则设置为一样
		if($studentCheckBoxs[i].checked!==$target.checked){
			$studentCheckBoxs[i].checked=$target.checked;
		}
	}
};



/**
 * 删除按钮点击事件处理
 * @returns void
 */
var fDelStudent=function(){
	
	//获取所用checkbox
	var $studentCheckBoxs=$("@studentId");
	//定义删除学生的数组
	var checksstudentIds=[];
	for ( var i = 0; i <$studentCheckBoxs.length; i++) {
		//如果学生被选中
		if($studentCheckBoxs[i].checked){
			//保存到被删除学生数组，注意保存的是学生id
			checksstudentIds.push($studentCheckBoxs[i].value);
		}
	}
	//如果一个都没选中，则忽略此次点击事件
	if(checksstudentIds.length==0){
		return;
	}
	//删除操作比较危险，我们一般会再一次确认此操作。
	if(!window.confirm("确认删除所选学生？")){
		//取消删除动作，直接返回。
		return;
	}
	$("deleteForm").submit();
	
	
};






