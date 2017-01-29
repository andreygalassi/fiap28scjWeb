package br.com.fiap.servlet.aluno;

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
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Nota;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/aluno/cadastroNotas")
@MultipartConfig
public class ServletCadastroNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastroNotas() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		Integer idAluno = Integer.parseInt(request.getParameter("id"));

		GenericDao<Aluno> dao = new GenericDao<Aluno>(Aluno.class);
		Aluno aluno = dao.buscar(idAluno);
		request.setAttribute("nomeAluno", aluno.getNome());
		request.setAttribute("idAluno", aluno.getId());
		if (aluno.getNota() != null) {
			request.setAttribute("msg", "Notas de aluno(a) " + aluno.getNome() + " já foram cadastradas");
			request.getRequestDispatcher("mensagemErro.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("cadastroNotas.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		InputStream inputStream = null;
		try {
			Integer idAluno = Integer.parseInt(request.getParameter("idAluno"));

			GenericDao<Aluno> dao = new GenericDao<Aluno>(Aluno.class);
			Aluno aluno = dao.buscar(idAluno);

			float projeto1 = Float.parseFloat(request.getParameter("projeto1"));
			float atividadePratica = Float.parseFloat(request.getParameter("atividadePratica"));
			float projeto2 = Float.parseFloat(request.getParameter("projeto2"));

			Nota nota = new Nota();
			nota.setProjeto1(projeto1);
			nota.setAtividadePratica(atividadePratica);
			nota.setProjeto2(projeto2);
			aluno.setNota(nota);

			dao.alterar(aluno);

			request.setAttribute("msg", "Notas de aluno(a) " + aluno.getNome() + " cadastradas");
		} catch (Exception e) {
			request.setAttribute("msg", "Erro " + e.getMessage());
		} finally {
			request.getRequestDispatcher("/admin/menu.jsp").forward(request, response);
		}
	}

}
