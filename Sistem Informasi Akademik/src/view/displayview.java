package view;

import model.Staff.DosenHonorer;
import model.Staff.DosenTetap;
import model.Staff.Karyawan;
import model.mahasiwa.Doktor;
import model.mahasiwa.Master;
import model.mahasiwa.Sarjana;

import javax.swing.*;

// display data
public class displayview {

    public void displaySarjana( Sarjana sarjana ){
        String s = sarjana.toString ();

        JOptionPane.showMessageDialog (null, s, "Sarjana", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayMaster( Master master){
        String s = master.toString ();

        JOptionPane.showMessageDialog (null, s, "Master", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayDoktor( Doktor doktor ){
        String s = doktor.toString ();

        JOptionPane.showMessageDialog (null, s, "Doktor", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayDosenTetap( DosenTetap dosenTetap ){
        String s = dosenTetap.toString ();

        JOptionPane.showMessageDialog (null, s, "Dosen Tetap", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayDosenHonorer( DosenHonorer dosenHonorer ){
        String s = dosenHonorer.toString ();

        JOptionPane.showMessageDialog (null, s, "DosenHonorer", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayKaryawan( Karyawan karyawan){
        String s = karyawan.toString ();

        JOptionPane.showMessageDialog (null, s, "Karyawan", JOptionPane.INFORMATION_MESSAGE);
    }

}
