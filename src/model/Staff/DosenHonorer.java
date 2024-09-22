package model.Staff;

import model.matakuliah.MataKulAjar;

public class DosenHonorer extends Dosen{

    double perSKS;

    public DosenHonorer(String nik, String Departemen, double perSKS) {
        super(nik, Departemen);
        this.perSKS = perSKS;
    }


    @Override
    public String printData() {

        StringBuilder sb = new StringBuilder("DOSEN HONORER\n");

        sb.append("NIK: ").append(getNik()).append("\n");

        sb.append("Nama: ").append(getNama()).append("\n");

        sb.append("Alamat: ").append(getAlamat()).append("\n");

        sb.append("TTL: ").append(getTtl()).append("\n");

        sb.append("Telepone: ").append(getTelepon()).append("\n");

        sb.append("Honorer per SKS: ").append(getPerSKS()).append("\n");

        sb.append("Departemen: ").append(getDepartemen()).append("\n");

        //sb.append("List of MatkulAjar: ").append(getMataKulAjars()).append("\n");

        return sb.toString();
    }


    // get salary of 'Dosen Honorer'
    public double getGaji(){
        int totalUnits = 0;
        for (MataKulAjar m : getMataKulAjars()){
            totalUnits += m.getUnits();
        }

        double hks = getPerSKS();

        // Gaji Dosen Honor : gaji = (unit * honorPerSKS)
        return Math.round(totalUnits * hks);
    }



























    public double getPerSKS() {
        return perSKS;
    }

    public void setPerSKS(double perSKS) {
        this.perSKS = perSKS;
    }
}
