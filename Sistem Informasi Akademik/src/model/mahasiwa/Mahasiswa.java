package model.mahasiwa;

import model.User;

public abstract class Mahasiswa extends User {

    String NIM;
    String jurusan;

    public Mahasiswa( String NIM,String jurusan ) {
        this.NIM = NIM;
        this.jurusan = jurusan;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM( String NIM ) {
        this.NIM = NIM;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan( String jurusan ) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {

        String s = String.format ("NIM: %s\nJurusan: %s\n", getNIM (), getJurusan ());
        return super.toString () + s;
    }
}
