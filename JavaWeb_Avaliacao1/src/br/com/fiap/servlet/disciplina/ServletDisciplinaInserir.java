package br.com.fiap.servlet.disciplina;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Professor;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/disciplina/inserir")
@MultipartConfig
public class ServletDisciplinaInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDisciplinaInserir() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "";
		try {
			String descricao = request.getParameter("descricao");
			int idProfessor = Integer.parseInt(request.getParameter("professor"));

			String[] idCursos = request.getParameterValues("curso");
			Set<Curso> cursos = new HashSet<>();
			GenericDao<Curso> daoCurso = new GenericDao<Curso>(Curso.class);

			for (String idCurso : idCursos) {
				cursos.add(daoCurso.buscar(Integer.parseInt(idCurso)));
			}
			
			String[] idAlunos = request.getParameterValues("aluno");
			Set<Aluno> alunos = new HashSet<>();
			GenericDao<Aluno> daoAluno = new GenericDao<Aluno>(Aluno.class);

			for (String idAluno : idAlunos) {
				alunos.add(daoAluno.buscar(Integer.parseInt(idAluno)));
			}

			
			Disciplina disciplina = new Disciplina();
			disciplina.setDescricao(descricao);

			disciplina.setCursos(cursos);
			disciplina.setAlunos(alunos);
			
			GenericDao<Professor> daoProfessor = new GenericDao<Professor>(Professor.class);
			Professor professor = daoProfessor.buscar(idProfessor);
			disciplina.setProfessor(professor);
			
			GenericDao<Disciplina> dao = new GenericDao<Disciplina>(Disciplina.class);
			dao.adicionar(disciplina);

			msg = "Disciplina(a) " + disciplina.getDescricao() + " incluído(a)";
		} catch (Exception e) {
			msg = "Erro " + e.getMessage();
		} finally {
			response.sendRedirect("novo?msg=" + msg);
		}
	}
}
