<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix = "my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
bookManage
<my:admin_navbar />

<div>
	<form method = "post">
		<select name="type">
			<option value = "lib_idid" >����ID</option>			
			<option value = "title" >������</option>
		</select>
		<input name = "bookSearch">
		<input type = "submit" value = "�˻�">
	</form>
	<c:forEach items = "bSearchResult">
		<c:if test = "${not empty bSearchResult }">
			${bSearchResult.lib_idid }&nbsp;
			${bSearchResult.title }&nbsp;
			${bSearchResult.auth }
		</c:if>
		<c:if test = "${empty bSearchResult }" >
			${message }
		</c:if>
	</c:forEach>
</div>
<hr>
<div>
	<form method = "post" name = "type">
		<select name = "type" style = "display:none;"><option value = "insertBook"></option></select>
		<label><b>����ID</b></label>
		<input name="lib_idid"><br> 
		<label><b>������</b></label>
		<input name="title"><br> 
		<label><b>����</b></label>
		<input name = "auth"><br> 
		<label><b>���ǻ�</b></label>
		<input name = "publ"><br> 
		<label><b>������</b></label>
		<input name="pyb" type = "date" ><br>
		<label><b>û����ȣ</b></label>
		<input name = "call_no"><br> 
		<label><b>���� ����</b></label>
		<input name = "brch_code"><br> 
		<input type="submit" value="���� �߰�">

	</form>
</div>

<my:footer />
</body>
</html>