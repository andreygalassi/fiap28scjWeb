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
import javax.transaction.Transactional;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;

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
			String login = request.getParameter("login");
			String senha = request.getParameter("login");

			if (login==null){
				throw new RuntimeException("Login é obrigatório");
			}
			if (senha==null){
				throw new RuntimeException("Senha é obrigatório");
			}
			
			UsuarioDao usuarioDao = new UsuarioDao();
			if (usuarioDao.existe(login)){
				throw new RuntimeException("Login já esta cadastrado");
			}
			
			Usuario usuario = new Usuario(nome, senha, TipoUsuario.ALUNO);
			
			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			aluno.setUsuario(usuario);
			
			GenericDao<Curso> daoCurso = new GenericDao<Curso>(Curso.class);
			Curso curso = daoCurso.buscar(idCurso);
			aluno.setCurso(curso);
			
			GenericDao<Aluno> dao = new GenericDao<Aluno>(Aluno.class);
			dao.adicionar(aluno);

			request.setAttribute("msg", "Aluno(a) " + aluno.getNome() + " incluÃ­do(a)");
		} catch (Exception e) {
			request.setAttribute("msg", "Erro " + e.getMessage());
		} finally {
			request.getRequestDispatcher("novo.jsp").forward(request, response);
		}
	}
}