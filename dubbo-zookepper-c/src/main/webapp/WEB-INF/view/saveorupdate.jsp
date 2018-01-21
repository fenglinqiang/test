<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/common/mystyle.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id="productForm">
			<input type="hidden"   name="taid"  value="${user.taid}">
		 <div class="form-group">
		    <label for="proName">名称</label>
		    <input type="text" class="form-control" value="${user.taname}"  name="taname" placeholder="名称">
		  </div>
		<div class="form-group">
		<label for="exampleInputPassword1">价格</label> <input type="number"
			name="taage" value="${user.taage}" class="form-control"/>
		</div>
		  
		<div class="form-group">
		    <label for="proDate">日期</label>
		    <input class="form-control" id="proDate" name="tabir" value="${user.showDate}" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
		  </div>
		</form>
</body>
</html>