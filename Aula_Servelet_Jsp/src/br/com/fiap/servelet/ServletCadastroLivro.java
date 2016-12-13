package br.com.fiap.servelet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/cadLivros")
@MultipartConfig
public class ServletCadastroLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastroLivro() {
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
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");
			String data = request.getParameter("data");
			Date datapub = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			double preco = Double.parseDouble(request.getParameter("preco"));
			Part filePart = request.getPart("foto");
			byte[] imagem = new byte[(int) filePart.getSize()];
			if (filePart != null) {
				inputStream = filePart.getInputStream();
				inputStream.read(imagem, 0, (int) filePart.getSize());
			}
			Livro livro = new Livro();
			livro.setCodigo(codigo);
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setDataPublicacao(datapub);
			livro.setPreco(preco);
			livro.setImagem(imagem);
			GenericDao<Livro> dao = new GenericDao<Livro>(Livro.class);
			dao.adicionar(livro);
			
			request.setAttribute("msg", "Livro "+livro.getCodigo()+" inclu�do");
			// restante do c�digo
		} catch (Exception e) {
			request.setAttribute("msg", "Erro "+e.getMessage());
		}finally {
			request.getRequestDispatcher("cadLivros.jsp").forward(request, response);
		}
	}

}