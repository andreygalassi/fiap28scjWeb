<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Professor</title>
</head>
<body>
	<h1>Cadastro de Professor</h1>
	<form action="inserir" method="post" >
		Nome: <input type="text" name="nome" size="30"><br/>
		</br>
		* Escola: <select name="escola" required>
		  <option value=""></option>
          <c:forEach var="item" items="${escolas}">
            <option value="${item.id}">${item.descricao}</option>
          </c:forEach>
        </select>
		</br></br>
		<input type="submit" value="Incluir"/>
		${msg}
	</form>
</body>
</html>