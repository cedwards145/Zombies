package delicious.zombies.entities;

import delicious.zombies.Map;
import delicious.zombies.Util.Enums;
import delicious.zombies.Util.Point;
import delicious.zombies.World;
import delicious.zombies.blocks.Block;

public abstract class Entity
{
    public Point position;
    protected int maxHP, currentHP;
    protected int damage;

    public Entity()
    {
        position = new Point();
        maxHP = 10;
        currentHP = maxHP;
    }

    public boolean isAlive()
    {
        return currentHP > 0;
    }

    public void attack(Entity other)
    {
        other.currentHP -= damage;
    }

    public abstract void update(World world);

    public abstract char getChar();

    public void moveTo(Map map, Point newPosition)
    {
        try {
            // Add entity to new block
            // May throw out of bounds exception
            Block block = map.getBlock(newPosition.x, newPosition.y);
            if (!block.isPassable)
                return;
            block.entities.add(this);

            // Remove entity from current block
            block = map.getBlock(position.x, position.y);
            block.entities.remove(this);

            // Update position
            position = newPosition;
        } catch (IndexOutOfBoundsException ex)
        {
            // Do nothing, stops entities moving out of the map
        }
    }
}
