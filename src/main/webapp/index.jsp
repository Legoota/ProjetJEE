<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <link title="style" href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
    <title>Polymon</title>
</head>
<body>
    <br/>
    <div>
        <img style="display: block;margin-left: auto;margin-right: auto;" src="${pageContext.request.contextPath}/img/polymon.png" alt="Logo Polymon">
    </div>
    <h2 class="center-align pixel">Bienvenue sur le jeu Polymon !</h2>
    <br/>
    <div class="container">
        <a style="display: block;margin-left: auto;margin-right: auto;width: 10em;" class="waves-effect waves-light btn pixel white black-text" href="/Projet-1.0/login/login">Connexion</a>
    </div>
    <br/>
</body>
</html>
