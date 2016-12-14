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
			<td>Código</td>
			<td>Título</td>
			<td colspan="2">Opções</td>
		</tr>
		<c:forEach var="book" items="${livro.listaLivros}">
			
		</c:forEach>
	</table>	
</body>
</html>