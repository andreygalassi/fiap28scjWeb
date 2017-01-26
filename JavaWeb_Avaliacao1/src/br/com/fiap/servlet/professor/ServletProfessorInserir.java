package br.com.fiap.servlet.professor;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

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
@WebServlet("/admin/professor/inserir")
@MultipartConfig
public class ServletProfessorInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletProfessorInserir() {
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
			String nome = request.getParameter("nome");
			int idEscola = Integer.parseInt(request.getParameter("escola"));

			Professor professor = new Professor();
			professor.setNome(nome);
			
			GenericDao<Escola> daoEscola = new GenericDao<Escola>(Escola.class);
			Escola escola = daoEscola.buscar(idEscola);
			professor.setEscola(escola);
			
			GenericDao<Professor> dao = new GenericDao<Professor>(Professor.class);
			dao.adicionar(professor);

			request.setAttribute("msg", "Professor(a) " + professor.getNome() + " incluído(a)");
		} catch (Exception e) {
			request.setAttribute("msg", "Erro " + e.getMessage());
		} finally {
			request.getRequestDispatcher("novo.jsp").forward(request, response);
		}
	}

}
