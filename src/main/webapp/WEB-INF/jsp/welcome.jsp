<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
<form action="CriarPedidoIntencao" method="post">
    <label for="ira">IRA:</label>
    <input type="number" id="ira" name="ira" step="0.01" required>
    <br>
    <label for="cargaHoraria">Carga Horaria:</label>
    <input type="number" id="cargaHoraria" name="cargaHoraria" required>
    <br>
    <button type="submit">Verificar</button>
</form>
</body>
</html>