package br.com.fiap.servlet.curso;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Disciplina;

@WebServlet("/admin/curso/alunosPorCurso")
public class ServletAlunoPorCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAlunoPorCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			GenericDao<Curso> dao = new GenericDao<>(Curso.class);

			Curso curso = dao.buscar(id);
			Set<Aluno> alunos = new HashSet<>();
			for (Disciplina disciplina : curso.getDisciplinas()) {
				alunos.addAll(disciplina.getAlunos());
			}
			request.setAttribute("listaAlunos", alunos);
			request.setAttribute("descricaoCurso", curso.getDescricao());
			request.getRequestDispatcher("listaAlunosPorCurso.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
