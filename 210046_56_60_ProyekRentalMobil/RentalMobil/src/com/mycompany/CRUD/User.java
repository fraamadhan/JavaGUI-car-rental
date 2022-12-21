/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.User to edit this template
 */
package com.mycompany.CRUD;

import com.mycompany.connect.Koneksi;
import com.mycompany.encryptAlgorithm.Encrypt;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Fakhri Fajar
 */
public class User {

    private String username;
    private String password;
    private String nama;
    private String alamat;
    private String cp;
    private String kode = "2";
    private int userId;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUSerId() {
        return this.userId;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCp() {
        return this.cp;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setKode(String kode){
        this.kode = kode;
    }
    
    public String getKode(){
        return this.kode;
    }

//    private static String bytesToHex(byte[] hash) {
//        StringBuilder hexString = new StringBuilder(2 * hash.length);
//        for (int i = 0; i < hash.length; i++) {
//            String hex = Integer.toHexString(0xff & hash[i]);
//            if (hex.length() == 1) {
//                hexString.append('0');
//            }
//            hexString.append(hex);
//        }
//        return hexString.toString();
//    }
    public int InsertUser() {
        Koneksi userModel = new Koneksi();
        Encrypt encrypt = new Encrypt();
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(
                    this.password.getBytes(StandardCharsets.UTF_8));
            this.password = encrypt.bytesToHex(hashbytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String queryString = "INSERT INTO pegawai (username, password, kode, nama, alamat, contact_person) VALUES('"
                + this.username + "','" + this.password + "','" + "2" + "','" + this.nama + "','" + this.alamat + "','" + this.cp + "')";
        int affectedRow = userModel.query(queryString);
        return affectedRow;

//        try {
//            userModel.query(queryString);
//            return 1;
//        } catch (SQLException e) {
//            return 0;
//        }
//    }
    }

    public int InsertUserbyAdmin() {
        Koneksi userModel = new Koneksi();
        Encrypt encrypt = new Encrypt();
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(
                    this.password.getBytes(StandardCharsets.UTF_8));
            this.password = encrypt.bytesToHex(hashbytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String queryString = "INSERT INTO pegawai VALUES('" + this.username + "','" + this.password + "',"
                + this.userId + ",'" + this.kode + "','" + this.nama + "','" + this.alamat + "','" + this.cp + "')";
        int affectedRow = userModel.query(queryString);
        return affectedRow;

//        try {
//            userModel.query(queryString);
//            return 1;
//        } catch (SQLException e) {
//            return 0;
//        }
//    }
    }

    public int updatePegawai() {
        Koneksi userModel = new Koneksi();
        Encrypt encrypt = new Encrypt();
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(
                    this.password.getBytes(StandardCharsets.UTF_8));
            this.password = encrypt.bytesToHex(hashbytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String queryString = "UPDATE pegawai SET userId = " + this.userId + ", username = '" + this.username + "', password = '"
                + this.password + "', nama = '" + this.nama + "', alamat = '" + this.alamat + "',contact_person = '" + this.cp + "', kode = '"
                + this.kode + "' WHERE userId = " + this.userId;

        int affectedRow = userModel.query(queryString);
        return affectedRow;
    }

    public int deletePegawai() {
        Koneksi userModel = new Koneksi();
        String queryString = "DELETE FROM pegawai WHERE userId = '" + this.userId + "'";

        int affectedRow = userModel.query(queryString);
        return affectedRow;
    }

    public ResultSet getAllPegawai() {
        Koneksi userModel = new Koneksi();
        ResultSet rs = null;

        String queryString = "SELECT * FROM pegawai";
        rs = userModel.getData(queryString);

        return rs;

    }

//    public static void main(String[] args){
//        User us = new User("Inshira Vieta Amara", "Amara");
//        us.InsertUser();
//    }
}
