<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	login
	<my:navbar />
	
	<div>
		<form method = "post">
			<label>���̵�</label>
			<input name = "id" value = "${loginAdmin.id }"><br>
			<label>��й�ȣ</label>
			<input name = "pw" value = "${loginAdmin.password }">
			<input type = "submit" value = "login">
		</form>
	</div>
	
	<my:footer />
</body>
</html>