package model.mahasiwa;


public class Doktor extends Mahasiswa{

    String juduldisertasi;
    int sidang1, sidang2, sidang3;

    public Doktor( String NIM,String jurusan ) {
        super (NIM,jurusan);
    }

    public String getJuduldisertasi() {
        return juduldisertasi;
    }

    public void setJuduldisertasi( String juduldisertasi ) {
        this.juduldisertasi = juduldisertasi;
    }

    public int getSidang1() {
        return sidang1;
    }

    public void setSidang1( int sidang1 ) {
        this.sidang1 = sidang1;
    }

    public int getSidang2() {
        return sidang2;
    }

    public void setSidang2( int sidang2 ) {
        this.sidang2 = sidang2;
    }

    public int getSidang3() {
        return sidang3;
    }

    public void setSidang3( int sidang3 ) {
        this.sidang3 = sidang3;
    }

    @Override
    public String toString() {
        return super.toString () +
                "Judul disertasi: " + getJuduldisertasi () + "\n" +
                "Sidang 1: " + getSidang1 () + "\n" +
                "Sidang 2: " + getSidang2 () + "\n" +
                "Sidang 3: " + getSidang3 () + "\n";
    }
}
