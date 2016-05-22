package delicious.zombies.entities;

import delicious.zombies.Map;
import delicious.zombies.Util.Enums;
import delicious.zombies.Util.Point;
import delicious.zombies.World;

import java.util.Random;

public class Survivor extends Entity
{
    private String name;

    public Survivor(String name)
    {
        super();
        this.name = name;
        damage = 4;
    }

    public void update(World world)
    {
        if (!isAlive())
            return;

        for (Entity e : world.entities) {
            if (e.getClass().equals(Zombie.class)) {
                if (e.isAlive() && position.distance(e.position) <= 6) {
                    attack(e);
                    return;
                }
            }
        }

        wander(world.map);
    }

    public char getChar()
    {
        if (isAlive())
            return Character.toUpperCase(name.charAt(0));
        else
            return 'x';
    }

    private void wander(Map map)
    {
        Random r = new Random();
        Enums.Direction direction = Enums.Direction.values()[r.nextInt(4)];

        Point newPosition = position.move(direction);
        moveTo(map, newPosition);
    }
}
