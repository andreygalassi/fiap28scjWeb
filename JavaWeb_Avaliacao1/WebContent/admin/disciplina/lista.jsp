<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lista de Disciplinas</title>
</head>
<body>
	<h1>Lista de Disciplinas</h1>	
	<jsp:useBean id="disciplina" class="br.com.fiap.entity.Disciplina" />
	<table border="1">
		<tr>
			<td>Descrição</td>
			<td>Professor</td>
		</tr>
		<c:forEach var="item" items="${disciplina.listaDisciplinas}">
			<tr>
				<td>${item.descricao}</td>
				<td>${item.professor.nome}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>