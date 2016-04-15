/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Message;
import beans.Utilisateur;
import helpers.HibernateUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class UtilisateurDao {
    
  AbstractDao<Utilisateur> abstractDao;

    public UtilisateurDao() {
        abstractDao=new AbstractDao<Utilisateur>(Utilisateur.class);
    }

    public void save(Utilisateur utilisateur) {
       abstractDao.save(utilisateur);
    }

    public Utilisateur load(int id) {
        return abstractDao.load(id);
    }

    public boolean delete(Utilisateur utilisateur) {
        return abstractDao.delete(utilisateur.getId());
    }

    public void update(Utilisateur utilisateur) {
        abstractDao.update(utilisateur);
    }
    
     public List<Utilisateur> loadAll(){
            return abstractDao.loadAll();
    }
}
