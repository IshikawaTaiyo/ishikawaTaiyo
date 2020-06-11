<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果確認画面</title>
<link href="css/commons.css" rel="stylesheet">
<link href="css/a.css" rel="stylesheet">
</head>
<body>
  <p class ="sizu">実行者：${fn:escapeXml(user_name)}</p>
  <p class ="sizu">正常に登録されました</p>
  <div>
    <a href="login.jsp" class="btn-stitch">ログイン画面に行く</a>
    <p></p>
    <a href="index.jsp" class="btn-stitch">TOP画面に戻る</a>
  </div>
</body>
</html>
