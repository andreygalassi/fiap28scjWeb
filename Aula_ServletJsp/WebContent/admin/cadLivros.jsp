<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Livros</title>
</head>
<body>
	<h1>Cadastro de Livros</h1>
	<form action="cadLivros" method="post" enctype="multipart/form-data">
		C�digo:<br /> <input type="text" name="codigo" size="10"><br />
		T�tulo:<br /> <input type="text" name="titulo" size="30"><br />
		Autor:<br /> <input type="text" name="autor" size="30"><br />
		Data Publica��o:<br /> <input type="text" name="data" size="20"><br />
		Pre�o:<br /> <input type="text" name="preco" size="10"><br />
		Foto:<br /> <input type="file" name="foto" id="foto" size="10"><br /> 
		<input type="submit" value="Incluir" /> 
		
		${msg}
	</form>
</body>
</html>