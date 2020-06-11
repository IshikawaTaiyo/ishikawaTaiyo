<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更結果確認画面</title>
<link href="css/commons.css" rel="stylesheet">
<link href="css/a.css" rel="stylesheet">
</head>
<body>
  <p class ="sizu">実行者：${fn:escapeXml(name)}</p>
  <p class ="sizu">パスワードが変更されまた。</p>
  <div>
    <a href="menu.jsp" class="btn-stitch">メニュー画面に戻る</a>
  </div>
</body>
</html>
