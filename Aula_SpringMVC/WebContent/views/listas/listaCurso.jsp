<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Cursos</title>
</head>
<body>
	<form method="post" action=<c:url value="/curso/listar"/> >
		<h3>Selecione a escola:</h3>
		<select name="idc">
			<c:forEach var="e" items="${escolas}">
				<option value="${e.id}">${e.descricao}</option>
			</c:forEach>
		</select> 
		<input type="submit" value="Listar Curso">
	<table>
			<c:forEach var="e" items="${cursos}">
		<tr>
				<td>${e.descricao}</td>
		</tr>
			</c:forEach>
	</table>
	</form>
	
</body>
</html>