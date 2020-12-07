<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <link title="style" href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
    <title>${sessionScope.uds.getParcoursFromUser(cookie['pseudo'].value).getNom()}</title>
</head>
<body class="background">
    <h2 class="center-align pixel">Bienvenue sur l'ile de ${sessionScope.uds.getParcoursFromUser(cookie['pseudo'].value).getNom()} !</h2>

    <div class="container">
        <p class="center-align pixel">Vous allez commencer votre aventure avec votre fidele ${sessionScope.uds.getPolymonFromUser(cookie['pseudo'].value).getNom()} !</p>
        <br/><br/>
        <a style="display: block;margin-left: auto;margin-right: auto;width: 10em;" class="waves-effect waves-light btn pixel white black-text" href="/Projet-1.0/parcours/step/new">Demarrer</a>
    </div>
</body>
</html>
