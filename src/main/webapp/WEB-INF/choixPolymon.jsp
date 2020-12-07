<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <link title="style" href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
    <title>Choix du Polymon</title>
</head>
<body class="background">
    <h3 class="center-align pixel">Choisissez votre Polymon pour demarrer.</h3>
    <div class="container">
        <div class="row">
            <div class="col s3">
                <div class="card">
                    <div class="card-image">
                        <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom('Carapuce')}" width="250" height="250"/>
                        <span class="card-title black-text pixel">Carapuce</span>
                    </div>
                    <div class="card-content">
                        <p><c:out value="${sessionScope.plds.getPolymonByNom('Carapuce').getDescription()}"/></p>
                    </div>
                    <div class="card-action">
                        <a class="pixel" href="/Projet-1.0/parcours/starter/carapuce">Selectionner ce Polymon !</a>
                    </div>
                </div>
            </div>
            <div class="col s1"></div>
            <div class="col s3">
                <div class="card">
                    <div class="card-image">
                        <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom('Salameche')}" width="250" height="250"/>
                        <span class="card-title black-text pixel">Salameche</span>
                    </div>
                    <div class="card-content">
                        <p><c:out value="${sessionScope.plds.getPolymonByNom('Salameche').getDescription()}"/></p>
                    </div>
                    <div class="card-action">
                        <a class="pixel" href="/Projet-1.0/parcours/starter/salameche">Selectionner ce Polymon !</a>
                    </div>
                </div>
            </div>
            <div class="col s1"></div>
            <div class="col s3">
                <div class="card">
                    <div class="card-image">
                        <img src="data:image/jpg;base64,${sessionScope.plds.getImageByNom('Bulbizarre')}" width="250" height="250"/>
                        <span class="card-title black-text pixel">Bulbizarre</span>
                    </div>
                    <div class="card-content">
                        <p><c:out value="${sessionScope.plds.getPolymonByNom('Bulbizarre').getDescription()}"/></p>
                    </div>
                    <div class="card-action">
                        <a class="pixel" href="/Projet-1.0/parcours/starter/bulbizarre">Selectionner ce Polymon !</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
