package model.Staff;

public class DosenTetap extends Dosen{

    private double salary;

    public DosenTetap( String NIK ) {
        super (NIK);
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary( double salary ) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString () + "\nSalary: $" + getSalary ();
    }
}
