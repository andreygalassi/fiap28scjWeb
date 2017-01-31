package br.com.fiap.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.entity.Curso;

public class CursoDao extends GenericDao<Curso> {
	
	public List<Curso> buscarPorProfessor(Integer idProfessor) {

		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select c from Curso c where professor.id = :idProfessor");
		query.setParameter("idProfessor", idProfessor);
		return query.getResultList();
	}

}
