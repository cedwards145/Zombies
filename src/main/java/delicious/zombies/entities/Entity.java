package delicious.zombies.entities;

import delicious.zombies.Map;
import delicious.zombies.Util.Point;
import delicious.zombies.World;
import delicious.zombies.blocks.Block;

public abstract class Entity
{
    public Point position;

    public Entity()
    {
        position = new Point();
    }

    public abstract void update(World world);

    public abstract char getChar();

    public void moveTo(Map map, Point newPosition)
    {
        try {
            // Add entity to new block
            // May throw out of bounds exception
            Block block = map.getBlock(newPosition.x, newPosition.y);
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
