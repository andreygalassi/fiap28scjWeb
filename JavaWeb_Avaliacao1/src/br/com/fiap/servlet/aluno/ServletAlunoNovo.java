package br.com.fiap.servlet.aluno;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Curso;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/aluno/novo")
@MultipartConfig
public class ServletAlunoNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String msg = request.getParameter("msg");
		
		GenericDao<Curso> dao = new GenericDao<Curso>(Curso.class);
		List<Curso> cursos = dao.listar();
		request.setAttribute("cursos", cursos);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("novo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
