import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class world {
    private static final Scanner scnr = new Scanner(System.in);
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
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("You found a potion of healing");
            System.out.println("You found a potion of strength");
            System.out.println("------------------------------------------------------------------------------------------");
            currentAmount = inventory.get(0).get(1);
            newAmount = Integer.parseInt(currentAmount) + 1;
            newAmountString = String.valueOf(newAmount);
            inventory.get(0).set(1, newAmountString);

            currentAmount = inventory.get(1).get(1);
            newAmount = Integer.parseInt(currentAmount) + 1;
            newAmountString = String.valueOf(newAmount);
            inventory.get(1).set(1, newAmountString);

            dungeon[pos].heal = false;
            dungeon[pos].strength = false;
        } else if (dungeon[pos].heal == true && dungeon[pos].strength == false) {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("You found a potion of healing");
            System.out.println("------------------------------------------------------------------------------------------");
            currentAmount = inventory.get(0).get(1);
            newAmount = Integer.parseInt(currentAmount) + 1;
            newAmountString = String.valueOf(newAmount);
            inventory.get(0).set(1, newAmountString);
            dungeon[pos].heal = false;
        } else if (dungeon[pos].heal == false && dungeon[pos].strength == true) {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("You found a potion of strength");
            System.out.println("------------------------------------------------------------------------------------------");
            currentAmount = inventory.get(1).get(1);
            newAmount = Integer.parseInt(currentAmount) + 1;
            newAmountString = String.valueOf(newAmount);
            inventory.get(1).set(1, newAmountString);
            dungeon[pos].strength = false;
        } else {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("You found nothing...");
            System.out.println("------------------------------------------------------------------------------------------");
        }
    }

    public void attack(room[] dungeon, int pos, player newPlayer,  ArrayList<ArrayList<String>> inventory) {
        int enemyHealth = 100;
        int userAction;
        int attackChance, criticalChance;

        while (true) {
            if (enemyHealth <= 0) {
                System.out.println("You have slained an enemy");
                dungeon[pos].enemyCount -= 1;
                return;
            } else if (newPlayer.health <= 0) {
                System.out.println(
                    "Your strength fades.\n" +
                    "Your weapon falls from your grasp.\n" +
                    "Cold stone meets your cheek.\n" +
                    "Darkness closes in.\n" +
                    "You are forgotten..."
                );
                System.exit(0);
            }

            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("Combat : 1 (Swing Sword) 2 (Use potion of Healing) 3 (Use potion of Strength) 4 (Check Status)");
            System.out.println("------------------------------------------------------------------------------------------");
            userAction = scnr.nextInt();
            if (userAction == 1) {
                attackChance = (int) (Math.random() * 10);
                criticalChance = (int) (Math.random() * 10);

                //player have 80% hit chance
                if (attackChance > 1) {
                    if (criticalChance >= 7) {
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("You lunge forward with everything you have.");
                        System.out.println("Your blade sinks deep.");
                        System.out.println("The ogre howls in pain.");
                        System.out.println("------------------------------------------------------------------------------------------");
                        enemyHealth -= newPlayer.damage * 1.2;
                    } else {
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("You strike the ogre.");
                        System.out.println("Steel bites into flesh.");
                        System.out.println("------------------------------------------------------------------------------------------");
                        enemyHealth -= newPlayer.damage;
                    }

                    if (enemyHealth <= 0) {
                        System.out.println("Steel tears through flesh.");
                        System.out.println("A wet crunch..");
                        System.out.println("The ogre collapses in a heap of blood.");
                        dungeon[pos].enemyCount -= 1;
                        return;
                    }
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.print("Ogor Health: ");
                System.out.println(enemyHealth);
                System.out.println("------------------------------------------------------------------------------------------");
                } else {
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("You swing — too slow.");
                    System.out.println("The ogre steps aside.");
                    System.out.println("Your attack cuts only air.");
                    System.out.println("------------------------------------------------------------------------------------------");
                }
            } else if (userAction == 2) {
                newPlayer.heal(inventory);
            } else if (userAction == 3) {
                newPlayer.strength(inventory);
            } else if (userAction == 4) {
                newPlayer.checkHealth();
            }

            for (int i = 0; i < dungeon[pos].enemyCount; ++i) {
                attackChance = (int) (Math.random() * 10);
                //ogor has 60% chance of landing  a hit
                if (attackChance > 3) {
                    criticalChance = (int) (Math.random() * 10);
                    // enemy ogor has 20% chance of critical hit on player
                    if (criticalChance >= 8) {
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("The ogre roars and swings with brutal force.");
                        System.out.println("The impact crushes the air from your lungs.");
                        System.out.println("------------------------------------------------------------------------------------------");
                        newPlayer.takeDamage(40);
                        newPlayer.checkHealth();
                    } else {
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("The ogre's club slams into you.");
                        System.out.println("Pain shoots through your ribs.");
                        System.out.println("------------------------------------------------------------------------------------------");
                        newPlayer.takeDamage(10);
                        newPlayer.checkHealth();
                    }
                    
                } else {
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("The ogre swings wildly.");
                    System.out.println("You duck as the club smashes stone instead.");
                    System.out.println("------------------------------------------------------------------------------------------");
                }
            }
        }
    }
}
