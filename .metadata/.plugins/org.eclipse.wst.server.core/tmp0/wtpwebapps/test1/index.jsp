<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil - Mon Application</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="login-container">
        <div class="login-title">
            <h1>Bienvenue</h1>
        </div>
        <div class="menu-links">
            <a href="<%=request.getContextPath()%>/connexion" class="login-btn">Connexion</a>
            <a href="<%=request.getContextPath()%>/table" class="login-btn">Table de Multiplication</a>
            <a href="<%=request.getContextPath()%>/hello" class="login-btn">Dire Bonjour</a>
            <a href="<%=request.getContextPath()%>/inscription" class="login-btn">Inscription</a>
        </div>
    </div>
</body>
</html>