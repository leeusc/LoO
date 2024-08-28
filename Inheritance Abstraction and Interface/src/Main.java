import java.util.ArrayList;

public class Main {

    public static void main( String[] args ) {

        Animal dog = new Dog ();
        dog.setName ("Doggy");
        dog.setAge (5);
        dog.setGender ("male");
        dog.setFood ("Dog food");
        dog.isAlive (Alive.ALIVE); // 0 for dead 1 for alive

        Animal cat = new Cat();
        cat.setName ("Kitty");
        cat.setAge (2);
        cat.setGender ("female");
        cat.setFood ("Cat food");
        cat.isAlive (Alive.DEAD); // 0 for dead 1 for alive

        Animal duck = new Duck ();
        duck.setName ("Donald Duck");
        duck.setAge (1);
        duck.setGender ("male");
        duck.setFood ("seed");
        duck.isAlive (Alive.ALIVE); // 0 for dead 1 for alive

        Animal horse = new Horse ();
        horse.setName ("Horsy");
        horse.setAge (2);
        horse.setGender ("male");
        horse.setFood ("Grass");
        horse.isAlive (Alive.DEAD); // 0 for dead 1 for alive


        ArrayList<Animal> animal = new ArrayList <> ();
        animal.add (dog);
        animal.add (cat);
        animal.add (duck);
        animal.add (horse);

        for ( Animal a : animal ){
            System.out.println (a);
        }
    }
}
