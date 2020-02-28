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
	<my:user_navbar />
	<div>
		<form method="post">
			<select name="type">
				<option value="title">도서명</option>
				<option value="auth">저자</option>
				<option value="publ">출판사</option>
				<option value="pyb">출판년도</option>
			</select> 
			<input name="bookSearch"> 
			<input type="submit" value="검색">
		</form>
		
		<c:if test="${not empty bSearchResult }">
			<c:forEach items="bSearchResult">
				${bSearchResult.lib_idid }
			</c:forEach>
		</c:if>
			<c:if test="${empty bSearchResult }">
				${message }
			</c:if>
	
	</div>
	<my:footer />
</body>
</html>