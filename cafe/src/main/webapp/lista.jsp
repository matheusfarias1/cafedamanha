<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("cadastro");
for (int i = 0; i < lista.size(); i++) {
}
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista de colaboradores</title>
<link rel="icon" href="imagens/cafeIcon.png">
<link rel="stylesheet" href="identificacao.css">
</head>
<body>
	<h1>Lista de Colaboradores</h1>
	<p class="home">
		<a href="index.html" class="botaoHome">Página Inicial</a>
	</p>
	<table id="tbLista">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Primeiro Alimento</th>
				<th>Segundo Alimento</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td><%=lista.get(i).getAlimento()%></td>
				<td><%=lista.get(i).getAlimento2()%></td>
				<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>"
					class="botaoEditar">Editar</a> <a
					href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)"
					class="botaoExcluir">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>