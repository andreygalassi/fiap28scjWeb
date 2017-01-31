<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notas</title>
</head>
<body>
	<h1>Notas de ${nomeAluno}</h1>
	<table border="1">
		<tr>
			<td>Disciplina</td>
			<td>Projeto 1</td>
			<td>Atividade Prática</td>
			<td>Projeto 2</td>
			<td>Status</td>
			<c:if test="${editar}"><td>Editar</td></c:if>
		</tr>
		<c:forEach var="item" items="${notas}">
			<tr>
				<td>${item.disciplina.descricao}</td>
				<td>${item.projeto1}</td>
				<td>${item.atividadePratica}</td>
				<td>${item.projeto2}</td>
				<td>${item.status}</td>
				<c:if test="${editar}"><td>editar</td></c:if>
			</tr>
		</c:forEach>
	</table></br></br>
		<a href="../menu.jsp">Voltar</a></br></br>
		
</body>
</html>