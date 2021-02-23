<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>소환사 정보</h1>

	<table>

		<tr>
			<td><img id="icon" src="http://ddragon.leagueoflegends.com/cdn/11.4.1/img/profileicon/4881.png"></td>
			<td>${loldata.profileIconId }</td>
		</tr>

		<tr>
			<td>소환사 명</td>
			<td>${loldata.name }</td>
		</tr>

		<tr>
			<td>소환사 레벨</td>
			<td>${loldata.summonerLevel }</td>
		</tr>


	</table>

</body>
</html>