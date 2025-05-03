<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authentification</title>
    <!-- Lien vers un fichier CSS si besoin -->
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <h1>Données</h1>
    <form method="post" action="login">
        <label for="login">Login :</label>
        <input type="text" id="login" name="login" required><br><br>

        <label for="password">Password :</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Connexion">
    </form>
</body>
</html>
