/**
 * 字符串常用方法
 */
String.prototype.trim=function(){
	return this.replace(/^\s+/, '').replace(/\s+$/, '');
}
String.prototype.isInteger=function(){
		var str=this.trim();
    	return new Number(parseInt(str)).toString()===str;
}
String.prototype.isFloat=function(){
		var str=this.trim();
    	
    	var length=str.length;
    	if(str.indexOf(".")===str.lastIndexOf (".")){
    	    while(str.charAt(--length)==='0'||str.charAt(length)==='.'){
    			 str=str.substring(0,length);
    	    }
    	}
    	return new Number(parseFloat(str)).toString()===str;
}
String.prototype.isNone=function(){
	return this.trim().length===0;
}

String.isNone=function(str){
	
	return (typeof str==="undefined")||str===null||str.trim().length===0;
}

/**
 * 获取dom元素
 * @param target 可传入id，tagName，name等
 * id -- 直接传入id值
 * name--参数格式为@name
 * tagName--传入"<div>";
 * @param doc 文档对象，默认为当前窗口的document
 * @returns 返回dom元素，多个返回数组
 */
var $=function(target,doc){
	if(typeof target!=="string"){
		return target;
	}
	var $result;
	doc=doc||document;
	if(target.charAt(0)==="@"){
		$result=doc.getElementsByName(target.substr(1));
		return $result;
	}else if(target.charAt(0)==="<"&&target.charAt(target.length-1)===">"){
		$result=doc.getElementsByTagName(target.substring(1,target.length-1));
		return $result;
	}else{
		return doc.getElementById(target);
	}
};

/**
 * 事件绑定工具方法,定义在$变量上
 * @param $node 事件注册对象
 * @param type 事件类型
 * @param callback 事件处理方法引用
 * @returns
 */
$.bind=function($node,sType,fCallback){
	//转换事件类型为全部小写
	var sIEType=(sType=sType.toLowerCase());
	//如果是ie
	if($node.attachEvent){
		$node.attachEvent((sType.charAt(0)==='o'&&sType.charAt(1)==="n")?sType:"on"+sType,fCallback);
	}else if($node.addEventListener){//如果非ie
		$node.addEventListener((sType.charAt(0)==='o'&&sType.charAt(1)==="n")?sType.substr(2):sType,fCallback);
	}
};
/**
 * 取消事件绑定工具方法
 * @param e 事件注册对象
 * @param type 事件类型
 * @param callback 事件处理方法引用
 * @returns
 */
$.unbind=function($node,sType,fCallback){
	//转换事件类型为全部小写
	var sIEType=(sType=sType.toLowerCase());
	//如果是ie
	if($node.detachEvent){
		$node.attachEvent((sType.charAt(0)==='o'&&sType.charAt(1)==="n")?sType:"on"+sType,fCallback);
	}else if($node.addEventListener){//如果非ie
		$node.removeEventListener((sType.charAt(0)==='o'&&sType.charAt(1)==="n")?sType.substr(2):sType,fCallback);
	}
};



/*------------------------分页----------------------------------------*/

/***
 * 页面跳转
 * @param iPageNo 当前页码
 * @param iPageSize 分页大小
 * @returns void
 */
var fJumpPage=function(iPageNo,iPageSize){
	
	//如果未传入当前页码，则取页面元素默认值
	iPageNo=iPageNo||$("jumpPageNoInput").value;
	//如果未传入分页大小，则取页面元素默认值
	iPageSize=iPageSize||$("pageSizeInput").value;
	//改变查询表单页码input的值
	$("@pageNo")[0].value=iPageNo;
	//改变查询表单分页大小input的值
	$("@pageSize")[0].value=iPageSize;

	//提交form表单
	$("queryForm").submit();
};

var checkPageSizeValid=function(input){
	if(input.value==""){
		return;
	}
	var maxPageNo=input.totalNo;
	var inputPageSize=parseInt(input.value);
	if(isNaN(inputPageSize)||inputPageSize<0){
		alert("请输入正整数");
		input.value="";
		return;
	}
}

var checkPageNoValid=function(input){
	if(input.value==""){
		return;
	}
	var maxPageNo=input.totalNo;
	var inputNo=parseInt(input.value);
	if(isNaN(inputNo)||inputNo>maxPageNo){
		alert("请输入合法页码");
		input.value="";
		return;
	}
}

