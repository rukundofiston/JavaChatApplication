/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objets;

import beans.Utilisateur;
import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class listeAmis implements Serializable{
    
    Vector<Utilisateur> amis;

    public listeAmis(Vector<Utilisateur> amis) {
        this.amis=amis;        
    }

    public Vector<Utilisateur> getAmis() {
        return amis;
    }

    public void setAmis(Vector<Utilisateur> amis) {
        this.amis = amis;
    }        

    @Override
    public String toString() {
        return amis.toString();
    }
    
    public int size(){
        return amis.size();
    }
    
    public Utilisateur get(int index){
        return amis.get(index);
    }
    
    
}
