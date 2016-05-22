package delicious.zombies.entities;
import delicious.zombies.Map;
import delicious.zombies.Util.Enums;
import delicious.zombies.Util.Point;
import delicious.zombies.World;
import delicious.zombies.blocks.Block;

import java.util.Random;

public class Zombie extends Entity
{
    private Survivor target = null;
    public Zombie()
    {
        super();
        damage = 2;
    }

    @Override
    public char getChar() {
        if (isAlive())
            return 'z';
        else
            return 'x';
    }

    public void update(World world)
    {
        if (!isAlive())
            return;

        if (target == null) {
            for (Entity e : world.entities) {
                if (e.getClass().equals(Survivor.class)) {
                    Survivor s = (Survivor)e;
                    if (s.isAlive()) {
                        target = s;
                        break;
                    }
                }
            }
        }
        if (target != null && position.distance(target.position) < 10) {
            if (!target.isAlive())
                target = null;
            else if (position.distance(target.position) <= 1)
                attack(target);
            else
                moveTo(world.map, position.move(position.directionToPoint(target.position)));
        }
        else {
            wander(world.map);
        }
    }

    private void wander(Map map)
    {
        Random r = new Random();
        Enums.Direction direction = Enums.Direction.values()[r.nextInt(4)];

        Point newPosition = position.move(direction);
        moveTo(map, newPosition);
    }
}
