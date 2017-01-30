<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lista de Professores</title>
</head>
<body>
	<h1>Lista de Professores</h1>	
	<jsp:useBean id="professor" class="br.com.fiap.entity.Professor" />
	<table border="1">
		<tr>
			<td>Nome</td>
		</tr>
		<c:forEach var="item" items="${professor.listaProfessores}">
			<tr>
				<td>${item.nome}</td>
			</tr>
		</c:forEach>
	</table>
		<a href="../menu.jsp">Voltar</a>
</body>
</html>