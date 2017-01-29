<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lista de Alunos Por Curso</title>
</head>
<body>
	<h1>Lista de Alunos do Curso ${descricaoCurso}</h1>	
	<table border="1">
		<tr>
			<td>Nome</td>
		</tr>
		<c:forEach var="item" items="${listaAlunos}">
			<tr>
				<td><a href="../aluno/cadastroNotas?id=${item.id}">${item.nome}</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>