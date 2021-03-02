<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="${profileIcon }"><p>
소환사 이름 : ${name }<p>
소환사 레벨 : ${summonerLevel }<p>


<a href="InGameC">인게임 정보</a>

<jsp:include page="${summonerPage}"></jsp:include>

</body>
</html>