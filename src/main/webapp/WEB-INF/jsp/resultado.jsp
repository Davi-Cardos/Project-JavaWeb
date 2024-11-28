<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String mensagemSucesso = (String) request.getAttribute("mensagemSucesso"); %>
<% String mensagemErro = (String) request.getAttribute("mensagemErro"); %>

<% if (mensagemSucesso != null) { %>
    <p style="color: green;"><%= mensagemSucesso %></p>
<% } %>

<% if (mensagemErro != null) { %>
    <p style="color: red;"><%= mensagemErro %></p>
<% } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resultado</title>
</head>
<body>
<a href="./index.html">Voltar</a>
</body>
</html>