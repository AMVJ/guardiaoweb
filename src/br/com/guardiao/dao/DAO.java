package br.com.guardiao.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public class DAO<T> {

    private static Logger logger = Logger.getLogger(DAO.class);
    private Class persistentClass;
    protected Session session;

    public DAO(Session session, Class persistentClass) {
        this.session = session;
        this.persistentClass = persistentClass;
    }

    protected Session getSession(){
		return session; 	
	}
    
    @SuppressWarnings("unchecked")
    public T load(Long id) {
        logger.info("lendo " + persistentClass + " com id " + id);
        return (T) session.load(persistentClass, id);
    }
   
    public void save(T t) {
        logger.info("salvando  " + t);
        session.save(t);
    }
    
	public void delete(T t) {
		logger.info("Deletando " + t);
		session.delete(t);
	}
	
    @SuppressWarnings("unchecked")
	public List<T> list() {
		logger.info("Listando todos");
    	return session.createCriteria(persistentClass).list();
    }

    public void merge(T t) {
        logger.info("Salvando ou atualizando " + t);
        session.merge(t);
    }
}