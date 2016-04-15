/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatc;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.UIManager;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ChatC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        // TODO code application logic here
        
        try {
            //com.jtattoo.plaf.
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (Exception e) {
        }
              
        FConnexion fc=new FConnexion();
        fc.setVisible(true);


    }
}
