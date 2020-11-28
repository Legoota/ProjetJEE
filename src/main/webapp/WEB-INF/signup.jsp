<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
    <h1>Inscription</h1>
    <p>
        <form method="post">
            <label for="prenom">Prénom : </label>
            <input type="text" name="prenom" id="prenom" />
            <br/>
            <label for="nom">Nom : </label>
            <input type="text" name="nom" id="nom" />
            <br/>
            <label for="pseudo">Pseudo : </label>
            <input type="text" name="pseudo" id="pseudo" />
            <br/>
            <label for="password">Mot de passe : </label>
            <input type="password" name="password" id="password" />
            <br/>
            <input type="submit" />
        </form>
    </p>
</body>
</html>
