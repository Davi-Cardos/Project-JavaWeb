<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Autentique-se </title>
</head>
<body>
<h1>Registro</h1>
	<form action="EfetuarRegistro" method="post">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required><br>

    <label for="email">E-mail:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha" required><br>

    <label for="confirmarSenha">Confirmar Senha:</label>
    <input type="password" id="confirmarSenha" name="confirmarSenha" required><br>

    <button type="submit">Registrar</button>
	</form>
</body>
</html>