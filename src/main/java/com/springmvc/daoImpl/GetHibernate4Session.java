//package com.springmvc.daoImpl;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.Resource;
//import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
//
//public class GetHibernate4Session {		
//		private static final SessionFactory sessionFactory;
//		private static final Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		static{			
//		ServiceRegistry serviceRegistry= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();  	
//		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
//		}
//	@SuppressWarnings("resource")
//	public static Session getSession(){				
////		ApplicationContext applicationContext = null;    
////		String[] fileUrl = new String[]{"classpath*:*Context*.xml"};    
////		applicationContext = new ClassPathXmlApplicationContext(fileUrl);    
////		//applicationContext = new FileSystemXmlApplicationContext(fileUrl);   
////		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");  
//		return sessionFactory.openSession();
//	}
//
//	//	private SessionFactory sessionFactory;
//	//	public  Session getSession(){
//	//		return sessionFactory.openSession();
//	//	}
//	@SuppressWarnings("resource")
//	public static SessionFactory getSessionFactory() {
////		ApplicationContext applicationContext = null;    
////		String[] fileUrl = new String[]{"classpath*:*Context*.xml"};    
////		applicationContext = new ClassPathXmlApplicationContext(fileUrl);    
////		//applicationContext = new FileSystemXmlApplicationContext(fileUrl);   
////		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");  
//		return sessionFactory;
//	}
//	//	public void setSessionFactory(SessionFactory sessionFactory) {
//	//		this.sessionFactory = sessionFactory;
//	//	}
//
//}
