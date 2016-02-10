import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ericweidman on 2/10/16.
 */
public class SaveState {
    public static Game game = new Game();

    public static void saveGameInfo() throws IOException {
        JsonSerializer save = new JsonSerializer();
        String json = save.serialize(game);
        File file = new File("gameinfo.json");
        FileWriter fw = new FileWriter(file);
        fw.write(json);
        fw.close();
        System.out.println("File saved!");
    }

    public static Game loadGameInfo() throws FileNotFoundException {
        File file = new File("gameinfo.json");
        Scanner s = new Scanner(file);
        s.useDelimiter("\\Z");
        String contents = s.next();

        JsonParser p = new JsonParser();
        return p.parse(contents, Game.class);

    }
}
