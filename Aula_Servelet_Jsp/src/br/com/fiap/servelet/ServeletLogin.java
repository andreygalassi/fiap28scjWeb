package br.com.fiap.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServeletLogin
 */
@WebServlet(
		urlPatterns = { "/login" }, 
		initParams = { 
				@WebInitParam(name = "user", value = "admin"), 
				@WebInitParam(name = "pwd", value = "admin")
		})
public class ServeletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public ServeletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recebendo dados do formulario
//		String nome = request.getParameter("nome");
//		String senha = request.getParameter("senha");
//
//		// Lemndo os parametros de inicializacao
//		String user = this.getServletConfig().getInitParameter("user");
//		String pwd = this.getServletConfig().getInitParameter("pwd");
//		
//		if (nome.equals(user) && senha.equals(pwd)) {
//			response.sendRedirect("admin/menu.jsp");
//		} else{
//			response.sendRedirect("login.jsp");
//		}
		
		try {
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");

			GenericDao<Usuario> dao = new GenericDao<>(Usuario.class);
			Usuario usuario = dao.buscarUsuario(nome, senha);

			if (usuario != null) {

				HttpSession session = request.getSession();
				session.setAttribute("session_usuario", usuario);
				response.sendRedirect("admin/menu.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}
	}

}
