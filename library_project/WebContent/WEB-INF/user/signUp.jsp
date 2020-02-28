<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix = "my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	user signUp
	<my:user_navbar />
	
	<div>
		<c:url value = "/user/signUp" var = "signUpUrl" />	<!-- c:url 안에 들어가있으면 jsp코드로 인식 -->
		<form method="post" action = "${signUpUrl }">
			<label><b>아이디</b></label>
			<input name = "id"><br> 
			<label><b>패스워드</b></label>
			<input name = "password" type = "password"><br> 
			<label><b>패스워드 확인</b></label>
			<input name = "pw" type = "password"><br> 
			<label><b>이름</b></label>
			<input name = "name"><br> 
			<label><b>성별</b></label>
			<input name = "gender" type = "radio" value = "M" >M
			<input name = "gender" type = "radio" value = "F" >F<br>
			<input type="submit" value="signUp">
		</form>
	</div>
	
	<div id = "message"></div>
	<my:footer />
</body>
</html>