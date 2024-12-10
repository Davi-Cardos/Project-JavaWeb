<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Intencao de Estagio</title>
</head>
<body>
    <h1>Registrar Intencao de Estagio</h1>
    <form action="RegistrarIntencaoEstagio" method="post">
        <label for="idAluno">ID do Aluno:</label>
        <input type="number" id="idAluno" name="idAluno" required><br><br>
        
        <label for="primeiroEstagio">É o primeiro estágio?</label>
        <input type="checkbox" id="primeiroEstagio" name="primeiroEstagio" value="true"><br><br>
        
        <label for="nomeEmpresa">Nome da Empresa:</label>
        <input type="text" id="nomeEmpresa" name="nomeEmpresa" required><br><br>
        
        <label for="enderecoEmpresa">Endereço da Empresa:</label>
        <input type="text" id="enderecoEmpresa" name="enderecoEmpresa" required><br><br>
        
        <label for="modalidadeEstagio">Modalidade:</label>
        <input type="text" id="modalidadeEstagio" name="modalidadeEstagio" required><br><br>
        
        <label for="maxCargaHoraria">Carga Horária:</label>
        <input type="number" id="maxCargaHoraria" name="maxCargaHoraria" required><br><br>
        
        <label for="valorBolsa">Valor da Bolsa:</label>
        <input type="number" step="0.01" id="valorBolsa" name="valorBolsa" required><br><br>
        
        <label for="resumo">Resumo:</label>
        <textarea id="resumo" name="resumo" required></textarea><br><br>
        
        <label for="conteudos">Conteúdos:</label>
        <textarea id="conteudos" name="conteudos" required></textarea><br><br>
        
        <label for="motivoEstagio">Motivo:</label>
        <textarea id="motivoEstagio" name="motivoEstagio" required></textarea><br><br>
        
        <input type="submit" value="Enviar">
    </form>
    <% 
        String mensagemErro = (String) request.getAttribute("mensagemErro");
        String mensagemSucesso = (String) request.getAttribute("mensagemSucesso");
        if (mensagemErro != null) {
    %>
        <p style="color: red;"><%= mensagemErro %></p>
    <% 
        } else if (mensagemSucesso != null) {
    %>
        <p style="color: green;"><%= mensagemSucesso %></p>
    <% 
        } 
    %>
</body>
</html>
