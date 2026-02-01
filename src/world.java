import java.util.ArrayList;
public class world {
    
    public room[] setWorld() {
        room[] dungeon = new room[] {
            new room("Broken Stairs", "You stand at the top of a crumbling stone staircase. \nSeveral steps have collapsed into darkness below. \nCold air rises from the depths, brushing your skin like icy fingers. Each step down looks unstable.", 0, 0, false, false, true, false ),
            new room("Wet Corridor", "A narrow corridor stretches ahead, walls slick with moisture. \nWater drips steadily from the ceiling, echoing in the confined space. \nYour boots splash through shallow puddles with every step.", 1, 1, false, false, false, false ),
            new room("Rust Cells", "Rows of iron prison cells line both sides of the hall. \nThe bars are eaten through with rust and hang half-open. Chains clink softly as if something moved them moments ago. \nThe air smells of decay.", 2, 2, false, false, false, false ),
            new room("Forgotten Shrine", "A small stone chamber opens before you. \nA cracked statue kneels before a ruined altar. \nWax from old candles has fused to the floor. Someone once prayed here… not long ago. The silence feels watched.", 3, 1, false, false, false, false  ),
            new room("Collapsed Passage", "The hallway ahead has partially caved in. \nBroken beams and chunks of rock block parts of the path. \nDust floats in the air, glowing faintly in the dim light. You must squeeze through carefully.", 4, 3, false, false, false, true  ),
            new room("Ash Crossing", "Grey ash coats the floor like snow. \nYour footprints are the only marks disturbing it. \nBurned torches hang dead on the walls. Something here was consumed by fire long ago.", 5, 1, false, false, false, false  ),
            new room("Deep Pit", "The floor suddenly drops away into a wide black pit. \nYou hear faint movement far below. \nLoose stones tumble from the edge and vanish without a sound. One wrong step would be fatal.", 6, 6, false, false , true, true ),
            new room("Sun Gate", "Ahead stands a massive stone doorway split open. \nWarm golden light spills through the cracks, chasing away the cold darkness behind you. Fresh air flows in. This might be the way out.", 7, 0, true, true , false, false ),
        };
        return dungeon;
    }

    public void searchItem(room[] dungeon, int pos, ArrayList<ArrayList<String>> inventory) {
        String currentAmount, newAmountString;
        int newAmount;
        if (dungeon[pos].heal == true && dungeon[pos].strength == true) {
            System.out.println("You found a potion of healing");
            System.out.println("You found a potion of strength");
            currentAmount = inventory.get(0).get(1);
            newAmount = Integer.parseInt(currentAmount) + 1;
            newAmountString = String.valueOf(newAmount);
            inventory.get(0).set(1, newAmountString);

            currentAmount = inventory.get(1).get(1);
            newAmount = Integer.parseInt(currentAmount) + 1;
            newAmountString = String.valueOf(newAmount);
            inventory.get(1).set(1, newAmountString);
        } else if (dungeon[pos].heal == true && dungeon[pos].strength == false) {
            System.out.println("You found a potion of healing");
            currentAmount = inventory.get(0).get(1);
            newAmount = Integer.parseInt(currentAmount) + 1;
            newAmountString = String.valueOf(newAmount);
            inventory.get(0).set(1, newAmountString);
        } else if (dungeon[pos].heal == false && dungeon[pos].strength == true) {
            System.out.println("You found a potion of strength");
            currentAmount = inventory.get(1).get(1);
            newAmount = Integer.parseInt(currentAmount) + 1;
            newAmountString = String.valueOf(newAmount);
            inventory.get(1).set(1, newAmountString);
        } else {
            System.out.println("You found nothing");
        }
    }
}
