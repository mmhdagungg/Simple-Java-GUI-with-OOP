/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * klass ini digunakan untuk mengambil data dari mahasiswa.
 * 
 * @param paramater int npm pada setNpm digunakan untuk mengambil nilai npm dan setting nilai
 * @return sebgai hasil dari setNpm
 */
public class Mahasiswa {
    private int npm;
    private String nama;
    private String pembimbingAkademik;
    private String programPendidikan;
    private String fakultas;
    private String programStudi;

    public int getNpm() {
        return npm;
    }

    public void setNpm(int npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPembimbingAkademik() {
        return pembimbingAkademik;
    }

    public void setPembimbingAkademik(String pembimbingAkademik) {
        this.pembimbingAkademik = pembimbingAkademik;
    }

    public String getProgramPendidikan() {
        return programPendidikan;
    }

    public void setProgramPendidikan(String programPendidikan) {
        this.programPendidikan = programPendidikan;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }
}
