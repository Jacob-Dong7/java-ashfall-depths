import java.util.ArrayList;
import java.util.Scanner;
public class game {
    public void startGame() {
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
            System.out.println(dungeon[playerPosition].description);
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("What do you do?: 1 (Go forward) 2 (Attack enemy) 3 (Search for items) 4 (Check Inventory) 5 (Check Status)");
            System.out.println("------------------------------------------------------------------------------------------");
            userAction = scnr.nextInt();
            if (userAction == -1) {
                return;
            } else if (userAction == 4) {
                newPlayer.checkInventory(inventory);
            }
        }
    }
}
