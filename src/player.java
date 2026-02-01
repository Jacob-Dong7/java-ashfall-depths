import java.util.Scanner; 
import java.util.ArrayList;
public class player {
    private static final Scanner scnr = new Scanner(System.in);
    int health = 100;
    int damage = 10;

    public String userName() {
        String name;
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Cold stone presses against your back as you wake.\nThe air is thick with fog and ash, biting at your lungs. Ruins loom around you—old, broken, and abandoned.");
        System.out.println("Your head throbs. Your past is gone. Whatever you were before, the world has already forgotten it.");
        System.out.println("At your side lies a worn journal, its pages empty. On the first page, someone has written:");
        System.out.println("'Only the named are remembered.'");
        System.out.println("If you are to survive what comes next, the world must know what to call you.");

        while (true) {
        System.out.println("What is your name?");

        System.out.println("------------------------------------------------------------------------------------------");
        name = scnr.nextLine();

        if (name.isBlank()) {
            System.out.println("Please enter a name");
            scnr.nextLine();
            continue;
        }

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("Your name is ");
        System.out.println(name);
        return name;
    }

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

    public void checkInventory(ArrayList<ArrayList<String>> userInventory) {
        int userAction;
        while (true) {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Inventory 1 (Use health potion) 2 (Use strength potion) -1 (Return):");
        for (int i = 0; i < userInventory.size(); ++i) {
                System.out.print(userInventory.get(i).get(0));
                System.out.print(" - ");
                System.out.println(userInventory.get(i).get(1));
        }
        System.out.println("------------------------------------------------------------------------------------------");

        userAction = scnr.nextInt();

        if (userAction == -1) {
            return;
        } else if (userAction == 1) {
            if (Integer.parseInt(userInventory.get(0).get(1)) > 0) {
                heal(userInventory);
            } else {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("You are out of healing potions");
                System.out.println("------------------------------------------------------------------------------------------");
            }

        } else if (userAction == 2) {
                if (Integer.parseInt(userInventory.get(1).get(1)) > 0) {
                strength(userInventory);
            } else {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("You are out of strength potions");
                System.out.println("------------------------------------------------------------------------------------------");
            }
        }
    }

}

    public void heal(ArrayList<ArrayList<String>> userInventory) {
        if (100 - health > 20) {
            health += 20;
        } else {
            health = 100;
        }
        String num = userInventory.get(0).get(1);
        int newNum = Integer.parseInt(num) - 1;
        String finalNum = String.valueOf(newNum);
        userInventory.get(0).set(1, finalNum);

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("Health: ");
        System.out.println(health);
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public void checkHealth() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("Health: ");
        System.out.println(health);
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public void strength(ArrayList<ArrayList<String>> userInventory) {
        String num = userInventory.get(1).get(1);
        int newNum = Integer.parseInt(num) - 1;
        String finalNum = String.valueOf(newNum);
        userInventory.get(1).set(1, finalNum);

        damage += 5;
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("Strength: ");
        System.out.println(damage);
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public void takeDamage(int damage) {
        health -= damage;
    }


}
