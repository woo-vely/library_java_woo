<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="my"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	user login
	<my:user_navbar />
	
	<div>
		<form method = "post">
			<label>아이디</label>
			<input name = "id"><br>
			<label>비밀번호</label>
			<input name = "password" type = "password">
			<input type = "submit" value = "login">
		</form>
	</div>
	
	<my:footer />
</body>
</html>