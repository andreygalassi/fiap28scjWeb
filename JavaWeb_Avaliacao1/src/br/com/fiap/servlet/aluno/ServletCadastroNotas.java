package br.com.fiap.servlet.aluno;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.dao.NotaDao;
import br.com.fiap.dao.ProfessorDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;

/**
 * Servlet implementation class ServletCadastroLivro
 */
@WebServlet("/admin/aluno/cadastroNotas")
@MultipartConfig
public class ServletCadastroNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getAttribute("session_usuario");
		if (usuario.getTipoUsuario()!=TipoUsuario.PROFESSOR){
			request.setAttribute("msg", "Sem perfil de acesso.");
			request.getRequestDispatcher("mensagemErro.jsp").forward(request, response);
		}
		ProfessorDao professorDao= new ProfessorDao();
		Professor professor = professorDao.buscarPorUsuario(usuario);
		
		AlunoDao dao = new AlunoDao();
		DisciplinaDao disciplinaDao = new DisciplinaDao();

		List<Disciplina> disciplinas = disciplinaDao.buscarPorProfessor(professor.getId());
		request.setAttribute("disciplinas", disciplinas);
		
		Integer idAluno = Integer.parseInt(request.getParameter("id"));
		
		Aluno aluno = dao.buscar(idAluno);
		request.setAttribute("nomeAluno", aluno.getNome());
		request.setAttribute("idAluno", aluno.getId());

		
		
//		if (aluno.getNotas() != null) {
//			request.setAttribute("msg", "Notas de aluno(a) " + aluno.getNome() + " j√° foram cadastradas");
//			request.getRequestDispatcher("mensagemErro.jsp").forward(request, response);
//		} else {
			request.getRequestDispatcher("cadastroNotas.jsp").forward(request, response);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer idAluno = Integer.parseInt(request.getParameter("idAluno"));

			AlunoDao dao = new AlunoDao();
			Aluno aluno = dao.buscar(idAluno);

			float projeto1 = Float.parseFloat(request.getParameter("projeto1"));
			float atividadePratica = Float.parseFloat(request.getParameter("atividadePratica"));
			float projeto2 = Float.parseFloat(request.getParameter("projeto2"));
			String disciplinaStrId = request.getParameter("disciplina");
			int disciplinaId = Integer.parseInt(disciplinaStrId);
			
			DisciplinaDao disciplinaDao = new DisciplinaDao();
			Disciplina disciplina = disciplinaDao.buscar(disciplinaId);

			NotaDao notaDao = new NotaDao();
			if (notaDao.possuiNotaPorDisciplina(aluno, disciplina)){
				request.setAttribute("msg", "Essa aluno j· possui nota para esta disciplina");

				Usuario usuario = (Usuario) request.getAttribute("session_usuario");
				if (usuario.getTipoUsuario()!=TipoUsuario.PROFESSOR){
					request.setAttribute("msg", "Sem perfil de acesso.");
					request.getRequestDispatcher("mensagemErro.jsp").forward(request, response);
				}
				ProfessorDao professorDao= new ProfessorDao();
				Professor professor = professorDao.buscarPorUsuario(usuario);
				
				List<Disciplina> disciplinas = disciplinaDao.buscarPorProfessor(professor.getId());
				request.setAttribute("disciplinas", disciplinas);
				
				aluno = dao.buscar(idAluno);
				request.setAttribute("nomeAluno", aluno.getNome());
				request.setAttribute("idAluno", aluno.getId());
				
				request.getRequestDispatcher("cadastroNotas.jsp").forward(request, response);
			}
			
			
			Nota nota = new Nota();
			nota.setProjeto1(projeto1);
			nota.setAtividadePratica(atividadePratica);
			nota.setProjeto2(projeto2);
			nota.setDisciplina(disciplina);
			nota.setAluno(aluno);
			notaDao.adicionar(nota);
			aluno.addNotas(nota);

			dao.alterar(aluno);

			request.setAttribute("msg", "Notas de aluno(a) " + aluno.getNome() + " cadastradas");
		} catch (Exception e) {
			request.setAttribute("msg", "Erro " + e.getMessage());
		} finally {
			response.sendRedirect("../menu.jsp");
		}
	}

}

