package com.springmvc.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.User;
import com.springmvc.dao.*;

@Repository("userDao")
public class UserDAOImpl extends BaseDao implements UserDAO{
	public static final String NAME = "name";
	public static final String PWD = "pwd";
	public static final String CLASS = "User";
	@SuppressWarnings("unused")
	@Resource
	private void setMySessionFactory(SessionFactory sessionFactory){
	  //方法名可以随便写，@Resource可以通过name 或者type来装载的。
	  super.setSessionFactory(sessionFactory);
	} 
//    <bean id="albumOperateDaoImpl" class="org.huang.persistence.hibernate.AlbumOperateDaoImpl">  
//    	<property name="sessionFactory" ref="sessionFactory"></property>  
//    </bean>  
	
	public boolean deleteById(String className,Integer id){
		return super.deleteById(CLASS, id);
	}
	
	public User findById(Integer id){
		return super.findById("User", id);
	}

	public List<User> findByName(Object name) {
		return super.findByProperty(CLASS,NAME, name);
	}
	
	
	
}
