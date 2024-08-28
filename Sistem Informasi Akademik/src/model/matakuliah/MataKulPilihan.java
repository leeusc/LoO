package model.matakuliah;

public class MataKulPilihan extends MataKuliah {

    private int limit = 0;

    public MataKulPilihan( String kode,int sks,String nama, int limit ) {
        super (kode,sks,nama);
        this.limit = limit;
    }

    public int getLimit() {
        if (limit < 11)
            return limit;
        return 0;
    }

    public void setLimit( int limit ) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return super.toString () +
                ", limit: " + limit ;
    }
}
