<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Cursos Por Professor</title>
</head>
<body>
	<h1>Lista de Cursos do Professor ${nomeProfessor}</h1>
	<table border="1">
		<tr>
			<td>Nome</td>
		</tr>
		<c:forEach var="item" items="${listaCursos}">
			<tr>
				<td>${item.descricao}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>