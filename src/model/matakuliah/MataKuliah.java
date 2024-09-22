package model.matakuliah;

public class MataKuliah {

   private String kode;
   private int sks;
   private String nama;

    public MataKuliah(String kode, int sks, String nama) {
        this.kode = kode;
        this.sks = sks;
        this.nama = nama;
    }



    // all matakkuliah set to static as Subject don't change
    public static MataKuliah FurtherMath(){
       return new MataKuliah("FM01", 3, "Further Math");
   }

   public static MataKuliah AppliedMath(){
        return new MataKuliah("AP01", 3, "Applied Math");
   }

   public static MataKuliah Physics(){
        return new MataKuliah("PH01", 3, "Physics");
   }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MatKul: ").append("kode: " + getKode()).append(", sks: " + getSks()).append(", subject: " + getNama());
        return sb.toString();
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
