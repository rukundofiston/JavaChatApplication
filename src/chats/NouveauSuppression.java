/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import beans.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MessageService;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class NouveauSuppression extends Thread{

        
    Socket sc;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public NouveauSuppression(Socket sc) throws IOException {
        this.sc = sc;
        oos = new ObjectOutputStream(sc.getOutputStream());
        ois = new ObjectInputStream(sc.getInputStream());
        this.start();
    }

    @Override
    public void run() {
            try {

                Message msg = (Message) ois.readObject();
                MessageService ms =new MessageService();
                ms.save(msg);
                System.out.println(msg.getContenu());

            } catch (Exception ex) {
                Logger.getLogger(NovelleNotification.class.getName()).log(Level.SEVERE, null, ex);
            }
//        try {
//            sc.close();
//        } catch (IOException ex) {
//            Logger.getLogger(NovelleNotification.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
}
