<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un utilisateur</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            max-width: 500px;
            margin: 20px 0;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            margin-top: 20px;
            border: none;
            cursor: pointer;
        }
        .links {
            margin-top: 20px;
        }
        .links a {
            text-decoration: none;
            color: #0066cc;
            margin-right: 15px;
        }
        .error {
            color: #cc0000;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Modifier un utilisateur</h1>
    
    <% if(request.getAttribute("erreur") != null) { %>
        <p class="error">${erreur}</p>
    <% } %>
    
    <form action="update" method="post">
        <input type="hidden" name="id" value="${utilisateur.id}">
        
        <div>
            <label for="nom">Nom :</label>
            <input type="text" id="nom" name="nom" value="${utilisateur.nom}" required>
        </div>
        
        <div>
            <label for="prenom">Prénom :</label>
            <input type="text" id="prenom" name="prenom" value="${utilisateur.prenom}" required>
        </div>
        
        <div>
            <label for="login">Login :</label>
            <input type="text" id="login" name="login" value="${utilisateur.login}" required>
        </div>
        
        <div>
            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" value="${utilisateur.password}" required>
        </div>
        
        <button type="submit">Enregistrer</button>
    </form>
    
    <div class="links">
        <a href="list">Retour à la liste</a>
    </div>
</body>
</html>