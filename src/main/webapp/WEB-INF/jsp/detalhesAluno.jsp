<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Entidades.ResultSet.copy.Linha" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalhes do Aluno</title>
</head>
<body>
    <h1>Detalhes do Aluno</h1>
    <% 
        Linha dadosAluno = (Linha) request.getAttribute("dadosAluno");
        if (dadosAluno != null) {
    %>
        <p>ID: <%= dadosAluno.getValor("id") %></p>
        <p>IRA: <%= dadosAluno.getValor("ira") %></p>
        <p>Carga Horária: <%= dadosAluno.getValor("CargaHoraria") %></p>
    <% 
        } else {
    %>
        <p>Aluno não encontrado.</p>
    <% 
        } 
    %>
    <a href="welcome.jsp">Voltar</a>
</body>
</html>
