<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de livros</title>
</head>
<body>
	<h1>Cadastro de livros</h1>
	<form action="cadLivros" method="post" enctype="multipart/form-data">
		Código:<br/>
		<input type="text" name="codigo" size="10"><br/>
		Título:<br/>
		<input type="text" name="titulo" size="30"><br/>
		Autor:<br/>
		<input type="text" name="autor" size="30"><br/>
		Data Publicação:<br/>
		<input type="text" name="data" size="20"><br/>
		Preço:<br/>
		<input type="text" name="preco" size="10"><br/>
		Foto:<br/>
		<input type="file" name="foto" size="10"><br/>
		
		<input type="submit" value="Incluir"/>
		${msg};
	</form>
</body>
</html>