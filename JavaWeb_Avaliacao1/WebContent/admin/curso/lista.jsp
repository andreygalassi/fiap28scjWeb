<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lista de Cursos</title>
</head>
<body>
	<h1>Lista de Cursos</h1>	
	<jsp:useBean id="curso" class="br.com.fiap.entity.Curso" />
	<table border="1">
		<tr>
			<td>Descrição</td>
			<td>Professor</td>
			<td>Escola</td>
		</tr>
		<c:forEach var="item" items="${curso.listaCursos}">
			<tr>
				<td><a href="alunosPorCurso?id=${item.id}">${item.descricao}</a></td>
				<td><a href="alunosPorCurso?id=${item.id}">${item.professor.nome}</a></td>
				<td><a href="alunosPorCurso?id=${item.id}">${item.escola.descricao}</a></td>
			</tr>
		</c:forEach>
	</table></br></br>
		<a href="../menu.jsp">Voltar</a></br></br>
</body>
</html>