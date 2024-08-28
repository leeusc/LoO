public abstract class Animal implements  Alive{

    String name;
    int age;
    String food;
    String gender;
    boolean alive;

    abstract String printSound();

    public Animal(){

    }
    public Animal( String name,int age,String food,String gender,boolean alive ) {
        this.name = name;
        this.age = age;
        this.food = food;
        this.gender = gender;
        this.alive = alive;
    }


    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge( int age ) {
        this.age = age;
    }

    public String getFood() {
        return food;
    }

    public void setFood( String food ) {
        this.food = food;
    }

    public String getGender() {
        return gender;
    }

    public void setGender( String gender ) {
        this.gender = gender;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void isAlive( int n ) {

        if (n == DEAD) {
           // System.out.println ("The animal is dead :(");
            alive = false;
        } else if (n == ALIVE) {
            //System.out.println ("The animal is alive :)");
            alive = true;
        }
    }

    @Override
    public String toString() {
        return "Animal: " +
                "name = " + name + '\'' +
                ", age = " + age +
                ", food = " + food + '\'' +
                ", gender = " + gender + '\'' +
                ", alive = " + alive +
                ", sound = " + printSound ();
    }
}
