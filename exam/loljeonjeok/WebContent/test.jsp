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
<div style="width:200px; margin: 0 auto">
<img src="http://ddragon.leagueoflegends.com/cdn/${curVer }/img/profileicon/${sicon}.png" width="200px" height="200px"><p>
소환사 이름 : ${sname }<p>
소환사 레벨 : ${slv}<p>
<c:if test="${nowgame eq 1}">
현재 게임중입니다!<button onclick="location.href='ingamenow?id=${sid}'">인게임 정보 확인하기</button><p>
</c:if>
<c:if test="${nowgame eq null}">
현재 게임중이 아닙니다.<p>
</c:if>
</div>

<c:forEach items="${mls }" var="ml">
<div style="border: 1px solid; margin: 0 auto; width: 33%; padding:10px;" onclick="location.href='matchdetail?mid=${ml.gameId}'">
	
<table>
<tr><td>${ml.queue }</td><td><img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${ml.championEn }.png"><br>${ml.championKr}</td></tr>
<tr><td>${ml.timestamp }</td><td>${ml.position }</td></tr>
</table>

</div>
</c:forEach>


</body>
</html>