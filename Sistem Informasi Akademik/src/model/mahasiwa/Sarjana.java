package model.mahasiwa;

import model.matakuliah.MatkulAmbil;

import java.util.ArrayList;

public class Sarjana extends Mahasiswa{

    ArrayList<MatkulAmbil> matkulAmbils = new ArrayList <> ();


    public Sarjana( String NIM,String jurusan ) {
        super (NIM,jurusan);
    }

    public ArrayList <MatkulAmbil> getMatkulAmbils() {
        return matkulAmbils;
    }

    public void setMatkulAmbils( ArrayList <MatkulAmbil> matkulAmbils ) {
        this.matkulAmbils = matkulAmbils;
    }

    @Override
    public String toString() {
        return super.toString ()+ "MataKuliah: " +
                getMatkulAmbils ();
    }
}
