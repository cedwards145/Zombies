package delicious.zombies.entities;
import delicious.zombies.Map;
import delicious.zombies.Util.Enums;
import delicious.zombies.Util.Point;
import delicious.zombies.World;
import delicious.zombies.blocks.Block;

import java.util.Random;

public class Zombie extends Entity
{
    public Zombie()
    {
        super();
    }

    @Override
    public char getChar() {
        return 'z';
    }

    public void update(World world)
    {
        Map map = world.map;
        wander(map);
    }

    private void wander(Map map)
    {
        Random r = new Random();
        Enums.Direction direction = Enums.Direction.values()[r.nextInt(4)];

        Point newPosition = position.move(direction);
        moveTo(map, newPosition);
    }
}
