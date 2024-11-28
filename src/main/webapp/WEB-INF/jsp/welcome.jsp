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
    <label for="nomeEmp">Nome da Empresa:</label>
    <input type="text" id="nomeEmp" name="nomeEmp" required>
    <br>
    <label for="enderecoEmp">Endereco da Empresa:</label>
    <input type="text" id="enderecoEmp" name="enderecoEmp" required>
    <br>
    <label for="modalidadeEst">Modalidade do Estagio:</label>
    <input type="text" id="modalidadeEst" name="modalidadeEst" required>
    <br>
    <label for="maxCargaHoraria">Carga Horaria Maxima:</label>
    <input type="number" id="maxCargaHoraria" name="maxCargaHoraria" required>
    <br>
    <label for="valorBolsa">Valor da Bolsa:</label>
    <input type="number" id="valorBolsa" name="valorBolsa" step="0.01" required>
    <br>
    <label for="resumo">Resumo:</label>
    <textarea id="resumo" name="resumo" required></textarea>
    <br>
    <label for="conteudos">Conteudos:</label>
    <textarea id="conteudos" name="conteudos" required></textarea>
    <br>
    <label for="motivoEst">Motivo do Estagio:</label>
    <textarea id="motivoEst" name="motivoEst" required></textarea>
    <br>
    <button type="submit">Enviar Pedido</button>
</form>
</body>
</html>