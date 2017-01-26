package br.com.fiap.servlet.curso;

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
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;
import br.com.fiap.entity.Professor;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/curso/inserir")
@MultipartConfig
public class ServletCursoInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCursoInserir() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		InputStream inputStream = null;
		try {
			String descricao = request.getParameter("descricao");
			int idEscola = Integer.parseInt(request.getParameter("escola"));

			Curso curso = new Curso();
			curso.setDescricao(descricao);
			
			GenericDao<Escola> daoEscola = new GenericDao<Escola>(Escola.class);
			Escola escola = daoEscola.buscar(idEscola);
			curso.setEscola(escola);
			
			GenericDao<Curso> dao = new GenericDao<Curso>(Curso.class);
			dao.adicionar(curso);

			request.setAttribute("msg", "Curso(a) " + curso.getDescricao() + " incluído(a)");
		} catch (Exception e) {
			request.setAttribute("msg", "Erro " + e.getMessage());
		} finally {
			request.getRequestDispatcher("novo.jsp").forward(request, response);
		}
	}

}
