import java.util.ArrayList;

public class game {
    public void startGame() {
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
        

        }
    }
}
