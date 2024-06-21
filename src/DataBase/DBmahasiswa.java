/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

/**
 *
 * kelas ini berfungsi untuk mengelola database
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DBmahasiswa {
    
    /**
     * @return koneksi database
     * @throws sqlExepction ketika terjadi error saat membuka koneksi database
     */
    
    static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/infomahasiswa";
    static String uname = "root";
    static String pass = "";
    
    public static Connection getConnection() throws Exception{
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url,uname,pass);
        }
        return con;
    }
   
}
