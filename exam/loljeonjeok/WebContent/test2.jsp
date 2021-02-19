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
<h1>${queueType }</h1>
<h3>${min }분 ${sec}초</h3>
<c:forEach items="${md }" var="md">

<div style="border: 1px solid; float: left; width: 17%;">

<h3>${md.summonerName }</h3>
<c:if test="${md.win eq '승리'}">
<h3 style="color:blue">승리</h3>
</c:if>
<c:if test="${md.win eq '패배'}">
<h3 style="color:red">패배</h3>
</c:if>
<table>
<tr><td>
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${md.championEn }.png" height="100px" width="100px"><br>${md.championKr}</td>
<td>
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer}/img/spell/${md.spell1Id }" height="20px" width="20px"><img src="https://ddragon.leagueoflegends.com/cdn/${curVer}/img/spell/${md.spell2Id }" height="20px" width="20px">
<br>
<img src="https://ddragon.leagueoflegends.com/cdn/img/${md.keyperks }" height="20px" width="20px"><img src="https://ddragon.leagueoflegends.com/cdn/img/${md.perkSubStyle }" height="20px" width="20px">
</td></tr>
<tr><td>K/D/A ${md.kills }/${md.deaths }/${md.assists }<br>${md.kda }</td><td>${md.position }</td></tr>
<tr>
<td>

<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item0}.png" height="20px" width="20px">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item1}.png" height="20px" width="20px">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item2}.png" height="20px" width="20px"><br>
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item3}.png" height="20px" width="20px">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item4}.png" height="20px" width="20px">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item5}.png" height="20px" width="20px"><br>
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item6}.png" height="20px" width="20px">
</td>
<td>${md.pb }</td>
</tr>
</table>

</div>
</c:forEach>
</body>
</html>