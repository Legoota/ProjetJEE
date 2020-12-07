<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <link title="style" href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
    <h2 class="center-align pixel">Inscription</h2>
    <div style="background: #FFFFFF; margin-left: auto; margin-right: auto; width: 42.5em; border-radius: 5px; box-shadow: 1px 1px 1px black; padding: 10px">
        <form class="col s12 pixel" method="post">
            <label for="prenom">Prenom : </label>
            <input type="text" name="prenom" id="prenom" required/>
            <label for="nom">Nom : </label>
            <input type="text" name="nom" id="nom" required />
            <label for="pseudo">Pseudo : </label>
            <input type="text" name="pseudo" id="pseudo" required />
            <label for="password">Mot de passe : </label>
            <input type="password" name="password" id="password" required />
            <input style="background-color: #79c9fa; display: block;margin-left: auto;margin-right: auto;width: 30em;" class="waves-effect waves-light btn pixel black-text" type="submit" />
        </form>
    </div>


</body>
</html>
