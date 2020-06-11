<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
<link href="css/a.css" rel="stylesheet">
</head>
<body>
  <table>
   	<h1>検索結果一覧</h1>
   	<p>検索条件一致：${fn:escapeXml(numberSearch)}件</p>
    <thead>
			<tr>
				<th>名前</th>
				<th>最高スコア</th>
				<th>総プレイ回数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${searchUser}">
				<tr>
					<td>${fn:escapeXml(user.userName)}</td>
					<td>${fn:escapeXml(user.tetrisScoreMax)}点</td>
					<td>${fn:escapeXml(user.numberOfPlays)}回</td>
				</tr>
			</c:forEach>
		</tbody>
    </tbody>
  </table>
  <div>
    <a href="LogoutServlet"class="btn-stitch">TOP画面に戻る</a>
  </div>
</body>
</html>
