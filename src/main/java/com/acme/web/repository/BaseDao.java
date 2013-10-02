package com.acme.web.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings({"rawtypes", "deprecation"})
public class BaseDao {
	@Autowired
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Autowired
	@Qualifier(value = "dataSource")
	protected DataSource dataSource;
	


	public void lock(Object domainObject, LockModeType lockMode) {
		entityManager.lock(domainObject, lockMode);
	}

	public <T extends Object> T find(Class<T> domainObjectClass, Object id) {
		return entityManager.find(domainObjectClass, id);
	}
	
	public <T extends Object> T getPseudoReference(Class<T> domainObjectClass, Object id) {
		return entityManager.getReference(domainObjectClass, id);
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
	public void persist(Object domainObject) {
		entityManager.persist(domainObject);
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
	public void persist(Collection<? extends Object> domainObjects) {
		for(Object domainObject : domainObjects) {
			entityManager.persist(domainObject);
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
	public <T extends Object> T merge(T domainObject) {
		return entityManager.merge(domainObject);
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
	public void merge(Collection<? extends Object> domainObjects) {
		for(Object domainObject : domainObjects) {
			entityManager.merge(domainObject);
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
	public void delete(Object domainObject) {
		entityManager.remove(domainObject);
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
	public void delete(Collection<? extends Object> domainObjects) {
		for(Object domainObject : domainObjects) {
			entityManager.remove(domainObject);
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
	public void delete(Class domainObjectClass, Collection<? extends Number> ids) {
		// TODO: could we do one query to get all the objects, and then delete each one?
		// that would reduce the #of queries required to do this in half almost
		// we'd have to figure out how to secure that query though, in a generic way
		for(Number id : ids) {
			delete(find(domainObjectClass, id));
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
	public void flush() {
		entityManager.flush();
	}

	public void clear() {
		entityManager.clear();
	}
	
	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
	public void refresh(Object domainObject) {
		entityManager.refresh(domainObject);
	}

	protected Query createQuery(String jpql) {
		return createQuery(jpql, null);
	}

	protected Query createQuery(String jpql, Map<String, Object> params) {
		Query query = entityManager.createQuery(jpql);
		addParams(query, params);

		return query;
	}

	private void addParams(Query query, Map<String, Object> params) {
		if(params != null) {
			Set<String> paramNames = params.keySet();
			for(String paramName : paramNames) {
				query.setParameter(paramName, params.get(paramName));
			}
		}
	}

	protected int executeUpdate(SqlParameterSource sql) {
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(dataSource);
		return jdbcTemplate.update(sql.toString(), sql);
	}

	protected int executeUpdate(String sql, Map<String, Object> params) {
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(dataSource);
		return jdbcTemplate.update(sql, params);
	}

	protected int executeUpdate(String sql) {
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(dataSource);
		return jdbcTemplate.update(sql);
	}

	protected Query createNativeQuery(String nativeSql) {
		return entityManager.createNativeQuery(nativeSql);
	}

	protected Query createNamedQuery(String name) {
		return entityManager.createNamedQuery(name);
	}

	protected List getResultList(Query query) {
		return query.getResultList();
	}

	public List getResultList(String jpql, Map<String, Object> params) {
		return getResultList(jpql, params, null, null);
	}

	public List getResultList(String jpql, Map<String, Object> params, Integer firstResult, Integer maxResults) {
		Query query = entityManager.createQuery(jpql);

		addParams(query, params);

		if(firstResult != null) {
			query.setFirstResult(firstResult);
		}

		if(maxResults != null) {
			query.setMaxResults(maxResults);
		}

		return getResultList(query);
	}

}
