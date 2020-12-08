<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <link title="style" href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
    <title>Félicitations</title>
</head>
<body class="background">
    <h3 class="center-align pixel">Felicitations, vous avez battu le Polymon !</h3>
    <h5 class="center-align pixel"> Maintenant, choisissez par quel chemin vous allez passer...</h5>
    <div class="container">
        <div class="row">
            <div class="col s1"></div>
        <c:forEach items="${sessionScope.uds.getNextStepNameByStepIdent(cookie['pseudo'].value)}" var="item">

                <div class="col s4">
                    <div class="card blue-grey darken-1">
                        <div class="card-content white-text">
                            <span class="card-title pixel">${sessionScope.uds.getStepFromStepIdent(item).getNom()}</span>
                            <p class="pixel">${sessionScope.uds.getStepFromStepIdent(item).getDescription()}</p>
                        </div>
                        <div class="card-action">
                            <a class="pixel" href="/Projet-1.0/parcours/step/choose/${sessionScope.uds.numeroStepIdent(cookie['pseudo'].value,item)}">Choisir ce lieu</a>
                        </div>
                    </div>
                </div>
            <div class="col s1"></div>
        </c:forEach>
            <div class="col s1"></div>
        </div>
    </div>
</body>
</html>
