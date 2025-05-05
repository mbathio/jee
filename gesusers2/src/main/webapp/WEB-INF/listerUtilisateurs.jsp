<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Utilisateur" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des utilisateurs</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
            color: #333;
        }
        
        .container {
            max-width: 1000px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        
        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 30px;
            padding-bottom: 10px;
            border-bottom: 2px solid #3498db;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
        }
        
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        th {
            background-color: #3498db;
            color: white;
            font-weight: 600;
            text-transform: uppercase;
            font-size: 14px;
        }
        
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        
        tr:hover {
            background-color: #e9f7fe;
        }
        
        .no-users {
            text-align: center;
            padding: 20px;
            color: #777;
            font-style: italic;
            background-color: #f9f9f9;
            border-radius: 5px;
            margin: 20px 0;
        }
        
        .action-link {
            display: inline-block;
            padding: 6px 12px;
            margin: 2px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
            transition: all 0.3s ease;
        }
        
        .edit-link {
            background-color: #2ecc71;
            color: white;
        }
        
        .delete-link {
            background-color: #e74c3c;
            color: white;
        }
        
        .edit-link:hover {
            background-color: #27ae60;
        }
        
        .delete-link:hover {
            background-color: #c0392b;
        }
        
        .add-button {
            display: inline-block;
            background-color: #3498db;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }
        
        .add-button:hover {
            background-color: #2980b9;
        }
        
        .footer {
            margin-top: 30px;
            text-align: center;
            font-size: 14px;
            color: #777;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Liste des utilisateurs</h1>
        
        <% 
        ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) request.getAttribute("utilisateurs");
        if (utilisateurs == null || utilisateurs.isEmpty()) {
        %>
            <p class="no-users">Aucun utilisateur enregistré.</p>
        <% 
        } else {
        %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Login</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    for (Utilisateur utilisateur : utilisateurs) {
                    %>
                        <tr>
                            <td><%= utilisateur.getId() %></td>
                            <td><%= utilisateur.getNom() %></td>
                            <td><%= utilisateur.getPrenom() %></td>
                            <td><%= utilisateur.getLogin() %></td>
                            <td>
                                <a href="update?id=<%= utilisateur.getId() %>" class="action-link edit-link">Modifier</a>
                                <a href="delete?id=<%= utilisateur.getId() %>" class="action-link delete-link" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?')">Supprimer</a>
                            </td>
                        </tr>
                    <% 
                    }
                    %>
                </tbody>
            </table>
        <% 
        }
        %>
        
        <a href="add" class="add-button">Ajouter un utilisateur</a>
        
        <div class="footer">
            Application de gestion des utilisateurs - Projet J2EE
        </div>
    </div>
</body>
</html>