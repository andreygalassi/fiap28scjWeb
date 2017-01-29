<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lista de Escolas</title>
</head>
<body>
	<h1>Lista de Escolas</h1>	
	<jsp:useBean id="escola" class="br.com.fiap.entity.Escola" />
	<table border="1">
		<tr>
			<td>Descrição</td>
		</tr>
		<c:forEach var="item" items="${escola.listaEscolas}">
			<tr>
				<td>${item.descricao}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>