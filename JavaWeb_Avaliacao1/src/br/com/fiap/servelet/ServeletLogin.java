package br.com.fiap.servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServeletLogin
 */
@WebServlet(
		urlPatterns = { "/" }, 
		initParams = { 
				@WebInitParam(name = "nome", value = "admin"), 
				@WebInitParam(name = "senha", value = "admin")
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

			UsuarioDao dao = new UsuarioDao();
			Usuario usuario = dao.buscarUsuario(nome, senha);

			if (usuario != null) {

				HttpSession session = request.getSession();
				session.setAttribute("session_usuario", usuario);
				response.sendRedirect("admin/menu.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.jsp");
		}
	}

}
