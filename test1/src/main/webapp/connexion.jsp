<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="login-container">
        <div class="login-title">
            <h1>Connexion</h1>
        </div>
        <form class="login-form" action="<%=request.getContextPath()%>/connexion" method="post">
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" id="login" name="login" placeholder="Entrez votre login" required>
            </div>
            <div class="form-group">
                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" placeholder="Entrez votre mot de passe" required>
            </div>
            <button type="submit" class="login-btn">Se connecter</button>
        </form>
        
        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <div class="error-message">
                <%= message %>
            </div>
        <% } %>
        
        <div class="additional-links">
            <a href="<%=request.getContextPath()%>/inscription">Pas encore inscrit ? Créer un compte</a>
        </div>
    </div>

    <script>
        document.querySelector('.login-form').addEventListener('submit', function(e) {
            const login = document.getElementById('login');
            const password = document.getElementById('password');
            
            if (login.value.trim().length < 3) {
                e.preventDefault();
                alert('Le login doit contenir au moins 3 caractères');
                return;
            }
            
            if (password.value.length < 6) {
                e.preventDefault();
                alert('Le mot de passe doit contenir au moins 6 caractères');
                return;
            }
        });
    </script>
</body>
</html>