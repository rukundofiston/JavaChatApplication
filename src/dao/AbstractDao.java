package dao;

import helpers.HibernateUtil;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

public class AbstractDao<T> {
	
	private Class<T> type;
	public AbstractDao(Class<T> type) {
        this.type = type;
    }
    

	public void save(T object){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
	}
	public void update(T object){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();	
	
	}
	@SuppressWarnings("unchecked")
	public List<T> loadUsingCriterea(String variable,String keyWord){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(type);
		criteria.add(Expression.like(variable, "%"+keyWord+"%"));
		return criteria.list();
		
	}
	public T load(int id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		T object =(T) session.load(type, id);
		return object;
	}
	
	public  List<T> loadAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<T> list = session.createQuery("from " + type.getName()).list();
	    return list;
	}

	public boolean delete(int id){
		T myObject = load(id);
		
		if(myObject != null){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(myObject);
		session.getTransaction().commit();
		return true;
		}
		return false;
	}

	
	
}
