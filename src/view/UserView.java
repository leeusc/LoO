package view;

import model.Mahasiswa.Mahasiswa;
import model.User;

import javax.swing.*;

public class UserView {

    public void Portal(){
        JOptionPane.showMessageDialog(null, "You're in SIA's Portal");
    }

    public int showMainMenu() {
        String[] options = {
                "1. View Data",
                "2. View Nilai Akhir",
                "3. View Rata-Rata Nilai Akhir",
                "4. View Tidak Lulus",
                "5. View Presensi",
                "6. View Jam Mengajar",
                "7. View Gaji"
        };

        int choice = JOptionPane.showOptionDialog(
                null,
                "Select an option",
                "SIA Portal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );
        return choice;
    }

    public void viewData(User user){
         JOptionPane.showMessageDialog(null, user.printData(), "PrintData", JOptionPane.INFORMATION_MESSAGE);
    }

    public void viewNA(User user, String kode){
        JOptionPane.showMessageDialog(null, "Nilai Akhir: " + user.getNama() + ", " + kode + ": " + user.print_NilaiAkhir(kode), "NilaiAkhir Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
    }
    public void viewNA_Dokter(User user){
        JOptionPane.showMessageDialog(null, "Nilai Akhir Dokter: " + user.getNama() + " adalah: " + user.print_NilaiAkhir_Dokter());
    }

    public String Doktor_or_Mahasiswa(){
        String[] choices = {"Sarjana", "Master", "Dokter"};


        int choice = JOptionPane.showOptionDialog(null, "Choose", "c", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, choices, choices[0]);

        if (choice >= 0){
            return choices[choice];
        }
        return null;
    }

    public void viewRataRata(String kode){
        JOptionPane.showMessageDialog(null, Mahasiswa.printrata_rata(kode), "Nilai Rata - Rata Semua Mahasiswa Di satu Pelajaran", JOptionPane.INFORMATION_MESSAGE);
    }

    public void viewRataRata_Dokter(){
        JOptionPane.showMessageDialog(null, "Nilai Rata-Rata dari semua dokter adalah: " + Mahasiswa.print_ratarata_dokter());
    }

    public void viewTidakLulus(String kode){
        JOptionPane.showMessageDialog(null, Mahasiswa.printTidakLulus(kode));
    }

    public void viewTidakLulus_Dokter(){
        JOptionPane.showMessageDialog(null, Mahasiswa.printTidakLulus_Dokter());
    }

    public void viewPresensi(User user){
        JOptionPane.showMessageDialog(null, user.printPresensi());
    }

    public void ViewJamNgajar(User user){
        JOptionPane.showMessageDialog(null, user.printNgajar(), "Total Jam Mengajar", JOptionPane.INFORMATION_MESSAGE);
    }

    public void viewGaji(User user){
        JOptionPane.showMessageDialog(null, user.getGaji());
    }

    public static void main(String[] args) {

    }

    public String inputName(){
        return JOptionPane.showInputDialog(null, "Input Name");
    }

    public String inputNIM(){
        return JOptionPane.showInputDialog(null, "Input NIM");
    }

    public String inputNIK(){
        return JOptionPane.showInputDialog(null, "Input NIK");
    }

    public String inputKodeMK(){
        return JOptionPane.showInputDialog(null, "Input KodeMK");
    }

    public void userIsNotFound(){
        JOptionPane.showMessageDialog(null, "User is not found", "404", JOptionPane.WARNING_MESSAGE);
    }
}
