package com.springmvc.daoImpl;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class BaseDao extends HibernateDaoSupport{
	private SessionFactory sessionFactory;
	@SuppressWarnings("unused")
	@Resource
	private void setMySessionFactory(SessionFactory sessionFactory) {
		// 方法名可以随便写，@Resource可以通过name 或者type来装载的。
		this.sessionFactory = sessionFactory;
		super.setSessionFactory(sessionFactory);
	}
	
	/*查询
	 * findByProperty,findById,findByHql,findAll
	 * */
	@SuppressWarnings("rawtypes")
	public <T> List<T> findByProperty(String tableName,String propertyName, Object value) {
		try {
			String queryString = "from " + tableName + " as model where model."
					+ propertyName + "= ?";
			return (List<T>)getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T>T findById(String className,Integer id){
		try {
			Object obj = getHibernateTemplate().get("com.springmvc.entity."+className, id);
			T instance = (T)obj; 
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public <T> List<T> findByExample(T instance) {
		try {
			List results = getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public <T> List<T> findByHql(String hql) {
		try {
			List retList = getHibernateTemplate().find(hql); 
			return retList;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public <T> List<T> findAll(String className) {
		try {
			String queryString = "from " + className;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	/*删除
	 * delete,deleteById,deleteByHql
	 * */
	public <T> boolean delete(T persistentInstance) {
		boolean retVal;
		try {
			getHibernateTemplate().delete(persistentInstance);
			retVal = true;
		} catch (RuntimeException re) {
			throw re;
		}
		return retVal;
	}

	public boolean deleteById(String className,Integer id) {
		  String hql = "delete " + className + " model where model.id=?";
		  //Query query = sessionFactory.getCurrentSession().createQuery(hql);
		  Query query = getSession().createQuery(hql);
		  query.setInteger(0, id);
		  return (query.executeUpdate()>0);
	}
	
	public boolean deleteByHql(String hql) {
		  Query query = getSession().createQuery(hql);
		  return (query.executeUpdate()>0);
	}
	
	/*
	 * 分页的方法
	 * */
	
	/*
	 * save,merge
	 * */
	public <T> void save(T transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public <T>T merge(T detachedInstance) {
		try {
			T result = (T) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
