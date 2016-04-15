/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Message;
import helpers.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class MessageDao {
    
   AbstractDao<Message> abstractDao;

    public MessageDao() {
        abstractDao=new AbstractDao<Message>(Message.class);
    }
        
    public void save(Message message) {
       abstractDao.save(message);
    }

    public Message load(int id) {
        return abstractDao.load(id);
    }

    public boolean delete(Message message) {
      return abstractDao.delete(message.getId());
    }

    public void update(Message message) {
        abstractDao.update(message);
    }
    
    public List<Message> loadAll(){
        return abstractDao.loadAll();
    }
}
