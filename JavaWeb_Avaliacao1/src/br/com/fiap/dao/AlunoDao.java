package br.com.fiap.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Usuario;

public class AlunoDao extends GenericDao<Aluno> {
	
	public List<Aluno> buscarPorProfessor(Integer idCurso) {

		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select a from Aluno a where curso.id = :idCurso");
		query.setParameter("idCurso", idCurso);
		return query.getResultList();
	}
	public Aluno buscarPorUsuario(Usuario usuario) {

		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select a from Aluno a where usuario = :usuario");
		query.setParameter("usuario", usuario);
		return (Aluno)query.getSingleResult();
	}
	public List<Aluno> buscar(int id, Integer idProfessor) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("select a from Aluno a inner join a.disciplinas d where id = :id and d.professor.id = :idProfessor ");
		query.setParameter("id", id);
		query.setParameter("idProfessor", idProfessor);
		
		return query.getResultList();
	}

}
