import javax.swing.*;

public class Main {

    public static void main( String[] args ) {
        Patient[] dataPatient = new Patient[50];

        JOptionPane.showMessageDialog (null, "Data Patient of St Maria Hospital", "St Maria Hospital", JOptionPane.INFORMATION_MESSAGE);
        int i = 0;
        while (i < dataPatient.length){
            // iterate to 50 patients
            int choice = getValidChoice ();

            switch (choice){
                case 1:
                    Patient input = new Patient ();
                    // Inout Name
                    String name;
                    do {
                        name = JOptionPane.showInputDialog(null, "Name: ");
                        if (name == null) {
                            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to cancel the input?", "Confirmation", JOptionPane.YES_NO_OPTION);
                            if (confirm == JOptionPane.YES_OPTION) {
                                return; // or break, depending on context
                            }
                        }
                    } while (name == null || name.trim().isEmpty());
                    input.setName (name);

                    // Input BPJS, either yes or no
                    int response = JOptionPane.showConfirmDialog (null,
                            "Do you have BPJS?", "Health Insurance (BPJS)",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    input.setBPJS (response == JOptionPane.YES_NO_OPTION);

                    // Input Room & cost per individual
                    input.chooseRoom ();
                    input.getRoomCost ();

                    // input BPJS & cost per individual
                    input.chooseTreatment ();
                    input.getTreatmentCost ();

                    // assign id #001 for first patient
                    input.getId (i);

                    // fill data in array with input, for example [0] = input, [1] input
                    // each patient has their own data with no interfering
                    dataPatient[i] = input;

                    // next patient
                    i++;
                    break;
                case 2: // find patient's data with designated id;
                String searchData = JOptionPane.showInputDialog (null,"Find data");
                for ( Patient patient: dataPatient){ // iterate through "dataPatient" in order to find id from previous patient that has been registered
                    if (patient != null && patient.getId ().equals (searchData)){
                        patient.displayData ();
                    }
                }
                    break;
                case 3: // hospital income
                    for ( Patient patient: dataPatient ){
                        if (patient != null){
                            patient.displayIncome ();
                        }
                    }
                    break;
                case 4:
                    // treatment categories
                    for ( Patient patient : dataPatient ){
                            if (patient  != null){
                                patient.displayCategory ();
                            }
                    }
                    break;
                case 5:
                    // Exit Confirmation
                    int confirmExit = JOptionPane.showConfirmDialog (null,
                            "Are you sure? All data would be lost permanently if you leaving",
                            "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confirmExit == JOptionPane.YES_OPTION){
                        i = dataPatient.length;
                    }
                    break;
            }
        }
    }

    private static int getValidChoice() {
        int choice = -1;
        while (choice < 1 || choice > 5) {
            try {
                String input = JOptionPane.showInputDialog(null, "Enter your choice:\n1. Register\n2. Search Patient\n3. Hospital Income\n4. Treatment Categories\n5. Exit");
                if (input == null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Do you want to exit the program?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        System.exit(0); // Exit the program
                    }
                } else {
                    choice = Integer.parseInt(input);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return choice;
    }
}
