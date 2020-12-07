<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <link title="style" href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<c:choose>
    <c:when test="${empty cookie['pseudo'].value}">
        <h2 class="center-align pixel">Bonjour vous!</h2>
        <a style="display: block;margin-left: auto;margin-right: auto;width: 30em;" class="waves-effect waves-light btn pixel white black-text" href="/Projet-1.0/login/login">Connexion</a>
    </c:when>
    <c:otherwise>
        <h2 class="center-align pixel">Bonjour <c:out value="${cookie['pseudo'].value}"/>!</h2>
        <a style="display: block;margin-left: auto;margin-right: auto;width: 30em;" class="waves-effect waves-light btn pixel white black-text" href="/Projet-1.0/login/logout">Deconnexion</a>
        <br/>
        <br/>
        <a style="display: block;margin-left: auto;margin-right: auto;width: 30em;" class="waves-effect waves-light btn pixel white black-text" href="/Projet-1.0/parcours/nouveau">Nouvelle partie</a>
    </c:otherwise>
</c:choose>

</body>
</html>