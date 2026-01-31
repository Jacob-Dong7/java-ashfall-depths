import java.util.Scanner; 
import java.util.ArrayList;
public class player {
    private static final Scanner scnr = new Scanner(System.in);

    public String userName() {
        String name;
        System.out.println("Cold stone presses against your back as you wake.\n The air is thick with fog and ash, biting at your lungs. Ruins loom around you—old, broken, and abandoned.");
        System.out.println("Your head throbs. Your past is gone. Whatever you were before, the world has already forgotten it.");
        System.out.println("At your side lies a worn journal, its pages empty. On the first page, someone has written:");
        System.out.println("“Only the named are remembered.”");
        System.out.println("If you are to survive what comes next, the world must know what to call you.");

        while (true) {
        System.out.println("What is your name?");

        name = scnr.nextLine();

        if (name.isBlank()) {
            System.out.println("Please enter a name");
            scnr.nextLine();
            continue;
        }

        System.out.print("Your name is ");
        System.out.println(name);
        return name;
    }

    }
    public int health(int health) {

        return health;
    }

    public void damage() {

    }

    public void inventory(ArrayList<ArrayList<String>> userInventory) {
        ArrayList<String> itemOne = new ArrayList<>();
        itemOne.add("Health Potion");
        itemOne.add("2");

        ArrayList<String> itemTwo = new ArrayList<>();
        itemTwo.add("Strength Potion");
        itemTwo.add("2");

        userInventory.add(itemOne);
        userInventory.add(itemTwo);

    }


}
