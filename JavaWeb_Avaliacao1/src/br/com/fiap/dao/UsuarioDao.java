package br.com.fiap.dao;

import javax.persistence.Query;

import br.com.fiap.entity.Usuario;

public class UsuarioDao extends GenericDao<Usuario> {

	public Usuario buscarUsuario(String nome, String senha) {

		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select u from usuario u where nome = :nome and senha = :senha");
		query.setParameter("nome", nome);
		query.setParameter("senha", senha);
		return (Usuario) query.getSingleResult();
	}
	
}
