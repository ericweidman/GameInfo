import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ericweidman on 2/10/16.
 */
public class GameInfo {
    public static Game game = new Game();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        try {
            game = SaveState.loadGameInfo();
        } catch (Exception e) {
            System.out.println("Sorry, that didn't load!");
            System.out.println("Please add a game!");
        }

        System.out.println(game.name);
        System.out.println(game.genre);
        System.out.println(game.engine);
        System.out.println(game.developer);
        System.out.println(game.publisher);

        System.out.println("Would you like to edit this game? [y/n]");

        if (scanner.nextLine().equalsIgnoreCase("y")) {

            System.out.println("Please enter a game name.");
            String gameName = scanner.nextLine();
            game.name = gameName;
            System.out.println("Please enter the game genre.");
            String gameGenre = scanner.nextLine();
            game.genre = gameGenre;
            System.out.println("Please enter the game engine.");
            String gameEngine = scanner.nextLine();
            game.engine = gameEngine;
            System.out.println("Please enter the game Developer");
            String gameDev = scanner.nextLine();
            game.developer = gameDev;
            System.out.println("Please enter the game Publisher");
            String gamePub = scanner.nextLine();
            game.publisher = gamePub;
        } else {
            System.out.println(game.name);
            System.out.println(game.genre);
            System.out.println(game.engine);
            System.out.println(game.developer);
            System.out.println(game.publisher);

        }

        System.out.println("Would you like to save this game information?[y/n]");

        if (scanner.nextLine().equalsIgnoreCase("y")) {
            SaveState.saveGameInfo();
        } else {
            System.out.println("Thanks for nothing!");
        }
    }
}