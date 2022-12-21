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
public class Peminjaman {
    private String peminjaman;
    private String pelanggan;
    private String mobil;
    private String petugas;
    private String pTanggal;
    private String pBulan;
    private String pTahun;
    private String lama;
    private String pDate;
    private String kTahun;
    private String biaya;
    private String pegawai;
    private String telat;
    private String denda;
    private String tanggalHarusKembali;
    private int idPegawai;
    private int totalSewa;
    
    public Peminjaman(){}
    
    public void setPDate(String pDate){
        this.pDate = pDate;
    }
    
    public String getPDate(){
        return this.pDate;
    }
    
    public void setPeminjaman(String peminjaman){
        this.peminjaman = peminjaman;
    }
    
    public String getPeminjaman(){
        return this.peminjaman;
    }
    
    public void setPelanggan(String pelanggan){
        this.pelanggan = pelanggan;
    }
    
    public String getPelanggan(){
        return this.pelanggan;
    }
    
    public void setMobil(String mobil){
        this.mobil = mobil;
    }
    
    public String getMobil(){
        return this.mobil;
    }
    
    public void setPetugas(String petugas){
        this.petugas = petugas;
    }
    
    public String getPetugas(){
        return this.petugas;
    }
    
    public void setpTanggal(String pTanggal){
        this.pTanggal = pTanggal;
    }
    
    public String getpTanggal(){
        return this.pTanggal;
    }
    
    public void setpBulan(String pBulan){
        this.pBulan = pBulan;
    }
    
    public String getpBulan(){
        return this.pBulan;
    }
    
    public void setpTahun(String pTahun){
        this.pTahun = pTahun;
    }
    
    public String getpTahun(){
        return this.pTahun;
    }
    
    public void setLama(String lama){
        this.lama = lama;
    }
    
    public String getLama(){
        return this.lama;
    }
      
    public void setkTahun(String kTahun){
        this.kTahun = kTahun;
    }
    
    public void setPegawai(String pegawai){
        this.pegawai = pegawai;
    }
    
    public String getPegawai(){
        return this.pegawai;
    }
    
    public void setBiaya(String biaya){
        this.biaya = biaya;
    }
    
    public String getBiaya(){
        return this.biaya;
    }
    
    public void setTelat(String telat){
        this.telat = telat;
    }
    
    public String getTelat(){
        return this.telat;
    }
    
    public void setDenda(String denda){
        this.denda = denda;
    }
    
    public String getDenda(){
        return this.denda;
    }
    
    public void setIdPegawai(int idPegawai){
        this.idPegawai = idPegawai;
    }
    
    public int getIdPegawai(){
        return this.idPegawai;
    }
    
    public void setTanggalHarusKembali(String tanggalHarusKembali){
        this.tanggalHarusKembali = tanggalHarusKembali;
    }
    
    public String getTanggalHarusKembali(){
        return this.tanggalHarusKembali;
    }
    
    public void setTotalSewa(int totalSewa){
        this.totalSewa = totalSewa;
    }
    
    public int getTotalSewa(){
        return this.totalSewa;
    }
    
    
    public int insertPeminjaman(){
        Koneksi peminjamanModel = new Koneksi();
        String queryString = "INSERT INTO peminjaman(id_peminjaman, tanggal_pinjam, tanggal_harus_kembali, lama_pinjam, total_sewa, id_pelanggan,"
                + "mobil_id, id_pegawai) VALUES('" 
                + this.peminjaman 
                + "','" + this.pDate + "','"
                + this.tanggalHarusKembali + "','" + Integer.valueOf(this.lama)
                + "','" + Integer.valueOf(this.totalSewa) + "','" 
                + this.pelanggan + "','"
                + this.mobil + "','" + this.idPegawai + "')";
        
        int affectedRow = peminjamanModel.query(queryString);
        return affectedRow;
    }
    
    public int updatePeminjaman(){
        Koneksi peminjamanModel = new Koneksi();
        String queryString = "UPDATE peminjaman SET telat = " + Integer.valueOf(this.telat) 
                + ", denda = " + Integer.valueOf(this.denda) + ", tanggal_kembali = '" + this.kTahun
                + "' WHERE id_peminjaman = '" + this.peminjaman + "'";
        
        int affectedRow = peminjamanModel.query(queryString);
        return affectedRow;
    }
    
    public int deletePeminjaman(){
        Koneksi peminjamanModel = new Koneksi();
        String queryString = "DELETE FROM peminjaman WHERE id_peminjaman = '" + this.peminjaman + "'";
        
        int affectedRow = peminjamanModel.query(queryString);
        return affectedRow;
    }
    
    public ResultSet getAllPeminjaman(){
        Koneksi peminjamanModel = new Koneksi();
        ResultSet rs = null;
        
        String queryString = "SELECT * FROM peminjaman";
        rs = peminjamanModel.getData(queryString);
        
        return rs;
        
    }
}
