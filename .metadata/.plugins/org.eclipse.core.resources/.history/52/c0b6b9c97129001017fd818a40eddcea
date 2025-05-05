
<!DOCTYPE html>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    </style>
</head>
<body>
    <h1>Ajouter un utilisateur</h1>
    
    <form action="add" method="post">
        <div>
            <label for="nom">Nom :</label>
            <input type="text" id="nom" name="nom" required>
        </div>
        
        <div>
            <label for="prenom">Prénom :</label>
            <input type="text" id="prenom" name="prenom" required>
        </div>
        
        <div>
            <label for="login">Login :</label>
            <input type="text" id="login" name="login" required>
        </div>
        
        <div>
            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" required>
        </div>
        
        <button type="submit">Ajouter</button>
    </form>
    
    <div class="links">
        <a href="list">Retour à la liste</a>
    </div>
</body>
</html>