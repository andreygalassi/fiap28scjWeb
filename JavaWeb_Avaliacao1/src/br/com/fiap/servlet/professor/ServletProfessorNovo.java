package br.com.fiap.servlet.professor;

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

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/professor/novo")
@MultipartConfig
public class ServletProfessorNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletProfessorNovo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		GenericDao<Escola> dao = new GenericDao<Escola>(Escola.class);
		List<Escola> escolas = dao.listar();
		request.setAttribute("escolas", escolas);
		request.getRequestDispatcher("novo.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
