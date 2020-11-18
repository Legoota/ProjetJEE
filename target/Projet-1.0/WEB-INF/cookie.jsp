<%--
  Created by IntelliJ IDEA.
  User: leokr
  Date: 11/11/2020
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Using cookies</title>
</head>

<body>
<c:choose>
    <c:when test="${empty cookie['nom'].value}">
        <h1>Bonjour vous!</h1>
    </c:when>
    <c:otherwise>
        <h1>Bonjour <c:out value="${cookie['nom'].value}"/>!</h1>
    </c:otherwise>
</c:choose>

<br/>
<a href="/Projet_war">Main page</a>
<br/>
<a href="/Projet_war/session">Using sessions</a>

<form method="post">
    <p>
        <label for="nom">Votre pseudo</label> : <input type="text" name="nom" id="nom" />
    </p>
</form>

</body>
</html>