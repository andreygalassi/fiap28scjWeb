package br.com.fiap.servlet.escola;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/escola/novo")
@MultipartConfig
public class ServletEscolaNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletEscolaNovo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("novo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		InputStream inputStream = null;
//		try {
//			String descricao = request.getParameter("descricao");
//
//			Escola escola = new Escola();
//			escola.setDescricao(descricao);
//			
//			GenericDao<Escola> dao = new GenericDao<Escola>(Escola.class);
//			dao.adicionar(escola);
//			
//			request.setAttribute("msg", "Escola "+escola.getDescricao()+" incluída");
//			// restante do cï¿½digo
//		} catch (Exception e) {
//			request.setAttribute("msg", "Erro "+e.getMessage());
//		}finally {
//			request.getRequestDispatcher("novo.jsp").forward(request, response);
//		}
	}

}
