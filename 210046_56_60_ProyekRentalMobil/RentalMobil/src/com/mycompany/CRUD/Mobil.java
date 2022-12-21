/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.CRUD;

import com.mycompany.connect.Koneksi;
import java.sql.ResultSet;

/**
 *
 * @author Fakhri Fajar
 */
public class Mobil {
    private String mobil_id;
    private String jenis;
    private int sewa;
    private int stok;
    
    public Mobil(){}
    
    public void setMobilId(String mobil_id){
        this.mobil_id = mobil_id;
    }
    
    public String getMobilId(){
        return this.mobil_id;
    }
    
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    
    public String getJenis(){
        return this.jenis;
    }
    
    public void setSewa(int sewa){
        this.sewa = sewa;
    }
    
    public int getSewa(){
        return this.sewa;
    }
    
    public void setStok(int stok){
        this.stok = stok;
    }
    
    public int getStok(){
        return this.stok;
    }
    
    public int insertMobil(){
        Koneksi mobilModel = new Koneksi();
        String queryString = "INSERT INTO mobil VALUES('" + this.mobil_id + "','" + this.jenis + "', " + this.sewa + "," + this.stok + ")";
        
        int affectedRow = mobilModel.query(queryString);
        return affectedRow;
    }
    
    public int updateMobil(){
        Koneksi mobilModel = new Koneksi();
        String queryString = "UPDATE mobil SET jenis = '" + this.jenis + "', sewa = " + this.sewa + ", stok = " + this.stok + " WHERE mobil_id = '" 
                + this.mobil_id + "'" ;
        
        int affectedRow = mobilModel.query(queryString);
        return affectedRow;
    }
    
    public int deleteMobil(){
        Koneksi mobilModel = new Koneksi();
        String queryString = "DELETE FROM mobil WHERE mobil_id = '" + this.mobil_id + "'";
        
        int affectedRow = mobilModel.query(queryString);
        return affectedRow;
    }
    
    public void mobilMasuk(){
        Koneksi mobilModel = new Koneksi();
        this.stok += 1;
        
        mobilModel.query("UPDATE mobil SET stok = " + this.stok + " WHERE mobil_id = '" + this.mobil_id + "'");
    }
    
    public int mobilKeluar(int stok){
        Koneksi mobilModel = new Koneksi();
        if(stok == 0){
            return 0;
        }
        stok += -1;
        
        int affectedRow = mobilModel.query("UPDATE mobil SET stok = " + stok + " WHERE mobil_id = '" + this.mobil_id + "'");
        return affectedRow;
    }
    
    public ResultSet findByIdMobil(String id) {
        Koneksi mobilModel = new Koneksi();
        ResultSet rs = null;
        String queryString = "SELECT * FROM mobil WHERE mobil_id = '" + id + "'";

        rs = mobilModel.getData(queryString);
        return rs;
    }
}
