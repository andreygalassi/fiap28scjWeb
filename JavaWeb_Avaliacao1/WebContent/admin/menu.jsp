<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MENU</title>
</head>
<body>

<c:if test="${param.auth}">Sem Altorização</c:if>
		
	<h1>Menu de Opções</h1>

	<ul>
		<c:if test="${session_usuario_tipo=='ADMINISTRATIVO'}">
			<li><a href="aluno/novo">Novo Aluno</a></li>
			<li><a href="aluno/lista.jsp">Lista de alunos</a></li>
			<li><a href="curso/novo">Novo Curso</a></li>
			<li><a href="curso/lista.jsp">Lista de cursos</a></li>
			<li><a href="disciplina/novo">Nova Disciplina</a></li>
			<li><a href="disciplina/lista.jsp">Lista de disciplinas</a></li>
			<li><a href="escola/novo">Nova Escola</a></li>
			<li><a href="escola/lista.jsp">Lista de escolas</a></li>
			<li><a href="professor/novo">Novo Professor</a></li>
			<li><a href="professor/lista.jsp">Lista de professores</a></li>
		</c:if>
		<c:if test="${session_usuario_tipo=='ALUNO'}">
			<li><a href="aluno/exibirNotas">Exibir suas notas</a></li>
		</c:if>
		<c:if test="${session_usuario_tipo=='PROFESSOR'}">
			<li><a href="professor/alunosPorProfessor">Veja seus alunos</a></li>
		</c:if>
	</ul>

<a href="login.jsp?logout=true">Logout</a>
</body>
</html>