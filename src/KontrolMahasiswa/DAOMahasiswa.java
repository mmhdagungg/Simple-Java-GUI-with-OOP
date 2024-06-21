/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package KontrolMahasiswa;

import Model.Mahasiswa;
import java.util.List;

/**
 *
 * mendefinisikan interface crud
 */

public interface DAOMahasiswa {
    
    /**
     * 
     * @param mahasiswa yang akan disimpan 
     */
    
    public void save(Mahasiswa mahasiswa);
    public void update(Mahasiswa mahasiswa);
    public void delete(Mahasiswa mahasiswa);
    public Mahasiswa get(int npm);
    public List <Mahasiswa> list();
}
