<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <title>Nouveau Parcours</title>
</head>
<body>
    <h1>Choisissez votre <i>Polymon</i> pour démarrer.</h1>
    <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom('Carapuce')}" width="250" height="250"/>
    <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom('Salameche')}" width="250" height="250"/>
    <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom('Bulbizarre')}" width="250" height="250"/>
    <br/>
    <c:out value="${sessionScope.plds.getPolymonByNom('Carapuce').getNom()}"/>
    <br/>
    <c:out value="${sessionScope.plds.getPolymonByNom('Salameche').getNom()}"/>
    <br/>
    <c:out value="${sessionScope.plds.getPolymonByNom('Bulbizarre').getNom()}"/>
    <br/>
</body>
</html>
