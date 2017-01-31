package br.com.fiap.servlet.professor;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.DisciplinaDao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.ProfessorDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.AlunoVO;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.Usuario;

@WebServlet("/admin/professor/alunosPorProfessor")
public class ServletAlunoPorProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ServletAlunoPorProfessor() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProfessorDao dao = new ProfessorDao();

			String paramId = request.getParameter("id");
			if (paramId==null){
				Usuario usuario = (Usuario) request.getAttribute("session_usuario");
				
				Professor buscarPorUsuario = dao.buscarPorUsuario(usuario);
				paramId = buscarPorUsuario.getId().toString();
			}
			
			int id = Integer.parseInt(paramId);
			
//			int id = Integer.parseInt(request.getParameter("id"));

			Professor professor = dao.buscar(id);
			Set<AlunoVO> alunos = new HashSet<>();
			List<Disciplina> disciplinas = new DisciplinaDao().buscarPorProfessor(id);
			for (Disciplina disciplina : disciplinas) {
				for (Aluno aluno : disciplina.getAlunos()) {
					alunos.add(new AlunoVO(aluno.getId(), 
									aluno.getNome(), 
									disciplina.getDescricao(), 
									aluno.getCurso().getDescricao(), 
									aluno.getNotas(), 
									aluno.getUsuario()));
				}
//				alunos.addAll(disciplina.getAlunos());
			}
			request.setAttribute("listaAlunos", alunos);
			request.setAttribute("idProfessor", id);
			request.setAttribute("nomeProfessor", professor.getNome());
			request.getRequestDispatcher("listaAlunosPorProfessor.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
}
