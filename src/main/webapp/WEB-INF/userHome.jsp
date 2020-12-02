<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>

<body>
<c:choose>
    <c:when test="${empty cookie['pseudo'].value}">
        <h1>Bonjour vous!</h1>
        <a href="/Projet-1.0/login/login">Connexion</a>
    </c:when>
    <c:otherwise>
        <h1>Bonjour <c:out value="${cookie['pseudo'].value}"/>!</h1>
        <a href="/Projet-1.0/login/logout">Déconnexion</a>
        <br/>
        <br/>
        <a href="/Projet-1.0/parcours/nouveau">Nouvelle partie</a>
    </c:otherwise>
</c:choose>

</body>
</html>