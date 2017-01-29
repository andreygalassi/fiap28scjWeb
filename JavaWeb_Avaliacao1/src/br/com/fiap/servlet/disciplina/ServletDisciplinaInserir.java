package br.com.fiap.servlet.disciplina;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		InputStream inputStream = null;
		try {
			String descricao = request.getParameter("descricao");

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
			
			GenericDao<Disciplina> dao = new GenericDao<Disciplina>(Disciplina.class);
			dao.adicionar(disciplina);

			request.setAttribute("msg", "Disciplina " + disciplina.getDescricao() + " incluída");
		} catch (Exception e) {
			request.setAttribute("msg", "Erro " + e.getMessage());
		} finally {
			request.getRequestDispatcher("novo.jsp").forward(request, response);
		}
	}
}
