package delicious.zombies;

import delicious.zombies.Util.StaticRandom;
import delicious.zombies.entities.Survivor;
import delicious.zombies.entities.Zombie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static spark.Spark.*;

public class Program
{
    private static World world;

    public static void main(String[] args) throws InterruptedException
    {
        homeHTML = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Assets/main.html"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                homeHTML += line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (homeHTML == null || homeHTML == "")
                homeHTML = "ERROR";
        }

        // Set up routes
        get("/map", (req, res) -> renderBoard());
        get("/reset", (req, res) -> reset());
        get("/", (req, res) -> home());

        init();
    }

    private static void init()
    {
        // Initialize simulation
        Map map = null;
        try {
            map = new Map("Assets/map.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        world = new World(map);

        Zombie zombie;

        int numZombies = 10;
        for (int count = 0; count < 15; count++)
        {
            zombie = new Zombie();
            world.addEntity(zombie,
                    StaticRandom.random.nextInt(map.width),
                    StaticRandom.random.nextInt(map.height));
        }
        Survivor dan = new Survivor("Dan");
        world.addEntity(dan, 5, 3);

        world.run();
    }

    private static String homeHTML;
    private static String home()
    {

        return homeHTML;
    }

    private static String renderBoard()
    {
        return world.getHTML();
    }

    private static String reset()
    {
        world.stop();
        init();

        return "";
    }
}
