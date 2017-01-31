package br.com.fiap.servlet.escola;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Escola;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/escola/inserir")
@MultipartConfig
public class ServletEscolaInserir extends HttpServlet {
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

			Escola escola = new Escola();
			escola.setDescricao(descricao);
			
			GenericDao<Escola> dao = new GenericDao<Escola>(Escola.class);
			dao.adicionar(escola);
			
			request.setAttribute("msg", "Escola "+escola.getDescricao()+" incluída");
			msg = "Aluno(a) " + escola.getDescricao() + " incluído(a)";
		} catch (Exception e) {
			msg = "Erro " + e.getMessage();
		} finally {
			response.sendRedirect("novo?msg=" + msg);
		}
	}

}
