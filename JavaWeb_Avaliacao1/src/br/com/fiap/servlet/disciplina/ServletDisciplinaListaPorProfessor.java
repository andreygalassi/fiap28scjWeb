package br.com.fiap.servlet.disciplina;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Professor;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/disciplina/listaProProfessor")
@MultipartConfig
public class ServletDisciplinaListaPorProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDisciplinaListaPorProfessor() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = request.getParameter("msg");
		
//		DisciplinaDao disciplinaDao disciplinaDao= new DisciplinaDao();
//		request.setAttribute("listaDisciplinas", disciplinaDao.buscarPorProfessor(idProfessor));
//		
//		GenericDao<Aluno> daoAluno = new GenericDao<Aluno>(Aluno.class);
//		List<Aluno> alunos = daoAluno.listar();
//		request.setAttribute("alunos", alunos);
//		request.setAttribute("msg", msg);
//		
//		GenericDao<Professor> daoProfessor = new GenericDao<Professor>(Professor.class);
//		List<Professor> professores = daoProfessor.listar();
//		request.setAttribute("professores", professores);
//		
//		request.getRequestDispatcher("lista.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
