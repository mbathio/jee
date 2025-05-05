<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Utilisateur" %>

<!DOCTYPE html>
<html>
<!-- ... en-tête inchangée ... -->
<body>
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
</body>
</html>