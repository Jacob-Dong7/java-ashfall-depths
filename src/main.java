//Created by Jacob Dong
//Ashfall Depths
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int input;
        Scanner scnr = new Scanner(System.in);
        System.out.println("AshFall Depths");
        System.out.println("--------------");
        System.out.println("1 (Start Game)");
        System.out.println("-1 (Quit)");

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