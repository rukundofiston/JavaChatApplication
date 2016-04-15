/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Contact;
import beans.Utilisateur;
import dao.AbstractDao;
import dao.ContactDao;
import helpers.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ContactService {
    
    ContactDao contactDao;
    public ContactService() {
        contactDao = new ContactDao();
    }

    public void save(Contact contact) {
        contactDao.save(contact);
    }

    public Contact load(int id) {
        return contactDao.load(id);
    }

    public boolean delete(Contact contact) {
        return contactDao.delete(contact);
    }

    public void update(Contact contact) {
        contactDao.update(contact);
    }

    public List<Contact> loadAll() {
        return contactDao.loadAll();
    }
    
    public List<Contact> loadContactsUtilisateur(Utilisateur utilisateur) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	List<Contact> list = session.createQuery("from Contact where idUtilisateur1=1").list();
	return list;
    }
 
    
}
