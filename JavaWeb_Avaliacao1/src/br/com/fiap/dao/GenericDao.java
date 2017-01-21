package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Usuario;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDao<T> implements Dao<T> {

	private Class<T> classe;
	protected EntityManager em;

	public GenericDao() {
		this.classe = getClasse();
	}
	
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}
	
//	protected T getDelegate() {
//		if (this.classe == null) {
//			this.classe = Beans.getReference(getDelegateClass());
//		}
//
//		return this.delegate;
//	}

	protected Class<T> getClasse() {
		if (this.classe == null) {
			Type type = this.getClass();
			ParameterizedType paramType;
			try {
				paramType = (ParameterizedType) type;
			} catch (ClassCastException cause) {
				paramType = (ParameterizedType) ((Class<T>) type).getGenericSuperclass();
			}
//			this.classe = Reflections.getGenericTypeArgument(this.getClass(), 2);
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
	
	public static void main(String[] args) {
		GenericDao<Usuario> uDao = new GenericDao<>(Usuario.class);
		
		Type type = uDao.getClasse();

		ParameterizedType paramType;
		try {
			paramType = (ParameterizedType) type;
		} catch (ClassCastException cause) {
			paramType = (ParameterizedType) ((Class<Usuario>) type).getGenericSuperclass();
		}

		System.out.println(paramType.getActualTypeArguments()[0]);
		System.out.println(paramType.getActualTypeArguments()[1]);
		System.out.println(paramType.getActualTypeArguments()[2]);
		System.out.println(paramType.getActualTypeArguments()[3]);
	}

}
