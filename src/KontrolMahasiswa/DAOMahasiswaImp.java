/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KontrolMahasiswa;

import DataBase.DBmahasiswa;
import Model.Mahasiswa;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


/**
 *
 * @author User
 */
public class DAOMahasiswaImp implements DAOMahasiswa {

    @Override
    public void save(Mahasiswa mahasiswa) {
        // simpan
        try{
            Connection con = (Connection) DBmahasiswa.getConnection();
            String sql = "INSERT INTO data_mahasiswa(npm, nama, pembimbing_akademik, program_pendidikan, fakultas, program_studi) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, mahasiswa.getNpm());
            ps.setString(2, mahasiswa.getNama());
            ps.setString(3, mahasiswa.getPembimbingAkademik());
            ps.setString(4, mahasiswa.getProgramPendidikan());
            ps.setString(5, mahasiswa.getFakultas());
            ps.setString(6, mahasiswa.getProgramStudi());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void update(Mahasiswa mahasiswa) {
    try {
        Connection con = (Connection) DBmahasiswa.getConnection();

        String sql = "UPDATE data_mahasiswa SET nama=?, pembimbing_akademik=?, program_pendidikan=?, fakultas=?, program_studi=? WHERE npm=?";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        
        ps.setString(1, mahasiswa.getNama());
        ps.setString(2, mahasiswa.getPembimbingAkademik());
        ps.setString(3, mahasiswa.getProgramPendidikan());
        ps.setString(4, mahasiswa.getFakultas());
        ps.setString(5, mahasiswa.getProgramStudi());
        ps.setInt(6, mahasiswa.getNpm());
        
        int rowsUpdated = ps.executeUpdate();
        
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada data yang diupdate!");
        }
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Tidak berhasil update!");
    }
}


    @Override
    public void delete(Mahasiswa mahasiswa) {
        try {
            Connection con = (Connection) DBmahasiswa.getConnection();
            String sql = "delete from data_mahasiswa where npm=?";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, mahasiswa.getNpm());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menghapus data!");
        }
    }

    @Override
    public Mahasiswa get(int npm) {
        Mahasiswa ms = new Mahasiswa();
        try {
            Connection con = (Connection) DBmahasiswa.getConnection();
            String sql = "SELECT *  FROM data_mahasiswa WHERE npm=?";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, npm);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ms.setNpm(rs.getInt("npm"));
                ms.setNama(rs.getString("nama"));
                ms.setPembimbingAkademik(rs.getString("pembimbing_akademik"));
                ms.setProgramPendidikan(rs.getString("program_pendidikan"));
                ms.setFakultas(rs.getString("fakultas"));
                ms.setProgramStudi(rs.getString("program_studi"));
            }else{
                JOptionPane.showMessageDialog(null, "NPM tidak ditemukan!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "NPM tidak ditemukan!");
        }
        return ms;
    }

    @Override
    public List<Mahasiswa> list() {
        List <Mahasiswa> list = new ArrayList <Mahasiswa>();
        
        try {
            Connection con = (Connection) DBmahasiswa.getConnection();
            String sql = "SELECT * FROM data_mahasiswa";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Mahasiswa ms = new Mahasiswa();
                ms.setNpm(rs.getInt("npm"));
                ms.setNama(rs.getString("nama"));
                ms.setPembimbingAkademik(rs.getString("pembimbing_akademik"));
                ms.setProgramPendidikan(rs.getString("program_pendidikan"));
                ms.setFakultas(rs.getString("fakultas"));
                ms.setProgramStudi(rs.getString("program_studi"));
                
                list.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
    
}
