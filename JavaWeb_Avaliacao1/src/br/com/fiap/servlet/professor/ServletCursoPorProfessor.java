package br.com.fiap.servlet.professor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Professor;

@WebServlet("/admin/professor/cursosPorProfessor")
public class ServletCursoPorProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ServletCursoPorProfessor() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			GenericDao<Professor> dao = new GenericDao<>(Professor.class);

			Professor professor = dao.buscar(id);
			List<Curso> cursos = new CursoDao().buscarPorProfessor(id);
			request.setAttribute("listaCursos", cursos);
			request.setAttribute("nomeProfessor", professor.getNome());
			request.getRequestDispatcher("listaCursosPorProfessor.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
}
