package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

@WebServlet("/admin/consultarLivro")
public class ServletConsultarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConsultarLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("codigo"));
			GenericDao<Livro> dao = new GenericDao<>(Livro.class);
			
			Livro livro = dao.buscar(id);
			request.setAttribute("livro", livro);
			request.getRequestDispatcher("mostraLivro.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
