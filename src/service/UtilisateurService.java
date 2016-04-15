/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Objets.LoginPasswordSatut;
import beans.Utilisateur;
import com.sun.org.apache.bcel.internal.generic.AASTORE;
import dao.AbstractDao;
import dao.Query;
import dao.UtilisateurDao;
import helpers.HibernateUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class UtilisateurService {
    
    UtilisateurDao utilisateurDao;
    public UtilisateurService() {
        utilisateurDao=new UtilisateurDao();
    }

    public void save(Utilisateur utilisateur) throws Exception{
         ResultSet rs=Query.execute("SELECT count( * ) AS n FROM utilisateur WHERE `login` = '"+utilisateur.getLogin()+"'");
         rs.next();
         int n=rs.getInt("n");
         if(n>1)
             throw new Exception("Ce login existe déja!");
        else
             utilisateurDao.save(utilisateur);
    }

    public Utilisateur load(int id) {
        return utilisateurDao.load(id);
    }

    public boolean delete(Utilisateur utilisateur) {
        return utilisateurDao.delete(utilisateur);
    }

    public void update(Utilisateur utilisateur) {
        utilisateurDao.update(utilisateur);
    }
    
     public List<Utilisateur> loadAll(){
            return utilisateurDao.loadAll();
    }
    
    public Utilisateur loadByLogin(String login) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
	List<Utilisateur> list = session.createQuery("from Utilisateur where login ='"+login+"'").list();
	return list.get(0);    
    }
    
    public static void main(String args[]){
         UtilisateurService us=new UtilisateurService();
         Utilisateur u=us.loadByLogin("zakaria");
         System.out.println(u.getNom());
         
     }

}
