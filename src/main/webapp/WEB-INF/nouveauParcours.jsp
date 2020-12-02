<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <title>Nouveau Parcours</title>
</head>
<body>
    <h1>Choisissez votre <i>Polymon</i> pour démarer.</h1>
    <c:out value="${sessionScope.plds.getPolymonByNom('Carapuce').getNom()}"/>
    <br/>
    <c:out value="${sessionScope.plds.getPolymonByNom('Salameche').getNom()}"/>
    <br/>
    <c:out value="${sessionScope.plds.getPolymonByNom('Bulbizarre').getNom()}"/>
    <br/>
</body>
</html>
