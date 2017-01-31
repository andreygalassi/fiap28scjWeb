<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Notas</title>
</head>
<body>
	<h1>Cadastro de Notas de ${nomeAluno}</h1>
	<form action="cadastroNotas" method="post" >
		<input type="hidden" name="idAluno" value="${idAluno}" />
		Projeto 1: <input type="number" step="0.01" name="projeto1" size="10" min="0" max="10" required><br/>
		</br>
		Atividade Prática: <input type="number" step="0.01" name="atividadePratica" size="10" min="0" max="10" required><br/>
		</br>
		Projeto 2: <input type="number" step="0.01" name="projeto2" size="10" min="0" max="10" required><br/>
		</br>
		* Disciplina: <select name="disciplina" required>
          <c:forEach var="item" items="${disciplinas}">
            <option value="${item.id}">${item.descricao}</option>
          </c:forEach>
		</br>
		<input type="submit" value="Inserir"/>
		${msg}
	</form>
</body>
</html>