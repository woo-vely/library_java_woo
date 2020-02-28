<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:url value = "/admin/main" var = "adminMain" />
		<button><a href = "${adminMain }">admin</a></button>
	</div>
	<div>
		<c:url value = "/user/main" var = "userMain" />
		<button><a href = "${userMain }">user</a></button>
	</div>
</body>
</html>