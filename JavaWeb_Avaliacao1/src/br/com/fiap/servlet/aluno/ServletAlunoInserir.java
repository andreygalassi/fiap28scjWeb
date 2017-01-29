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
import br.com.fiap.entity.Curso;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/aluno/inserir")
@MultipartConfig
public class ServletAlunoInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAlunoInserir() {
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
			int idCurso = Integer.parseInt(request.getParameter("curso"));

			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			
			GenericDao<Curso> daoCurso = new GenericDao<Curso>(Curso.class);
			Curso curso = daoCurso.buscar(idCurso);
			aluno.setCurso(curso);
			
			GenericDao<Aluno> dao = new GenericDao<Aluno>(Aluno.class);
			dao.adicionar(aluno);

			request.setAttribute("msg", "Aluno(a) " + aluno.getNome() + " incluído(a)");
		} catch (Exception e) {
			request.setAttribute("msg", "Erro " + e.getMessage());
		} finally {
			request.getRequestDispatcher("novo.jsp").forward(request, response);
		}
	}
}