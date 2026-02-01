import java.util.ArrayList;
import java.util.Scanner;
public class game {
    public void startGame() {
        boolean checker = false;
        Scanner scnr = new Scanner(System.in);
        int playerPosition = 0;
        int userAction;
        String name;
        ArrayList<ArrayList<String>> inventory = new ArrayList<>();
        

        int[] playerData;
        playerData = new int[2];

        //player data, 0 is health and 1 is player damage
        playerData[0] = 100;
        playerData[1] = 5;

        world newWorld = new world();
        room[] dungeon = newWorld.setWorld();

        player newPlayer = new player();
        name = newPlayer.userName();
        newPlayer.inventory(inventory);

        while (true) {
            if (checker == false) {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println(dungeon[playerPosition].description);
            if (dungeon[playerPosition].boss == true) {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("At the center of the chamber stands a massive figure half-embedded in stone.");
                System.out.println("Rusted chains drag behind it as it slowly pulls itself free.");
                System.out.println("Ash falls from its body like snow.");
                System.out.println("Two hollow eyes ignite with dull orange fire.");
                System.out.println("The air grows heavy.");
                System.out.println("The exit is behind it.");
                System.out.println("The Warden has awakened.");
                
                System.out.println("A grinding voice echoes through the chamber...");
                System.out.println("\"" + newPlayer.name + "...\"");
                System.out.println("\"Your name will be the next this place forgets...\"");

                System.out.println("------------------------------------------------------------------------------------------");
            } else if (dungeon[playerPosition].enemyCount > 1) {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.print("You see ");
                System.out.print(dungeon[playerPosition].enemyCount);
                System.out.println(" Ogors");
                System.out.println("------------------------------------------------------------------------------------------");
            } else if (dungeon[playerPosition].enemyCount == 1) {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("You see an Ogor");
                System.out.println("------------------------------------------------------------------------------------------");
            } else if (dungeon[playerPosition].enemyCount == 0) {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("Everything seems clear...");
                System.out.println("------------------------------------------------------------------------------------------");
            }

            checker = true;
        }
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("What do you do? : 1 (Go forward) 2 (Attack enemy) 3 (Search for items) 4 (Check Inventory) 5 (Check Status)");
            System.out.println("------------------------------------------------------------------------------------------");
            userAction = scnr.nextInt();
            if (userAction == -1) {
                return;
            } else if (userAction == 1) {
                if (dungeon[playerPosition].enemyCount > 0) {
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("There are enemies around, you cannot proceed further...");
                    System.out.println("------------------------------------------------------------------------------------------");
                } else if (playerPosition == dungeon.length - 1 && dungeon[playerPosition].boss == false){
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println(
                        "The Warden lies shattered behind you.\n" +
                        "The gate stands open.\n" +
                        "Cold air gives way to warm sunlight.\n" +
                        "You step out of the ruins.\n" +
                        "You survived."
                    );
                    System.out.println(
                        "You leave the ruins behind.\n" +
                        "Stone gives way to grass. Cold air turns warm.\n" +
                        "Dawn breaks over the horizon.\n" +
                        "\n" +
                        "The dungeon grows silent, as if you were never there.\n" +
                        "\n" +
                        "But your name remains.\n" +
                        newPlayer.name + ".\n" +
                        "\n" +
                        "You survived.\n" +
                        "THE END."
                    );
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.exit(0);
                } else if (playerPosition == dungeon.length - 1 && dungeon[playerPosition].boss == true) {
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println(
                        "You step toward the gate.\n" +
                        "The Warden drags its chains across the stone and blocks your path.\n" +
                        "The ground trembles.\n" +
                        "\"None leave alive.\""
                    );
                    System.out.println("------------------------------------------------------------------------------------------");
                    continue;
                } else {
                    ++playerPosition;
                    checker = false;
                    continue;
                }
            } else if (userAction == 2){
                if (dungeon[playerPosition].boss == true) {
                    newWorld.attackBoss(dungeon, playerPosition, newPlayer, inventory);
                } else if (dungeon[playerPosition].enemyCount == 0) {
                    System.out.println("There are no enemies to attack...");
                    continue;
                } else {
                    newWorld.attack(dungeon, playerPosition, newPlayer, inventory);
                }
            } else if (userAction == 3) {
                newWorld.searchItem(dungeon, playerPosition, inventory);
            } else if (userAction == 4) {
                newPlayer.checkInventory(inventory);
            } else if (userAction == 5) {
                newPlayer.checkHealth();
            }
        }
    }
}
