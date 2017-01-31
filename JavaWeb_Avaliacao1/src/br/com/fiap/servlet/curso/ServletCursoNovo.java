package br.com.fiap.servlet.curso;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Escola;
import br.com.fiap.entity.Professor;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/curso/novo")
@MultipartConfig
public class ServletCursoNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String msg = request.getParameter("msg");
		
		GenericDao<Escola> dao = new GenericDao<Escola>(Escola.class);
		List<Escola> escolas = dao.listar();
		request.setAttribute("escolas", escolas);
		
		GenericDao<Professor> daoProfessor = new GenericDao<Professor>(Professor.class);
		List<Professor> professores = daoProfessor.listar();
		request.setAttribute("professores", professores);
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher("novo.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

