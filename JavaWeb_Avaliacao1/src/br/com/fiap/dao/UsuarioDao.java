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
	
	public void start(){
		List<Usuario> listar = listar();
		if (listar==null || listar.size()==0){
			Usuario usuario = new Usuario("admin", "admin", TipoUsuario.ADMINISTRATIVO);
			adicionar(usuario);
		}
	}
}
