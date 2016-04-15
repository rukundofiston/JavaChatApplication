/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Objets.Statut;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class Utilisateur implements Serializable{
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String login;
    private String password;
    private String photo;
    private String questionSecrete;
    private String reponse;
    private Statut statut=Statut.horsligne;

    public Utilisateur() {
    }

    public Utilisateur( String nom, String prenom, String sexe, String login, String password, String photo, String questionSecrete, String reponse) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.login = login;
        this.password = password;
        this.photo = photo;
        this.questionSecrete=questionSecrete;
        this.reponse=reponse;
    }

    public Utilisateur(Utilisateur u) {
        this.id = u.getId();
        this.nom = u.getNom();
        this.prenom = u.getPrenom();
        this.sexe = u.getSexe();
        this.login = u.getLogin();
        this.password = u.getPassword();
        this.photo = u.getPassword();
        this.questionSecrete=u.getQuestionSecrete();
        this.reponse=u.getReponse();
    }


    
    

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getQuestionSecrete() {
        return questionSecrete;
    }

    public String getReponse() {
        return reponse;
    }

    public void setQuestionSecrete(String questionSecrete) {
        this.questionSecrete = questionSecrete;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return login;
    }
    
    
    
    
}
