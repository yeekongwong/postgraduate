package com.springmvc.daoImpl;
//package com.springmvc.daoImpl;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Vector;
//
//import javax.annotation.Resource;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
//import org.hibernate.Transaction;
//
//import com.springmvc.entity.User;
//
//public class BaseDao extends HibernateDaoSupport{
//	@SuppressWarnings("unused")
//	@Resource
//	private void setMySessionFactory(SessionFactory sessionFactory) {
//		// 方法名可以随便写，@Resource可以通过name 或者type来装载的。
//		super.setSessionFactory(sessionFactory);
//	}
//	
//	@SuppressWarnings("rawtypes")
//	public List findByProperty(String tableName,String propertyName, Object value) {
//		try {
//			String queryString = "from " + tableName + " as model where model."
//					+ propertyName + "= ?";
//			return getHibernateTemplate().find(queryString, value);
//		} catch (RuntimeException re) {
//			throw re;
//		}
//	}
//
//	
//	public <T> T loadById(String clazz, int id) {
//		T retVal = null;
//		Session session = GetHibernate4Session.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Query query = session.createQuery(
//					"from " + clazz + " t where t.id=?").setParameter(0, id);
//			if (query.list().size() > 0) {
//				retVal = (T) query.list().get(0);
//			}
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		return retVal;
//	}
//
//	public <T> T loadObject(String clazz, String hql) {
//		T retVal = null;
//		Session session = GetHibernate4Session.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Query query = session.createQuery(hql);
//			if (query.list().size() > 0) {
//				retVal = (T) query.list().get(0);
//			}
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		return retVal;
//	}
//
//	public boolean deleteById(String clazz, int id) {
//		boolean retVal = false;
//		Session session = GetHibernate4Session.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Query query = session.createQuery(
//					"delete from " + clazz + " t where t.id=?").setParameter(0,
////					id);
//			if (query.executeUpdate() > 0) {
//				retVal = true;// delete �ɹ�����true
//			}
//
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			retVal = false;
//			e.printStackTrace();
//		}
//		return retVal;
//	}
//
//	public <T> boolean delete(String clazz, T obj) {
//		boolean retVal = false;
//		Session session = GetHibernate4Session.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			session.delete(obj);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		return retVal;
//	}
//
//	public <T> void saveOrUpdate(String clazz, T obj) {
//		T retVal = null;
//		Session session = GetHibernate4Session.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			// retVal=(T) session.merge(obj);
//			session.saveOrUpdate(clazz, obj);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		// return retVal;
//	}
//
//	public <T> T merge(String clazz, T obj) {
//		T retVal = null;
//		Session session = GetHibernate4Session.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			retVal = (T) session.merge(obj);
//			// session.saveOrUpdate(clazz, obj);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		return retVal;
//	}
//
//	public List listAll(String clazz) {
//		List retVal = null;
//		Session session = GetHibernate4Session.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Query query = session.createQuery("from " + clazz);
//			retVal = query.list();
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		return retVal;
//	}
//
//	public List listAll(String clazz, int pageNo, int pageSize) {
//		List retVal = null;
//		return retVal;
//	}
//
//	public int countAll(String clazz) {
//		int retVal = this.listAll(clazz).size();
//		return retVal;
//	}
//
//	public List query(String hql) {
//		List retVal = null;
//		Session session = GetHibernate4Session.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Query query = session.createQuery(hql);
//			retVal = query.list();
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		return retVal;
//	}
//
//	public List query(String hql, int pageNo, int pageSize) {
//		List retVal = null;
//		return retVal;
//	}
//
//	public int countQuery(String hql) {
//		int retVal = this.query(hql).size();
//		return retVal;
//	}
//
//	public int update(String hql) {
//		int retVal = 0;
//		Session session = GetHibernate4Session.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Query query = session.createQuery(hql);
//			retVal = query.executeUpdate();
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		return retVal;
//	}
//
//	public Vector getVectorBySql(String sql) throws SQLException {
//		Vector retVal = null;
//		return retVal;
//	}
//
//	public String getSingleValueBySql(String sql) {
//		String retVal = null;
//		return retVal;
//	}
//
//	public int getCountValueBySql(String sql) {
//		int retVal = 0;
//		return retVal;
//	}
//
//	public boolean executeSql(String sql) {
//		boolean retVal = true;
//		return retVal;
//	}
//}
