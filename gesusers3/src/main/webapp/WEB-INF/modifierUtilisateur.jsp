<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="beans.Utilisateur" %>

<%-- Inclusion du header --%>
<%@ include file="header.jsp" %>

<h1>Modifier un utilisateur</h1>

<% 
// Récupérer l'utilisateur et les erreurs s'il y en a
Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
Map<String, String> erreurs = null;
String statusMessage = null;
if(request.getAttribute("form") != null) {
    erreurs = (Map<String, String>)((forms.UserForm)request.getAttribute("form")).getErreurs();
    statusMessage = ((forms.UserForm)request.getAttribute("form")).getStatusMessage();
}

if(request.getAttribute("erreur") != null) { 
%>
    <p class="error-message">${erreur}</p>
<% 
} 

if(statusMessage != null) { 
%>
    <p class="success-message">${form.statusMessage}</p>
<% 
} 

if(utilisateur != null) { 
%>
    <form action="update" method="post">
        <input type="hidden" name="id" value="${utilisateur.id}">
        
        <div>
            <label for="nom">Nom :</label>
            <input type="text" id="nom" name="nom" value="${utilisateur.nom}" required>
            <% if(erreurs != null && erreurs.containsKey("nom")) { %>
                <span class="error"><%= erreurs.get("nom") %></span>
            <% } %>
        </div>
        
        <div>
            <label for="prenom">Prénom :</label>
            <input type="text" id="prenom" name="prenom" value="${utilisateur.prenom}" required>
            <% if(erreurs != null && erreurs.containsKey("prenom")) { %>
                <span class="error"><%= erreurs.get("prenom") %></span>
            <% } %>
        </div>
        
        <div>
            <label for="login">Login :</label>
            <input type="text" id="login" name="login" value="${utilisateur.login}" required>
            <% if(erreurs != null && erreurs.containsKey("login")) { %>
                <span class="error"><%= erreurs.get("login") %></span>
            <% } %>
        </div>
        
        <div>
            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" value="${utilisateur.password}" required>
            <% if(erreurs != null && erreurs.containsKey("password")) { %>
                <span class="error"><%= erreurs.get("password") %></span>
            <% } %>
        </div>
        
        <div>
            <label for="passwordBis">Confirmez le mot de passe :</label>
            <input type="password" id="passwordBis" name="passwordBis" value="${utilisateur.password}" required>
            <% if(erreurs != null && erreurs.containsKey("passwordBis")) { %>
                <span class="error"><%= erreurs.get("passwordBis") %></span>
            <% } %>
        </div>
        
        <button type="submit" class="btn btn-edit">Enregistrer les modifications</button>
    </form>
<% 
} else { 
%>
    <p class="error-message">Utilisateur non trouvé.</p>
<% 
} 
%>

<%-- Inclusion du footer --%>
<%@ include file="footer.jsp" %>