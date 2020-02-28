<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>signUp</title>

<link rel="stylesheet" type="text/css" href="/WEB-INF/css/style_form.css" />

</head>
<body>
	admin signUp
	<my:admin_navbar />
	
	<div>
		<c:url value = "/admin/signUp" var = "signUpUrl" />	<!-- c:url �ȿ� �������� jsp�ڵ�� �ν� -->
		<form method="post" action = "${signUpUrl }">
			<label><b>���̵�</b></label>
			<input class="form-element-full-width" name="id" value="${loginAdmin.id }" placeholder="id"><br> 
			<label><b>�н�����</b></label>
			<input class="form-element-full-width" id="pw1" name="password" value="${loginAdmin.password }" type="password" placeholder="password"><br> 
			<label><b>�н����� Ȯ��</b></label>
			<input class="form-element-full-width" id="pw2" type="password" placeholder="password check"><br> 
			<label><b>�̸�</b></label>
			<input class="form-element-full-width" name="name" value="${loginAdmin.name }" placeholder="name"><br> 
			<label><b>����</b></label>
			<input class="form-element-full-width" name="birth" type = "date" value="${loginAdmin.birth }" ><br>
			<input type="submit" value="signUp">
		</form>
	</div>
	
	<div id = "message"></div>
	<my:footer />
</body>
</html>