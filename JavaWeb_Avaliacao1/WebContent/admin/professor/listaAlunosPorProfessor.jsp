<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lista de Alunos Por Professor</title>
</head>
<body>
	<h1>Lista de Alunos do Professor ${nomeProfessor}</h1>	
	<table border="1">
		<tr>
			<td>Nome</td>
			<td>Curso</td>
			<td>Disciplina</td>
			<td>Ver Notas</td>
			<td>Cadastro de Notas</td>
		</tr>
		<c:forEach var="item" items="${listaAlunos}">
			<tr>
				<td>${item.nome}</td>
				<td>${item.curso}</td>
				<td>${item.disciplina}</td>
				<td><a href="../aluno/exibirNotas?id=${item.id}&idProfessor=${idProfessor}">Ver Notas</a></td>
				<td><a href="../aluno/cadastroNotas?id=${item.id}">Cadastro de Nota</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>