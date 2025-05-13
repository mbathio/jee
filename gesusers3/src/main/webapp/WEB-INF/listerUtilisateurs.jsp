<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Utilisateur" %>

<%-- Inclusion du header --%>
<%@ include file="inc/header.jsp" %>

<h1>Liste des utilisateurs</h1>

<% 
ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) request.getAttribute("utilisateurs");
if (utilisateurs == null || utilisateurs.isEmpty()) {
%>
    <p class="empty-message">Aucun utilisateur enregistré.</p>
<% 
} else {
%>
    <div class="table-container">
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
                    if (utilisateur != null) {
                %>
                    <tr>
                        <td><%= utilisateur.getId() %></td>
                        <td><%= utilisateur.getNom() %></td>
                        <td><%= utilisateur.getPrenom() %></td>
                        <td><%= utilisateur.getLogin() %></td>
                        <td class="actions">
                            <a href="update?id=<%= utilisateur.getId() %>" class="btn btn-edit">Modifier</a>
                            <a href="delete?id=<%= utilisateur.getId() %>" class="btn btn-delete" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?')">Supprimer</a>
                        </td>
                    </tr>
                <% 
                    }
                }
                %>
            </tbody>
        </table>
    </div>
<% 
}
%>

<div class="actions-container">
    <a href="add" class="btn btn-add">Ajouter un utilisateur</a>
</div>

<%-- Inclusion du footer --%>
<%@ include file="inc/footer.jsp" %>