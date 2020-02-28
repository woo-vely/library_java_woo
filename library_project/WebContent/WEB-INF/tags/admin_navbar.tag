<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	border: 1px solid #e7e7e7;
}

li {
	float: left;
}

li a {
	display: block;
	color: #666;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not (.active ) {
	background-color: #ddd;
}

</style>
</head>
<body>
	<c:url value = "/admin/main" var = "adminMain" />
	<c:url value = "/admin/signUp" var = "adminSignUp" />
	<c:url value = "/admin/login" var = "adminLogin" />
	<c:url value = "/admin/bookManage" var = "adminBookManage" />
	<c:url value = "/admin/bookPC" var = "adminBookPC" />
	<ul>
		<li><a href="${adminMain }">Home</a></li>
		<li><a href="${adminSignUp }">회원가입</a></li>
		<li><a href="${adminLogin }">로그인</a></li>
		<li><a href="${adminBookManage }">도서 관리</a></li>
		<li><a href="${adminBookPC }">대출 & 반납</a></li>
	</ul>

</body>
