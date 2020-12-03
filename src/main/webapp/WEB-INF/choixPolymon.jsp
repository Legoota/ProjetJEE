<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <title>Nouveau Parcours</title>
</head>
<body>
    <h1>Choisissez votre <i>Polymon</i> pour démarrer.</h1>
    <a href="/Projet-1.0/parcours/starter/carapuce">
        <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom('Carapuce')}" width="250" height="250"/>
    </a>
    <a href="/Projet-1.0/parcours/starter/salameche">
        <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom('Salameche')}" width="250" height="250"/>
    </a>
    <a href="/Projet-1.0/parcours/starter/bulbizarre">
        <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom('Bulbizarre')}" width="250" height="250"/>
    </a>
    <br/>
    <c:out value="${sessionScope.plds.getPolymonByNom('Carapuce').getNom()}"/>
    <br/>
    <c:out value="${sessionScope.plds.getPolymonByNom('Salameche').getNom()}"/>
    <br/>
    <c:out value="${sessionScope.plds.getPolymonByNom('Bulbizarre').getNom()}"/>
    <br/>

</body>
</html>
