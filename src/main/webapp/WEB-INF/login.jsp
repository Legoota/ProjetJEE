<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
    <h1>Connexion</h1>
    <br/>
    <p>
        <form method="post">
            <label for="pseudo">Pseudo : </label>
            <input type="text" name="pseudo" id="pseudo" required placeholder="Votre pseudo"/>
            <br/>
            <label for="password">Mot de passe : </label>
            <input type="password" name="password" id="password" required>
            <br/>
            <input type="submit" />
        </form>
    </p>
    <br/>
    <a href="/Projet-1.0/login/signup">Nouveau joueur ? Inscrivez-vous !</a>
    <br/>
</body>
</html>
