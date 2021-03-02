<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="kv" items="${kv }">
${kv.timestamp }
<br>
		<img
			src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${kv.killChampionEn}.png"
			onerror="this.style.display='none';" height="30px" width="30px">
kill!
<img
			src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${kv.victimChampionEn }.png"
			onerror="this.style.display='none';" height="30px" width="30px">
		<br>
Assist
<c:forEach var="as" items="${kv.assistList}">
	 <img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${as.assistChampionEn}.png" onerror="this.style.display='none';" height="30px" width="30px">

 

</c:forEach>
	</c:forEach>


	<h1>---------------------------------------------------------------</h1>









</body>
</html>