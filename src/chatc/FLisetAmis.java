/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatc;

import Objets.AddressesPorts;
import Objets.Statut;
import Objets.listeAmis;
import beans.Utilisateur;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.swing.*;
import javax.swing.tree.*;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class FLisetAmis extends javax.swing.JFrame {

    ObjectOutputStream oos;
    ObjectInputStream ois;
    Utilisateur utilisateur;
    listeAmis amis;
    Vector<FChat> fChats;

    /**
     * Creates new form FLisetAmis
     */
    public FLisetAmis(listeAmis amis, ObjectOutputStream oos, ObjectInputStream ois) throws UnknownHostException, IOException {
        initComponents();
        setIconImage(new ImageIcon("chat.png").getImage());
        setLocationRelativeTo(null);
        setListeAmis(amis);
        
        fChats=new Vector<FChat>();
        
         DefaultTreeCellRenderer myRenderer = new DefaultTreeCellRenderer();

// Changement de l'icône pour les feuilles de l'arbre.
        myRenderer.setLeafIcon(new ImageIcon("rond-vert.png"));
// Changement de l'icône pour les noeuds fermés.
        myRenderer.setClosedIcon(new ImageIcon("vert.png"));
// Changement de l'icône pour les noeuds ouverts.
        myRenderer.setOpenIcon(new ImageIcon("vert.png"));

// Application de l'afficheur à l'arbre.
        jTree1.setCellRenderer(myRenderer);

        utilisateur = amis.get(amis.size() - 1);
        this.amis=amis;

        this.oos = oos;
        this.ois = ois;
        this.setTitle(utilisateur.getNom() + " " + utilisateur.getPrenom());

        new ThreadNotificationStatuts(this, amis.get(amis.size() - 1));

        
       for (int i = 0; i < amis.size() - 1; i++) {
                      
          fChats.add(new FChat(amis.get(i), utilisateur));
          
        }

    }

    public void setListeAmis(listeAmis amis) throws UnknownHostException, IOException {
        
        this.amis=amis;

        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Liste des amis");
        DefaultMutableTreeNode connectes = new DefaultMutableTreeNode("En ligne");
        DefaultMutableTreeNode horlignes = new DefaultMutableTreeNode("Hors ligne");

        for (int i = 0; i < amis.size() - 1; i++) {

            if (amis.get(i).getStatut() != Statut.horsligne) {
                DefaultMutableTreeNode amisEnLigne = new DefaultMutableTreeNode(amis.get(i));
                connectes.add(amisEnLigne);
            } else {
                DefaultMutableTreeNode amisHorsLigne = new DefaultMutableTreeNode(amis.get(i));
                horlignes.add(amisHorsLigne);
            }
        }

        top.add(connectes);
        top.add(horlignes);
        jTree1.setModel(new DefaultTreeModel(top));
        jTree1.expandRow(2);
        jTree1.revalidate();
        jTree1.expandRow(1);
        jTree1.revalidate();
        
//        for (int i = 0; i < amis.size() - 1; i++) {
//            new FChat(amis.get(i), utilisateur).setVisible(false);
//        }
    }
    
    public Utilisateur findAmisByLogin(String login){
        
        for(Utilisateur u: amis.getAmis()){
            if(u.getLogin().equals(login))
                return u;
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("rapidChat Liste des Amis");
        setBackground(new java.awt.Color(204, 0, 255));
        setForeground(java.awt.Color.darkGray);

        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jButton1.setText("Deconnexion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ajouter un amis");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Supprimer");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            System.out.println("Double click!");
            TreePath tp = jTree1.getPathForLocation(evt.getX(), evt.getY());
            if (tp != null) {

                try {
                String login = tp.getPathComponent(2).toString();
                for(int i=0; i<amis.getAmis().size() ; i++){
                    if(login.equals(amis.get(i).getLogin())){
                        fChats.get(i).setVisible(true);
                        break;
                    }
                }
                } catch (Exception e) {
                }
            }

        }
    }//GEN-LAST:event_jTree1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            Socket sc=new Socket(AddressesPorts.IpServeur, AddressesPorts.portServeurDeconnexion);
            ObjectOutputStream oos=new ObjectOutputStream(sc.getOutputStream());
            oos.writeObject(utilisateur);
            
        } catch (Exception ex) {
        }
        
        
        this.hide();
        FConnexion fConnexion=new FConnexion();
        fConnexion.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FAjouterAmis ajouterAmis=new FAjouterAmis(utilisateur);
        ajouterAmis.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FLisetAmis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FLisetAmis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FLisetAmis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FLisetAmis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
