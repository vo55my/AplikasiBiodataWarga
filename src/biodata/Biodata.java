/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

/**
 *
 * @author HD-PC
 */

public class Biodata {
    private String id;
    private String nama;
    private String nomor_hp;
    private String jenis_kelamin;
    private String alamat;
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNomorHP(String nomor_hp) {
        this.nomor_hp = nomor_hp;
    }
    
    public String getNomorHP() {
        return nomor_hp;
    }
    
    public void setJenisKelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
    
    public String getJenisKelamin() {
        return jenis_kelamin;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getAlamat() {
        return alamat;
    }
}
