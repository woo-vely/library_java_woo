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
	<c:url value = "/user/main" var = "userMain" />
	<c:url value = "/user/signUp" var = "userSignUp" />
	<c:url value = "/user/login" var = "userLogin" />
	<c:url value = "/user/bookSearch" var = "userBookSearch" />
	
	<ul>
		<li><a href="${userMain }">Home</a></li>
		<li><a href="${userSignUp }">회원가입</a></li>
		<li><a href="${userLogin }">로그인</a></li>
		<li><a href="${userBookSearch }">도서 검색</a></li>
	</ul>

</body>
