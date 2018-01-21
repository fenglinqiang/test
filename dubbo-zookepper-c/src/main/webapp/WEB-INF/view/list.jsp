<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/common/mystyle.jsp"></jsp:include>
</head>
<body>
<table id="queryUserInfoId"></table>
<script type="text/javascript">
	$(function(){
		$("#queryUserInfoId").bootstrapTable({
			 url:"<%=request.getContextPath()%>/user/queryUser.do",	
			 method:"post",
			 striped: true,  	// 斑马线效果     默认false 
			 //只允许选中一行
			 singleSelect:true,
			 //选中行是不选中复选框或者单选按钮
			 clickToSelect:true,
			 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
			 cardView: false,                    //是否显示详细视图
			 uniqueId: "taid",                 //每一行的唯一标识，一般为主键列
			 showColumns: true,                  //是否显示所有的列
			 showRefresh: true,                  //是否显示刷新按钮
			 minimumCountColumns: 2,     //  最少留两列
			 detailView: false,                  //是否显示父子表
			 //发送到服务器的数据编码类型  
			contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
			//toolbar:'#tabToolBarId',   //  工具定义位置
			columns:[
						{field:'taid',title:'用户id',width:100},
						{field:'taname',title:'用户名称',width:100},
						{field:'taage',title:'登录账号',width:100},
						{field:'tabir',title:'登录时间',width:100,
							formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
							var simfomat = new Date();
			        		simfomat.setTime(value);   //转换时间
			        		return  simfomat.toLocaleDateString();
						}},	
						{field:'--',title:'操作',width:100,
							formatter:function(value,row,index){ 
								var str = "<input type='button' value='修改' onclick='showUpList("+row.taid+")'>";
										
								return  str;
						}}

			         ],
			         //传递参数（*）
					 queryParams: function(params) {
						 	var whereParams = {    
						 			/*
						 				分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）           
						 			*/
						 			"pageSize":params.limit,
						 			"start":params.offset,
						 			
						 	}
							 return whereParams;
						 },
						 //前台--排序字段
						 //sortName:'proPrice',
						 //sortOrder:'desc',
						 //前台--搜索框
						 search:true,
						 //启动回车键做搜索功能
						 searchOnEnterKey:true,
				   	    //分页方式   后台请求的分页方式
						 sidePagination:'server',
						  pagination: true,                   //是否显示分页（*）
						 pageNum: 1,                       //每页的记录行数（*）
						 pageSize: 6,                       //每页的记录行数（*）
						 pageList: [3, 6, 9,12],         //可供选择的每页的行数（*） 
			});
		})
		//进页面
	function getJspHtmlb(urlStr){
		 var  jspHtml = "";
//		 async  (默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
	//注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
			$.ajax({
				url:urlStr,
				type:'get',
				//同步的ajax
				async:false,
				success:function(data){
					//alert(data);//data--addProduct.jsp页面内容
					jspHtml = data;
				},
				error:function(){
					bootbox.alert("ajax失败");
				}
			});
		return jspHtml;
	};
//弹框
	function  showUpList(taid){
		var dialog = bootbox.dialog({
			title: "修改",
		    message: getJspHtmlb('<%=request.getContextPath()%>/user/queryUpdate.do?taid='+taid),   //调用方法  
		    buttons:{
    				"save":{
					  label: '确定',
					  //自定义样式
					  className: "btn-success",
					  callback: function() {
						  //alert(1)
							  $.ajax({
									url:"<%=request.getContextPath()%>/user/updateUser.do",
									data:$("#productForm").serialize(),
									type:'post',
									success:function(data){
										location.href=location;
										$("#queryUserInfoId").bootstrapTable('refresh');
										bootbox.alert("修改成功");
										
									},
									error:function(){
										bootbox.alert("ajax失败");
									}
								});
						
					  }
					},
					"unSave":{
						  label: '取消',
						  //自定义样式
						 className: "btn-info",
						  callback: function() {
							 // return false;  //dialog不关闭
						  }
						}
				}
		});
	};
		
</script>
</body>
</html>