package br.com.fiap.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.entity.Disciplina;

public class DisciplinaDao extends GenericDao<Disciplina> {
	
	public List<Disciplina> buscarPorProfessor(Integer idProfessor) {

		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select d from Disciplina d where professor.id = :idProfessor");
		query.setParameter("idProfessor", idProfessor);
		return query.getResultList();
	}

}
