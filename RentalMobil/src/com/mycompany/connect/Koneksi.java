/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.connect;

import java.sql.*;
import javax.swing.JOptionPane;

public class Koneksi {

    public String user;
    public String pwd; 
    public String host;
    public String db; 
    public String url;
    public Statement st = null;
    public ResultSet rs = null;
    public Connection con = null;

    public Koneksi() {
        user = "root";
        pwd = "";
        host = "localhost";
        db = "rental_mobil_DB";
        url = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("gagal");
        }
        try {
            url = "jdbc:mysql://localhost:3306/rental_mobil_DB";
            con = (Connection) DriverManager.getConnection(url, user, pwd);
        } catch (SQLException se) {
            System.out.println("Perintah salah.");
        } catch (Exception ex) {
            System.out.println("Driver tidak Terhubung");
        }
    }
    
    public ResultSet getData(String SQLString){
        try{
            st = con.createStatement();
            rs = st.executeQuery(SQLString);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "Communication Error " + JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
    public int query(String SQLString){
        try{
            st = con.createStatement();
            st.executeUpdate(SQLString);
            return 1;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "Communication Error " + JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }
   

}

