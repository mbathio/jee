<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="login-container">
        <div class="login-title">
            <h1>Inscription</h1>
        </div>
        <form class="login-form" action="<%=request.getContextPath()%>/inscription" method="post">
            <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" id="nom" name="nom" placeholder="Entrez votre nom" required>
            </div>
            <div class="form-group">
                <label for="prenom">Prénom</label>
                <input type="text" id="prenom" name="prenom" placeholder="Entrez votre prénom" required>
            </div>
           
            <div class="form-group">
                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" placeholder="Choisissez un mot de passe" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Entrez votre email" required>
            </div>
            <button type="submit" class="login-btn">S'inscrire</button>
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
            <a href="<%=request.getContextPath()%>/connexion">Déjà inscrit ? Se connecter</a>
        </div>
    </div>
    
    <script>
        document.querySelector('.login-form').addEventListener('submit', function(e) {
            const nom = document.getElementById('nom');
            const prenom = document.getElementById('prenom');
            const password = document.getElementById('password');
            const email = document.getElementById('email');
            
            if (nom.value.trim().length < 2) {
                e.preventDefault();
                alert('Le nom doit contenir au moins 2 caractères');
                return;
            }
            
            if (prenom.value.trim().length < 2) {
                e.preventDefault();
                alert('Le prénom doit contenir au moins 2 caractères');
                return;
            }
            
            if (password.value.length < 6) {
                e.preventDefault();
                alert('Le mot de passe doit contenir au moins 6 caractères');
                return;
            }
            
            // Simple email validation
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email.value)) {
                e.preventDefault();
                alert('Veuillez entrer une adresse email valide');
                return;
            }
        });
    </script>
</body>
</html>