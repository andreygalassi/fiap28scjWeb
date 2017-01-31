package br.com.fiap.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;

@WebFilter("/admin/*")
public class FilterLogin implements Filter {

    public FilterLogin() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();

		String logout = ((HttpServletRequest)request).getParameter("logout");
		if (logout!=null && logout.equals("true")){
			session.removeAttribute("session_usuario");
		}
		
		Usuario usuario = (Usuario) session.getAttribute("session_usuario");
		
		
		if (usuario==null){
			((HttpServletResponse)response).sendRedirect("/JavaWeb_Avaliacao1/login.jsp");
		}else{
			request.setAttribute("session_usuario", session.getAttribute("session_usuario"));
			request.setAttribute("session_usuario_tipo", usuario.getTipoUsuario().name());
			String path = ((HttpServletRequest)request).getServletPath();
//			if (usuario.getTipoUsuario()==TipoUsuario.ALUNO && !path.contains("exibirNotas")){
//				AlunoDao alunoDao = new AlunoDao();
//				Aluno aluno = alunoDao.buscarPorUsuario(usuario);
//				((HttpServletResponse)response).sendRedirect("/JavaWeb_Avaliacao1/admin/aluno/exibirNotas?id=1");
//				chain.doFilter(request, response);	
//				return;
//			}
			if (path.contains("aluno/")){
				if (usuario.getTipoUsuario()==TipoUsuario.ALUNO && path.contains("exibirNotas")){
				}else if (usuario.getTipoUsuario()==TipoUsuario.PROFESSOR && path.contains("exibirNotas")){
				}else if (usuario.getTipoUsuario()==TipoUsuario.PROFESSOR && path.contains("cadastroNotas")){
				}else if (usuario.getTipoUsuario()!=TipoUsuario.ADMINISTRATIVO){
					((HttpServletResponse)response).sendRedirect("/JavaWeb_Avaliacao1/admin/menu.jsp?auth=true");
					return;
				}
			}else if (path.contains("curso/")){
				if (usuario.getTipoUsuario()!=TipoUsuario.ADMINISTRATIVO){
					((HttpServletResponse)response).sendRedirect("/JavaWeb_Avaliacao1/admin/menu.jsp?auth=true");
					return;
				}
			}else if (path.contains("disciplina/")){
				if (usuario.getTipoUsuario()!=TipoUsuario.ADMINISTRATIVO){
					((HttpServletResponse)response).sendRedirect("/JavaWeb_Avaliacao1/admin/menu.jsp?auth=true");
					return;
				}
			}else if (path.contains("escola/")){
				if (usuario.getTipoUsuario()!=TipoUsuario.ADMINISTRATIVO){
					((HttpServletResponse)response).sendRedirect("/JavaWeb_Avaliacao1/admin/menu.jsp?auth=true");
					return;
				}
			}else if (path.contains("professor/")){
				if (usuario.getTipoUsuario()==TipoUsuario.PROFESSOR && path.contains("alunosPorProfessor")){
				}else if (usuario.getTipoUsuario()!=TipoUsuario.ADMINISTRATIVO){
					((HttpServletResponse)response).sendRedirect("/JavaWeb_Avaliacao1/admin/menu.jsp?auth=true");
					return;
				}
			}else if (path.contains("usuario/")){
				if (usuario.getTipoUsuario()!=TipoUsuario.ADMINISTRATIVO){
					((HttpServletResponse)response).sendRedirect("/JavaWeb_Avaliacao1/admin/menu.jsp?auth=true");
					return;
				}
			}else if (path.contains("Notas")){
				if (usuario.getTipoUsuario()==TipoUsuario.ADMINISTRATIVO){
					((HttpServletResponse)response).sendRedirect("/JavaWeb_Avaliacao1/admin/menu.jsp?auth=true");
					return;
				}
			}
			
			chain.doFilter(request, response);			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Iniciando");
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.start();
		System.out.println("Iniciado");
	}

}
