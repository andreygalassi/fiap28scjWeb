<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Aluno</title>
</head>
<body>
	<h1>Cadastro de Aluno</h1>
	<form action="inserir" method="post" >
		* Nome: <input type="text" name="nome" size="30" required>
		<br><br>
		* Login: <input type="text" name="login" size="30" required>
		<br><br>
		* Senha: <input type="password" name="senha" size="30" required>
		<br><br>
		* Curso: <select name="curso" required>
		  <option value=""></option>
          <c:forEach var="item" items="${cursos}">
            <option value="${item.id}">${item.descricao}</option>
          </c:forEach>
        </select>
		<br><br>
		<input type="submit" value="Incluir"/><br><br>
		<a href="../menu.jsp">Voltar</a><br><br>
		${msg}
	</form>
</body>
</html>