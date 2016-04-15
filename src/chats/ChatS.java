/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import Objets.AddressesPorts;
import java.io.IOException;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class ChatS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        

        ServeurConnexion serveurConnexion=new ServeurConnexion(AddressesPorts.portServeurConnexion);
        ServeurInscription serveurInscription=new ServeurInscription(AddressesPorts.portServeurInscription, serveurConnexion);
        ServeurNotificationStatut serveurNotificationStatut=new ServeurNotificationStatut(AddressesPorts.portServeurNotification, serveurConnexion);
        ServeurChat serveurChat=new ServeurChat(AddressesPorts.portServeurChat, serveurConnexion);
        ServeurEnvoi serveurEnvoi=new ServeurEnvoi(AddressesPorts.portServeurEnvoi);
        ServeurAjoutAmis serveurAjoutAmis=new ServeurAjoutAmis(AddressesPorts.portServeurAjoutAmis, serveurConnexion);
        ServeurDeconnexion serveurDeconnexion=new ServeurDeconnexion(AddressesPorts.portServeurDeconnexion, serveurConnexion);
   
    }
}
