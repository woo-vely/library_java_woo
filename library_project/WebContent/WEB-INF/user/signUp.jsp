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
		<c:url value = "/user/signUp" var = "signUpUrl" />	<!-- c:url �ȿ� �������� jsp�ڵ�� �ν� -->
		<form method="post" action = "${signUpUrl }">
			<label><b>���̵�</b></label>
			<input name = "id"><br> 
			<label><b>�н�����</b></label>
			<input name = "password" type = "password"><br> 
			<label><b>�н����� Ȯ��</b></label>
			<input name = "pw" type = "password"><br> 
			<label><b>�̸�</b></label>
			<input name = "name"><br> 
			<label><b>����</b></label>
			<input name = "gender" type = "radio" value = "M" >M
			<input name = "gender" type = "radio" value = "F" >F<br>
			<input type="submit" value="signUp">
		</form>
	</div>
	
	<div id = "message"></div>
	<my:footer />
</body>
</html>