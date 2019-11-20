<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		function check(){//return true:正常提交	return false:表单终止提交
			var sno=$("#sno").val();
			var sname=$("#sname").val();
			var sage=$("#sage").val();
			var saddress=$("#saddress").val();
			if(!(sno>0 && sno<1000)){
				alert("学号有误，必须是1-1000");
				return false;
			}
			if(!(sname.length>1 && sname.length<4)){
				alert("姓名有误，最多6个字");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<form action="AddStudentServlet" method="post" onsubmit="return check()">
		学号：<input type="text" name="sno" id="sno"/><br/>		
		姓名：<input type="text" name="sname" id="sname"/><br/>		
		年龄：<input type="text" name="sage" id="sage"/><br/>	
		地址：<input type="text" name="saddress" id="saddress"/><br/>	
		<input type="submit" value="新增" /><br/>	
	</form>
	
</body>
</html>