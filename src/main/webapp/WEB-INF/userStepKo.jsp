<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <link title="style" href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
    <title>Défaite</title>
</head>
    <body class="background">
        <h3 class="center-align pixel">Votre ${sessionScope.uds.getPolymonFromUser(cookie['pseudo'].value).getNom()} est K.O, vous avez perdu votre partie.</h3>
        <br/><br/>
        <a style="display: block;margin-left: auto;margin-right: auto;width: 30em;" class="waves-effect waves-light btn pixel white black-text" href="/Projet-1.0/parcours/nouveau">Nouvelle partie</a>
        <br/>
        <a style="display: block;margin-left: auto;margin-right: auto;width: 30em;" class="waves-effect waves-light btn pixel white black-text" href="/Projet-1.0/login/logout">Deconnexion</a>
    </body>
</html>
