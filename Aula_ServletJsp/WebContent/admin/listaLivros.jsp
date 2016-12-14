<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lista de Livros</title>
</head>
<body>
	<h1>Lista de Livros</h1>
	<jsp:useBean id="livro" class="br.com.fiap.bean.LivrosBean"></jsp:useBean>
	<table>
		<tr>
			<td>C�digo</td>
			<td>T�tulo</td>
			<td colspan="2">Op��es</td>
		</tr>
		<c:forEach var="book" items="${livro.listaLivros}">
			<tr>
				<td>${book.codigo }</td>
				<td>${book.titulo }</td>
				<td><a href="consultarLivro?codigo=${book.codigo }">Detalhes</a></td>
				<td><a href="consultarSinopse?codigo=${book.codigo }">Sinopse</a></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>