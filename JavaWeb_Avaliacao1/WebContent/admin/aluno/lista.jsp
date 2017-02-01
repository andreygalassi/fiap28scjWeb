<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lista de Alunos</title>
</head>
<body>
	<h1>Lista de Alunos</h1>	
	<jsp:useBean id="aluno" class="br.com.fiap.entity.Aluno" />
	<table border="1">
		<tr>
			<td>Nome</td>
			<td>Curso</td>
			<td>Notas</td>
		</tr>
		<c:forEach var="item" items="${aluno.listaAlunos}">
			<tr>
				<td>${item.nome}</td>
				<td>${item.curso.descricao}</td>
				<td><a href="exibirNotas?id=${item.id}">Ver Notas</a></td>
			</tr>
		</c:forEach>
	</table></br></br>
		<a href="../menu.jsp">Voltar</a>
	
</body>
</html>