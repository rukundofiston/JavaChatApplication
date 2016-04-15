/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ServeurEnvoi extends Thread{

    private ServerSocket serverSocket;

    public ServeurEnvoi(int port) throws IOException {
        serverSocket=new ServerSocket(port);
        this.start();
    }
    
        @Override
    public void run() {
        System.out.println("ServeurEnvoi en attente des demandes sur le port : "+serverSocket.getLocalPort());
        while(true){
            try {
                Socket sc=this.serverSocket.accept();
                new NouveauEnvoi(sc, this);
            } catch (IOException ex) {
                Logger.getLogger(ServeurConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
