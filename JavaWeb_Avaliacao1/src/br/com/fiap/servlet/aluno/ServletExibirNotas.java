package br.com.fiap.servlet.aluno;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.NotaDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Usuario;

@WebServlet("/admin/aluno/exibirNotas")
public class ServletExibirNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AlunoDao dao = new AlunoDao();
			NotaDao notaDao = new NotaDao();
			
			String paramId = request.getParameter("id");
			String paramIdProfessor = request.getParameter("idProfessor");
			if (paramId==null){
				Usuario usuario = (Usuario) request.getAttribute("session_usuario");
				Aluno buscarPorUsuario = dao.buscarPorUsuario(usuario);
				paramId = buscarPorUsuario.getId().toString();
			}
			Integer idProfessor=null;
			if (paramIdProfessor!=null){
				idProfessor = Integer.parseInt(paramIdProfessor);
			}
			
			int id = Integer.parseInt(paramId);
			
			Aluno aluno = dao.buscar(id);;
			Set<Nota> notas = aluno.getNotas();
			request.setAttribute("nomeAluno", aluno.getNome());
			
			if (notas == null) {
				request.setAttribute("msg", "Notas de aluno(a) " + aluno.getNome() + " ainda não foram cadastradas");
				request.getRequestDispatcher("mensagemErro.jsp").forward(request, response);
			} else {
				if (idProfessor!=null){
					List<Nota> n2 = notaDao.buscar(aluno, idProfessor);
					request.setAttribute("notas", n2);
					request.setAttribute("editar", true);
				}else{
					request.setAttribute("notas", notas);
				}
				
				request.getRequestDispatcher("exibirNotas.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
