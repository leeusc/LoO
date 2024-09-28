package model.matakuliah;

public class MatKulPilihan extends MataKuliah{

    private int limit;

    public MatKulPilihan(String kode, int sks, String nama, int limit) {
        super(kode, sks, nama);
        this.limit = limit;
    }


    public static MatKulPilihan DSA(){
        return new MatKulPilihan("DSA01", 3, "DSA", 10);
    }

    public static MatKulPilihan OOP(){
        return new MatKulPilihan("OOP01", 3, "OOP", 20);
    }
















    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
