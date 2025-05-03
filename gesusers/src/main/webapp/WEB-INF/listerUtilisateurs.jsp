<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des utilisateurs</title>
</head>
<body>
	<h1>Liste des utilisateurs</h1>
	<%
	ArrayList<Utilisater> utilisateurs = (ArrayList<Utilisateur>) request.getAttribute("utilisateur");
	
	if(utilisateur.isEmpty())
	{%>
	<p>
	Désolé, la liste des utilisateurs est vide. <br>
	Vous pouvez en ajouter en cliquant <a href="add>ici</a>
	</p>
	}
	%>
</body>
</html>