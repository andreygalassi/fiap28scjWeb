package br.com.fiap.servlet.disciplina;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/disciplina/novo")
@MultipartConfig
public class ServletDisciplinaNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDisciplinaNovo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		GenericDao<Curso> dao = new GenericDao<Curso>(Curso.class);
		List<Curso> cursos = dao.listar();
		request.setAttribute("cursos", cursos);
		
		GenericDao<Aluno> daoAluno = new GenericDao<Aluno>(Aluno.class);
		List<Aluno> alunos = daoAluno.listar();
		request.setAttribute("alunos", alunos);
		
		request.getRequestDispatcher("novo.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
