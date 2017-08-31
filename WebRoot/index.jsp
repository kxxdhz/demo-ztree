<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>权限控制zTree</title>
     
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" href="css/demo.css" type="text/css">
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="js/jquery.ztree.all-3.5.min.js"></script>
	 <script type="text/javascript" src="js/myZtree.js"></script>
	 <script type="text/javascript">
	 
	    var zTree; //定义zTree对象
	
	   //注意的是，要想后台获得json的数据，setting配置里必须要把Ztree的异步获取数据打开。
	
		var setting = {
				view: {
					dblClickExpand: false  //设置是否双击鼠标左键打开
				},async: {
					enable: true, //是否打开异步请求
					url:"<%=basePath%>ztree/ZtreeServlet"	//异步请求的地址				
				},data: {
					simpleData: {
						enable:true,
						idKey: "id",  //设置字段ID格式
						pIdKey: "pid"  //设置父ID的格式
					}
				},check:{
					enable : true   //是否有复选框：true?false
					
				},callback: {
					onClick:onClick, //鼠标单击事件
					onRightClick:OnRightClick, //鼠标屏蔽右键
// 					onAsyncSuccess: zTreeOnAsyncSuccess //默认
				},edit:{
				  enable : false //是否允许编辑
				},showLine:false  //是否允许有下划线

			};
	
		     var treeNodes;  //定义Ztree的节点数组
		    //var j = jQuery.noConflict();
			$(document).ready(function(){
		
			 $.ajax({	
			        type: "post",  
			        dataType : "text",  //返回json格式	    
			        url: "<%=basePath%>ztree/ZtreeServlet",  //请求的URL路径  
			        success:function(data){ //请求成功后处理函数。  	
			           treeNodes= jQuery.parseJSON(data);
			           zTree=$.fn.zTree.init($("#treeDemo"), setting, treeNodes);
			           var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			     	   treeObj.expandAll(true);
			        }
			 });
			 
			 //获取选中的数据
			 $("#click").click(function(){	
				 var check = zTree.getCheckedNodes(true);
				$.each(check,function(index,value){
					alert("id:"+value.id+"   name:"+value.name);
				});
				 
			 });
			});
	 </script>

  </head>
  
  <body>

 <input type="button" name="click" id="click" value="点击获取Ztree的数据" /><p></p>
 
 <ul id="treeDemo" class="ztree"></ul>

  </body>
</html>
