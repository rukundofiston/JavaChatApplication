/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class Contact {
    private int id;
    private int idUtilisateur1;
    private int idUtilisateur2;
    private String categorie;
    private String bloque;

    public Contact() {
    }

    public Contact(int idUtilisateur1, int idUtilisateur2, String categorie) {
        this.idUtilisateur1 = idUtilisateur1;
        this.idUtilisateur2 = idUtilisateur2;
        this.categorie = categorie;
        this.bloque="non";
    }

    public int getId() {
        return id;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getIdUtilisateur1() {
        return idUtilisateur1;
    }

    public int getIdUtilisateur2() {
        return idUtilisateur2;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUtilisateur1(int idUtilisateur1) {
        this.idUtilisateur1 = idUtilisateur1;
    }

    public void setIdUtilisateur2(int idUtilisateur2) {
        this.idUtilisateur2 = idUtilisateur2;
    }

    @Override
    public String toString() {
        return ""+id+idUtilisateur1+idUtilisateur2;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }
    
    
    
}
