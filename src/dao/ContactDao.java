/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Contact;
import beans.Utilisateur;
import helpers.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ContactDao {

    AbstractDao<Contact> abstractDao;

    public ContactDao() {
        abstractDao = new AbstractDao<Contact>(Contact.class);
    }

    public void save(Contact contact) {
        abstractDao.save(contact);
    }

    public Contact load(int id) {
        return abstractDao.load(id);
    }

    public boolean delete(Contact contact) {
        return abstractDao.delete(contact.getId());
    }

    public void update(Contact contact) {
        abstractDao.update(contact);
    }

    public List<Contact> loadAll() {
        return abstractDao.loadAll();
    }
}
