package br.com.fiap.dao;

import javax.persistence.Query;

import br.com.fiap.entity.Professor;
import br.com.fiap.entity.Usuario;

public class ProfessorDao extends GenericDao<Professor> {
	
	public Professor buscarPorUsuario(Usuario usuario) {

		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select a from Professor a where usuario = :usuario");
		query.setParameter("usuario", usuario);
		return (Professor)query.getSingleResult();
	}

}
