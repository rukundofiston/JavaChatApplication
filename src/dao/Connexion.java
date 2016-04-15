/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class Connexion {

    private static String username;
    private static String password;
    private static String url;
    private static String driver;
    private static Connection con = null;

    private Connexion() {
        username = "root";
        password = "";
        url = "jdbc:mysql://localhost/chat";
        driver = "com.mysql.jdbc.Driver";
    }

    public static Connection getInstance() {
        if (con == null) {
            new Connexion();
            try {
                Class.forName(driver).newInstance();
                con = DriverManager.getConnection(url, username, password);
                System.out.println("Connection successfully established.");

            } catch (Exception e) {
                System.out.println("Connection failed !!");
            }
        }
        return con;
    }
}
