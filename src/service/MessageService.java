/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Message;
import beans.Utilisateur;
import dao.AbstractDao;
import dao.MessageDao;
import helpers.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class MessageService {
       MessageDao messageDao;

    public MessageService() {
        messageDao=new MessageDao();
    }
        
    public void save(Message message) {
       messageDao.save(message);
    }

    public Message load(int id) {
        return messageDao.load(id);
    }

    public boolean delete(Message message) {
      return messageDao.delete(message);
    }

    public void update(Message message) {
        messageDao.update(message);
    }
    
    public List<Message> loadAll(){
        return messageDao.loadAll();
    } 
    
     public List<Message> loadNonLu(Utilisateur u){
         Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<Message> list = session.createQuery("from Message where lu=0 and idEmetteur="+u.getId() ).list();
	    return list;
    } 
     
     public static void main(String args[]){
         UtilisateurService us=new UtilisateurService();
         Utilisateur u=us.load(2);
         MessageService messageService=new MessageService();
         System.out.println(messageService.loadNonLu(u));
         
     }
    
    
}
