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
<h2>진행 중 게임 정보</h2>
<h2>${queueType }</h2>
<c:forEach items="${igs }" var="ig">

<div style="border: 1px solid; float: left; width: 17%;">
<h2>${ig.summonerName}</h2>
<c:if test="${ig.teamId eq '100'}">
<h3 style="color:blue">블루팀</h3>
</c:if>
<c:if test="${ig.teamId eq '200'}">
<h3 style="color:red">레드팀</h3>
</c:if>
<table>
<tr><td><img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${ig.championIdEn }.png"><br>${ig.championIdKr}</td><td></td></tr>
<tr><td><img src="https://ddragon.leagueoflegends.com/cdn/${curVer}/img/spell/${ig.spell1Id }" height="20px" width="20px"><img src="https://ddragon.leagueoflegends.com/cdn/${curVer}/img/spell/${ig.spell2Id }" height="20px" width="20px"></td>
<td><img src="https://ddragon.leagueoflegends.com/cdn/img/${ig.keyperks }" height="20px" width="20px"><img src="https://ddragon.leagueoflegends.com/cdn/img/${ig.perkSubStyle }" height="20px" width="20px"></td></tr>
</table>

</div>
</c:forEach>
</body>
</html>