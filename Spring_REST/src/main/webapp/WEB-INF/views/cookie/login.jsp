<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면 파랗게 보이는 페이지</title>
</head>
<body>

<c:if test="${login == '1'}">
	<style>
		h1{
		color: blue;
		}
	</style>
	<h1>로그인 성공!</h1>
</c:if>
<c:if test="${login != '1'}">
	<style>
		h1{
		color: red;
		}
	</style>
	<h1>로그인 실패!</h1>
</c:if>

<a href="./check">로그인 여부에 따라 다르게 보이는 페이지로 가기</a>


</body>
</html>