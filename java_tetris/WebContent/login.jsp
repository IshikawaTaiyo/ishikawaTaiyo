<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
<link href="css/a.css" rel="stylesheet">
</head>
<body>

  <p class="error">${fn:escapeXml(IdPass)}</p>

  <form action="LoginServlet" method="post">
    <fieldset>
      <div>
        <label>名前</label>
        <input type="text" name="nameId">
        <span class="error"></span>
      </div>
      <div>
        <label>PASS</label>
        <input type="password" name="pass">
        <span class="error"></span>
      </div>
    </fieldset>
    <button class="btn-stitch" type="submit">ログイン</button>
  </form>
  <div>
    <a href="index.jsp"class="btn-stitch">TOP画面に戻る</a>
  </div>
</body>
</html>
