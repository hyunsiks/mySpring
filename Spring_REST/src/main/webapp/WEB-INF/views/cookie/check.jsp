<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<c:if test="${login }">
	<h1 style="color: blue;">로그인 상태에서 파랑게 보이는 글씨</h1>
</c:if>

</body>
</html>