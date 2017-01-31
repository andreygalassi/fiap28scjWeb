package br.com.fiap.servlet.curso;

import java.io.IOException;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "";
		try {
			String descricao = request.getParameter("descricao");
			int idEscola = Integer.parseInt(request.getParameter("escola"));
			int idProfessor = Integer.parseInt(request.getParameter("professor"));

			Curso curso = new Curso();
			curso.setDescricao(descricao);
			
			GenericDao<Escola> daoEscola = new GenericDao<Escola>(Escola.class);
			Escola escola = daoEscola.buscar(idEscola);
			curso.setEscola(escola);
			
			GenericDao<Professor> daoProfessor = new GenericDao<Professor>(Professor.class);
			Professor professor = daoProfessor.buscar(idProfessor);
			curso.setProfessor(professor);
			
			GenericDao<Curso> dao = new GenericDao<Curso>(Curso.class);
			dao.adicionar(curso);

			msg = "Curso(a) " + curso.getDescricao() + " incluído(a)";
		} catch (Exception e) {
			msg = "Erro " + e.getMessage();
		} finally {
			response.sendRedirect("novo?msg=" + msg);
		}
	}

}
