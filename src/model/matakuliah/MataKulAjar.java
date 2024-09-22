package model.matakuliah;

import model.presensi.PresensiStaff;
import model.presensi.Status;

import java.util.List;

public class MataKulAjar {

    private MataKuliah mataKuliah;
    private List<PresensiStaff> presensiStaffs;

    public MataKulAjar(MataKuliah mataKuliah, List<PresensiStaff> presensiStaffs) {
        this.mataKuliah = mataKuliah;
        this.presensiStaffs = presensiStaffs;
    }

    public int getUnits(){
        int units = 0;

        for (PresensiStaff ps : getPresensiStaffs()){
            if (ps.getStatus().equals(Status.HADIR)){
                units +=1;
            }
        }
        return units;
    }

    // helper method jam mengajar for Dosen
    public double totalPresensi(){

        double teachHours = 0;

        for (PresensiStaff ps : getPresensiStaffs()){
            if (ps.getStatus().equals(Status.HADIR)){
                teachHours += ps.getJam();
            }
        }
        return teachHours;
    }












    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(getMataKuliah()).append("\nPresensi: ").append(getPresensiStaffs()).append("\n");
        return sb.toString();
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public List<PresensiStaff> getPresensiStaffs() {
        return presensiStaffs;
    }

    public void setPresensiStaffs(List<PresensiStaff> presensiStaffs) {
        this.presensiStaffs = presensiStaffs;
    }
}
