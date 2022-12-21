/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.CRUD;

import com.mycompany.connect.Koneksi;
import java.sql.*;

/**
 *
 * @author Fakhri Fajar
 */
public class Pelanggan {

    private String id_pelanggan;
    private String nama;
    private String alamat;
    private String cp;
    private int userId;
    private String status;

    public Pelanggan() {
    }

    public Pelanggan(String id_pelanggan, String nama, String alamat, String cp) {
        this.id_pelanggan = id_pelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.cp = cp;
    }

    public void setId_Pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getId_Pelanggan() {
        return this.id_pelanggan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public int insertPelanggan() {
        Koneksi pelangganModel = new Koneksi();
        String queryString = "INSERT INTO pelanggan VALUES ('" + this.id_pelanggan + "', '" + this.nama + "', '" + this.alamat + "', '" + this.cp + "', '" + this.userId + "')";
        int affectedRow = pelangganModel.query(queryString);
        return affectedRow;
    }

    public int updatePelanggan() {
        Koneksi pelangganModel = new Koneksi();
        String tempIdPelanggan = this.id_pelanggan;
        String queryString = "UPDATE pelanggan SET id_pelanggan = '" + this.id_pelanggan + "', nama = '" + this.nama + "', "
                + "contact_person = '" + this.cp + "', alamat = '" + this.alamat + "' WHERE id_pelanggan = '" + this.id_pelanggan + "'";

        int affectedRow = pelangganModel.query(queryString);
        return affectedRow;
    }

    public int deletePelanggan(String id_pelanggan) {
        Koneksi pelangganModel = new Koneksi();
        String queryString = "DELETE FROM pelanggan WHERE id_pelanggan = '" + id_pelanggan + "'";

        int affectedRow = pelangganModel.query(queryString);
        return affectedRow;
    }

    public ResultSet findByIdPelanggan(String id) {
        Koneksi pelangganModel = new Koneksi();
        ResultSet rs = null;
        String queryString = "SELECT * FROM pelanggan WHERE id_pelanggan = '" + id + "'";

        rs = pelangganModel.getData(queryString);
        return rs;
    }

}
