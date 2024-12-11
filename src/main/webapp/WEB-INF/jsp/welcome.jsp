<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bem-vindo</title>
</head>
<body>
    <h1>Bem-vindo!</h1>
    <p>Escolha uma opcao:</p>
    <form action="CriarPedidoIntencao" method="post">
    <label for="id"> ID: </label>
    <input type="number" id = "id" name="id" step="0.01" required>
    <label for="ira">IRA:</label>
    <input type="number" id="ira" name="ira" step="0.01" required>
    <br>
    <label for="cargaHoraria">Carga Horaria:</label>
    <label for="cargaHoraria">Carga Horaria :</label>
    <input type="number" id="cargaHoraria" name="cargaHoraria" required>
    <br>
    <button type="submit">Verificar</button>
</html>
