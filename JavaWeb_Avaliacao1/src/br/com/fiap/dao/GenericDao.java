package br.com.fiap.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;

public class GenericDao<T> implements Dao<T> {

	private Class<T> classe;
	protected EntityManager em;

	public GenericDao() {
		this.classe = getClasse();
	}
	
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}
	
	@SuppressWarnings("unchecked")
	protected Class<T> getClasse() {
		if (this.classe == null) {
			Type type = this.getClass();
			ParameterizedType paramType;
			try {
				paramType = (ParameterizedType) type;
			} catch (ClassCastException cause) {
				paramType = (ParameterizedType) ((Class<T>) type).getGenericSuperclass();
			}
			this.classe = (Class<T>) paramType.getActualTypeArguments()[0];
		}

		return this.classe;
	}

	@Override
	public void adicionar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void alterar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}

	@Override
	public T buscar(int id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		em.close();

		return entidade;
	}

}
