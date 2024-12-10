<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="EfetuarLogin" method="post">
        <label for="email">E-mail:</label>
        <input type="text" id="email" name="email" required><br><br>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required><br><br>
        <input type="submit" value="Entrar">
    </form>
    <% 
        String mensagemErro = (String) request.getAttribute("mensagemErro");
        if (mensagemErro != null) {
    %>
        <p style="color: red;"><%= mensagemErro %></p>
    <% 
        } 
    %>
</body>
</html>
