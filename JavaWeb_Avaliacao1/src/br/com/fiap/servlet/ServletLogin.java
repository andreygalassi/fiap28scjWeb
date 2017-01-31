package br.com.fiap.servlet;

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
		urlPatterns = { "/login" }, 
		initParams = { 
				@WebInitParam(name = "nome", value = "admin"), 
				@WebInitParam(name = "senha", value = "admin")
		})
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");

			UsuarioDao dao = new UsuarioDao();
			Usuario usuario = dao.buscarUsuario(nome, senha);

			if (usuario != null) {

				HttpSession session = request.getSession();
				session.setAttribute("session_usuario", usuario);
				session.setAttribute("session_tipo", usuario.getTipoUsuario().name());
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
