package model.mahasiwa;


import model.matakuliah.MatkulAmbil;

import java.util.ArrayList;

public class Master extends Mahasiswa {

    ArrayList<MatkulAmbil> matkulAmbils;
    String judulTesis;

    public Master( String NIM,String jurusan ) {
        super (NIM,jurusan);
    }


    public ArrayList <MatkulAmbil> getMatkulAmbils() {
        return matkulAmbils;
    }

    public void setMatkulAmbils( ArrayList <MatkulAmbil> matkulAmbils ) {
        this.matkulAmbils = matkulAmbils;
    }

    public String getJudulTesis() {
        return judulTesis;
    }

    public void setJudulTesis( String judulTesis ) {
        this.judulTesis = judulTesis;
    }

    @Override
    public String toString() {
        return super.toString () +
                "JudulTesis: " + judulTesis + "\n" +
                "Matakuliah : " + matkulAmbils ;

    }
}
