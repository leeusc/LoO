import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Patient {

    String name;
    Rooms[] room = new Rooms[3];
    TreatMent[] treatment = new TreatMent[5];
    boolean BPJS;
    String id;
    int totalRoomCost;
    int totalTreatmentCost;
    int roomCost = 0;
    int treatmentCost = 0;
    static Map<String, Integer> mapping = new HashMap <> ();
    Rooms selectedRoom;

    // empty constructor, take input without constraints
    public Patient(){

    }

    // method to patients input their name
    public void setName( String name ) {
        this.name = name;
    }


    // method to input their rooms up to 3 type of room, *number is fixed, but it's editable
    public void chooseRoom() {
        Map<String, Rooms> map = new HashMap <> ();
        //I(50), II(25), III(10), VIP(70),
        // use map: key is user input and  value is room itself that has room's name and room's price
        map.put ("I", new Rooms ("I", 50 ));
        map.put ("II", new Rooms ("II", 25));
        map.put ("III", new Rooms ("III", 10));
        map.put ("VIP", new Rooms ("VIP", 70));

        for (int j = 0; j < room.length; j++ ){
            String inputRoom = JOptionPane.showInputDialog (null, "Choose type of Room: (I / II / III / VIP)");
            Rooms selectedRoom = map.get (inputRoom);
            if (selectedRoom != null){
                setRoom (j, selectedRoom);
            } else {
                JOptionPane.showMessageDialog (null, "Invalid room type! Please choose available options");
                j--;
            }
        }
    }

    //method to input treatment
    public void chooseTreatment() {
        Map<String, TreatMent> map = new HashMap <> ();
        //I(50), II(25), III(10), VIP(70),
        map.put ("1", new TreatMent ("Surgery", 1000 ));
        map.put ("2", new TreatMent ("USG", 300));
        map.put ("3", new TreatMent ("X-Ray", 250));
        map.put ("4", new TreatMent ("Blood Test", 5));
        map.put ("5", new TreatMent ("Vaccine", 100));

        String[] treatmentOptions = {
                "1. Surgery ($1000)",
                "2. USG ($300)",
                "3. X-Ray ($250)",
                "4. Vaccine ($100)",
                "5. Blood Test ($20)"
        };

        for ( int j = 0; j < treatment.length; j++ ){
            String inputTrmnt = (String) JOptionPane.showInputDialog(
                    null,
                    "Select your treatment:",
                    "Treatment Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    treatmentOptions,
                    treatmentOptions[0]
            );

            if (inputTrmnt == null){
                break; // patient press cancel
            }

            String input = inputTrmnt.substring (0, 1);
            TreatMent treatMent = map.get (input);

            if (treatMent != null) {
                setTreatment (j , treatMent);
            } else if (!map.containsKey (inputTrmnt)){
                JOptionPane.showMessageDialog (null, "Invalid Treatment, Please choose available treatments");
                j--;
            }
        }
    }

    public void setTreatment(int index, TreatMent name){
        this.treatment[index] = name;
    }


    public void setRoom(int index, Rooms name){
        this.room[index] = name;
    }


    // method to input bpjs
    public boolean isBPJS() {
        return BPJS;
    }

    public void setBPJS( boolean BPJS ) {
        this.BPJS = BPJS;
    }

    // each patient has their own id
    public void getId( int i){
        String default_tag = "#";
        int a = i + 1;
        if (a < 10){
            default_tag += "00" + a ;
        } else if (i < 100) {
            default_tag += "0" + a ;
        } else {
            default_tag += a;
        }
        id = default_tag;
    }

    public String getId() {
        return this.id;
    }

    public void displayData (){
        String message = "Name: " + this.name + "\n" +
                "BPJS: " + this.BPJS + "\n" +
                "Room: " + Arrays.deepToString (this.room) + "\n" +
                "Treatment: " + Arrays.deepToString (this.treatment) + "\n" +
                "Total Room Cost: " + this.roomCost + "\n" +
                "Total Treatment Cost: " + this.treatmentCost;
        JOptionPane.showMessageDialog(null, message, "Patient Information", JOptionPane.INFORMATION_MESSAGE);
    }


    public void getRoomCost(){
        roomCost = 0;
        for ( Rooms rooms : room ) {
            if (rooms != null) {
                roomCost += rooms.getRoomCost ();
            }
        }
        if (isBPJS ()){
            roomCost = 0;
        }

        totalRoomCost += roomCost;
    }

    public void getTreatmentCost(){
        treatmentCost = 0;
        for ( TreatMent treatMent : treatment ) {
            if (treatMent != null) {
                treatmentCost += treatMent.getTreatmentCost ();
            }
        }

        totalTreatmentCost += treatmentCost;
    }

    public void displayIncome(){
        int total = totalRoomCost + treatmentCost;

        // Format the values for readability
        String formattedTotal = String.format("%,d", total);
        String formattedRoomCost = String.format("%,d", totalRoomCost);
        String formattedTreatmentCost = String.format("%,d", treatmentCost);

        // Display a detailed breakdown of the income
        String message = String.format("""
                        Hospital Income Breakdown:
                        Room Costs: %s
                        Treatment Costs: %s
                        Total Hospital Income: %s""",
                formattedRoomCost, formattedTreatmentCost, formattedTotal
        );

        JOptionPane.showMessageDialog (null, message, "Hospital Income", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void category(){
        mapping.put ("Surgery", 0);
        mapping.put ("USG", 0);
        mapping.put ("X-Ray", 0);
        mapping.put ("Vaccine", 0);
        mapping.put ("Blood Test", 0);
    }

    public void displayCategory() {
        category ();
        for ( TreatMent treatMent : treatment ){
            if (treatMent != null){
                String treatmentName = treatMent.getTreatmentName ();
                mapping.put (treatmentName, mapping.get (treatmentName) + 1);
            }
        }

        StringBuilder sb = new StringBuilder ("Treatment Category\n");
        for ( Map.Entry<String, Integer> entry : mapping.entrySet () ){
            sb.append (entry.getKey ()).append (": ").append (entry.getValue ()).append (".\n");
        }
        JOptionPane.showMessageDialog (null, sb.toString (), "Patient Treatment", JOptionPane.INFORMATION_MESSAGE);
    }







}
