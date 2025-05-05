<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un utilisateur</title>
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
            color: red;
            font-size: 12px;
            margin-top: 5px;
        }
        .success {
            color: green;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Ajouter un utilisateur</h1>
    
    <% 
    // Récupérer les erreurs s'il y en a
    Map<String, String> erreurs = null;
    String statusMessage = null;
    if(request.getAttribute("form") != null) {
        erreurs = (Map<String, String>)((forms.UserForm)request.getAttribute("form")).getErreurs();
        statusMessage = ((forms.UserForm)request.getAttribute("form")).getStatusMessage();
    }
    %>
    
    <% if(statusMessage != null) { %>
        <p class="success">${form.statusMessage}</p>
    <% } %>
    
    <form action="add" method="post">
        <div>
            <label for="nom">Nom :</label>
            <input type="text" id="nom" name="nom" required>
            <% if(erreurs != null && erreurs.containsKey("nom")) { %>
                <span class="error"><%= erreurs.get("nom") %></span>
            <% } %>
        </div>
        
        <div>
            <label for="prenom">Prénom :</label>
            <input type="text" id="prenom" name="prenom" required>
            <% if(erreurs != null && erreurs.containsKey("prenom")) { %>
                <span class="error"><%= erreurs.get("prenom") %></span>
            <% } %>
        </div>
        
        <div>
            <label for="login">Login :</label>
            <input type="text" id="login" name="login" required>
            <% if(erreurs != null && erreurs.containsKey("login")) { %>
                <span class="error"><%= erreurs.get("login") %></span>
            <% } %>
        </div>
        
        <div>
            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" required>
            <% if(erreurs != null && erreurs.containsKey("password")) { %>
                <span class="error"><%= erreurs.get("password") %></span>
            <% } %>
        </div>
        
        <div>
            <label for="passwordBis">Confirmez le mot de passe :</label>
            <input type="password" id="passwordBis" name="passwordBis" required>
            <% if(erreurs != null && erreurs.containsKey("passwordBis")) { %>
                <span class="error"><%= erreurs.get("passwordBis") %></span>
            <% } %>
        </div>
        
        <button type="submit">Enregistrer</button>
    </form>
    
    <div class="links">
        <a href="list">Retour à la liste</a>
    </div>
</body>
</html>