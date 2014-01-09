package br.com.guardiao.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final Logger logger = Logger.getLogger(HibernateUtil.class);

	private static final SessionFactory sessionFactory;
	
	private static ThreadLocal<Session> sessions = new ThreadLocal<Session>();

	static {
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	public static Session openSession() {
		if (sessions.get() != null) {
			logger.error("There was a session for this thread already!! ");
			// grave, alguem nao fechou uma sessao ja aberta!
		}
		sessions.set(sessionFactory.openSession());
		return sessions.get();
	}

	public static void closeCurrentSession() {
		sessions.get().close();
		sessions.set(null);
	}

	public static Session currentSession() {
		return sessions.get();
	}
	
	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}
	
}