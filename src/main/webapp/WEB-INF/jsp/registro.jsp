<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Autentique-se </title>
</head>
<body>
	<form action="EfetuarRegistro" method="post">
    <label for="email">E-mail:</label>
    <input type="email" name="email" id="email" required>
    <br>
    <label for="senha">Senha:</label>
    <input type="password" name="senha" id="senha" required>
    <br>
    <input type="submit" value="Registrar">
</form>
	