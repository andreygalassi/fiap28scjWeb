package br.com.fiap.servlet.professor;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entity.Escola;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/professor/inserir")
@MultipartConfig
public class ServletProfessorInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "";
		try {
			String nome = request.getParameter("nome");
			String[] idEscolas = request.getParameterValues("escola");
			Set<Escola> escolas = new HashSet<>();
			String login = request.getParameter("login");
			String senha = request.getParameter("login");

			if (login==null){
				throw new RuntimeException("Login � obrigat�rio");
			}
			if (senha==null){
				throw new RuntimeException("Senha � obrigat�rio");
			}
			
			UsuarioDao usuarioDao = new UsuarioDao();
			if (usuarioDao.existe(login)){
				throw new RuntimeException("Login j� esta cadastrado");
			}
			
			Usuario usuario = new Usuario(nome, senha, TipoUsuario.PROFESSOR);
			
			GenericDao<Escola> daoEscola = new GenericDao<Escola>(Escola.class);
			
			for(String idEscola : idEscolas)
			{
				escolas.add(daoEscola.buscar(Integer.parseInt(idEscola)));
			}

			Professor professor = new Professor();
			professor.setNome(nome);
			
			professor.setEscolas(escolas);
			professor.setUsuario(usuario);
			
			GenericDao<Professor> dao = new GenericDao<Professor>(Professor.class);
			dao.adicionar(professor);

			msg = "Professor(a) " + professor.getNome() + " incluído(a)";
		} catch (Exception e) {
			msg = "Erro " + e.getMessage();
		} finally {
			response.sendRedirect("novo?msg=" + msg);
		}
	}

}
