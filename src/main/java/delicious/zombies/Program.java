package delicious.zombies;

import delicious.zombies.entities.Survivor;
import delicious.zombies.entities.Zombie;

public class Program
{
    public static void main(String[] args) throws InterruptedException {
        Map map = new Map(5, 5);
        World world = new World(map);

        Zombie zombie = new Zombie();
        world.addEntity(zombie, 2, 1);

        Survivor dan = new Survivor("Dan");
        world.addEntity(dan, 4, 4);

        System.out.println(world.print());

        while (true)
        {
            world.update();
            System.out.println(world.print());
            Thread.sleep(1000);
        }
    }
}
