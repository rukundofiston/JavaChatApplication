/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class Query {

    public static ResultSet execute(String sql) throws SQLException {
        java.sql.Statement instruction = null;
        ResultSet resultat = null;

        Connection c = Connexion.getInstance();
        instruction = c.createStatement();
        resultat = instruction.executeQuery(sql);

        return resultat;
    }

    public static boolean update(String sql) {
        try {
            java.sql.Statement instruction = null;

            Connection c = Connexion.getInstance();

            instruction = c.createStatement();
            instruction.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Echec! " + e.getMessage());
            return false;
        }

        System.out.println("opération réussie!");
        return true;

    }
}
