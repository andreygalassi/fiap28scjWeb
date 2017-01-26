<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Escola</title>
</head>
<body>
	<h1>Cadastro de Escola</h1>
	<form action="inserir" method="post" >
		Id:<br/>
		<input type="text" name="id" size="10"><br/>
		Descrição:<br/>
		<input type="text" name="descricao" size="30"><br/>
		
		<input type="submit" value="Incluir"/>
		${msg}
	</form>
</body>
</html>