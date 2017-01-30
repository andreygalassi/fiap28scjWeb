package br.com.fiap.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;

public class UsuarioDao extends GenericDao<Usuario> {

	public Usuario buscarUsuario(String nome, String senha) {

		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select u from Usuario u where nome = :nome and senha = :senha");
		query.setParameter("nome", nome);
		query.setParameter("senha", senha);
		return (Usuario) query.getSingleResult();
	}
	
	/**
	 * true para nome de usuário já utilizado
	 * @param nome
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean existe(String nome){
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select u from Usuario u where nome = :nome");
		query.setParameter("nome", nome);
		List<Usuario> resultado = query.getResultList();
		
		return (resultado==null || resultado.size()==0?false:true);
	}
	
	public void start(){
		List<Usuario> listar = listar();
		if (listar==null || listar.size()==0){
			Usuario usuario = new Usuario("admin", "admin", TipoUsuario.ADMINISTRATIVO);
			adicionar(usuario);
		}
	}
}
