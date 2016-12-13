<!DOCTYPE html>
<%@page import="br.com.fiap.entity.Usuario"%>
<html>
<head>
<title>Menu de Opções</title>
</head>
<body>
	<%
		Usuario usuario = (Usuario) session.getAttribute("session_usuario");

		if (usuario == null) {
			response.sendRedirect("../login.jsp");
		} else {
			out.print("Seja bem-vindo!" + usuario.getNome());
		}
	%>

	<h1>Menu de Opções</h1>

	<ul>
		<li><a href="cadUsuarios.jsp">Cadastro de Usuários</a></li>
		<li><a href="cadLivros.jsp">Cadastro de Livros</a></li>
	</ul>
</body>
</html>