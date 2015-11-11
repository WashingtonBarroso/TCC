package br.edu.ifg.ifeventos.model.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.beanutils.PropertyUtils;

import br.edu.ifg.ifeventos.model.dao.IDAO;

@Stateless
public class DAO<T, PK> implements IDAO<T, PK> {


	@Inject
	private EntityManager entityManager;

	/*
	 * PRIVATE METHODS
	 */

	private void mergeLikePersist(T entity) {
		try {
			PropertyUtils.copyProperties(entity, entityManager.merge(entity));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz;
	}

	private Query fillParams(String hql, Object... param) {
		Query query = entityManager.createQuery(hql);
		for (int i = 0; i < param.length; i = i + 2)
			query.setParameter((String) param[i], param[i + 1]);
		return query;
	}

	/*
	 * PROTECTED METHODS
	 */

	@SuppressWarnings("unchecked")
	protected List<T> list(String hql, Object... params) {
		return fillParams(hql, params).getResultList();
	}

	protected List<?> genericList(String hql, Object... params) {
		return fillParams(hql, params).getResultList();
	}	

	protected int executeUpdate(String hql, Object... params){
		begin();
		return fillParams(hql, params).executeUpdate();
	}	

	protected int executeSQL(String sql){
		begin();
		return entityManager.createNativeQuery(sql).executeUpdate();
	}


	/*
	 * PUBLIC METHODS
	 */

	public void begin() {
		if (!entityManager.getTransaction().isActive()) 
			entityManager.getTransaction().begin();
	}

	public void commit() {
		if (entityManager != null && entityManager.getTransaction().isActive())
			entityManager.getTransaction().commit();
	}

	public void rollback() {
		if (entityManager != null && entityManager.getTransaction().isActive())
			entityManager.getTransaction().rollback();
	}

	public void close() {
		if (entityManager != null && entityManager.isOpen())
			entityManager.close();
	}

	public boolean isActive() {
		return entityManager.getTransaction().isActive();
	}

	public boolean isOpen() {
		if (entityManager != null)
			return entityManager.isOpen();
		else
			return false;
	}

	@Override
	public void save(T entity) {
		begin();
	    Object id = entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
		if (id != null)
			mergeLikePersist(entity);
		else
			entityManager.persist(entity);
		entityManager.flush();
	}

	@Override
	public void remove(T t) {
		begin();
		entityManager.remove(t);
	}

	@Override
	public void removeById(PK id) {
		remove(getById(id));
	}

	@Override
	public void deleteAll() {
		entityManager.createNamedQuery("truncate table " + getTypeClass().getName()).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(PK id) {
		return (T) entityManager.find(getTypeClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return (List<T>) entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}

	@Override
	public Long count() {
		return (Long) entityManager.createQuery(("select count(*) FROM " + getTypeClass().getName())).getResultList().get(0);
	}

}
