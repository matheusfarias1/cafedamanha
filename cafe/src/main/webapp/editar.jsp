<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro</title>
<link rel="icon" href="imagens/cafeIcon.png">
<link rel="stylesheet" href="identificacao.css">
</head>
<body>
	<div class="conteudo">
		<div id="cadastro">
			<form action="update">
				<h1>Editar Cadastro</h1>
				<p>
					<input name="idcon" type="text" id="caixaId" readonly value="<%out.print(request.getAttribute("idcon"));%>"/>
				</p>
				<p>
					<input name="nome" maxlength="30" type="text" required="required" class="caixaCad"
						pattern="[a-z\s]+$+[A-Z]" value="<%out.print(request.getAttribute("nome"));%>"/>
				</p>
				<p>
					<input name="cpf" maxlength="11" minlength="11" required="required" type="text"
						class="caixaCad" pattern="[0-9]+$" value="<%out.print(request.getAttribute("cpf"));%>"/>
				</p>
				<p>
					<input name="alimento" maxlength="20" type="text" class="caixaCad"
						pattern="[a-z\s]+$+[A-Z]" value="<%out.print(request.getAttribute("alimento"));%>"/>
				</p>
				<p>
					<input name="alimento2" maxlength="20" type="text" class="caixaCad"
						pattern="[a-z\s]+$+[A-Z]" value="<%out.print(request.getAttribute("alimento2"));%>"/>
				</p>
				<p class="botaoCad">
					<input type="submit" class="cadastrar" value="Salvar">
					<a href="index.html" class="botaoHome">Página Inicial</a>
					<a href="main" class="botaoHome">Voltar</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>