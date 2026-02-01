//Created by Jacob Dong
//Ashfall Depths

//build code javac src/main.java src/player.java src/room.java src/world.java src/game.java
//run code java src/main.java
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int input;
        Scanner scnr = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("AshFall Depths");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1 (Start Game)");
        System.out.println("-1 (Quit)");
        System.out.println("------------------------------------------------------------------------------------------");

        input = scnr.nextInt();

        if (input == -1) {
            System.out.println("Exiting...");
            return;
        } else if (input == 1) {
            game newGame = new game();
            newGame.startGame();
        }
    }
    
}