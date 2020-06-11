<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
<link href="css/commons.css" rel="stylesheet">
<link href="css/a.css" rel="stylesheet">
</head>
<body>
  <p class="sizu">
    登録情報を入力してください<br> <span class="required"></span>
  </p>

  <p class="error">${fn:escapeXml(Duplication)}</p>

  <form action="InsertServlet" method="post">
    <fieldset class="label-60">
      <div>
        <label class="required">名前</label>
        <input type="text" name="nameId">
        <span class="error">${fn:escapeXml(userName)}</span>
      </div>
      <div>
        <label class="required">PASS</label>
        <input type="password" name="pass">
        <span class="error">${fn:escapeXml(password)}</span>
      </div>
    </fieldset>
    <button class="btn-stitch"type="submit">登録</button>
  </form>
  <div>
    <a href="index.jsp"class="btn-stitch">TOP画面に戻る</a>
  </div>
</body>
</html>
