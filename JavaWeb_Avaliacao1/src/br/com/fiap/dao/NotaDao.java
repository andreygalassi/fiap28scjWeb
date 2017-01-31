package br.com.fiap.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Disciplina;
import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.Usuario;

public class NotaDao extends GenericDao<Nota> {

	public Boolean possuiNotaPorDisciplina(Aluno aluno, Disciplina disciplina) {

		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select a from Nota a where aluno = :aluno and disciplina=:disciplina ");
		query.setParameter("aluno", aluno);
		query.setParameter("disciplina", disciplina);
		List<?> resultList = query.getResultList();
		
		return (resultList!=null && resultList.size()>0?true:false);
	}

	public List<Nota> buscar(Aluno aluno, Integer idProfessor) {

		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select a from Nota a where aluno = :aluno and disciplina.professor.id=:idProfessor ");
		query.setParameter("aluno", aluno);
		query.setParameter("idProfessor", idProfessor);
		
		return query.getResultList();
	}

}
