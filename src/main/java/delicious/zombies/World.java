package delicious.zombies;

import delicious.zombies.Util.Point;
import delicious.zombies.blocks.Block;
import delicious.zombies.entities.Entity;

import java.util.ArrayList;

public class World
{
    public Map map;
    private ArrayList<Entity> entities;

    public World(Map map)
    {
        this.map = map;
        entities = new ArrayList<Entity>();
    }

    public void update()
    {
        for (Entity e : entities)
            e.update(this);
    }

    public String print()
    {
        StringBuilder sb = new StringBuilder();

        int mapWidth = map.getWidth();
        int mapHeight = map.getHeight();

        for (int y = 0; y < mapHeight; y++)
        {
            for (int x = 0; x < mapWidth; x++)
            {
                Block block = map.getBlock(x, y);
                sb.append(block.getChar());
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    public void addEntity(Entity e, int x, int y)
    {
        e.position = new Point(x, y);
        entities.add(e);
        // Also add entity to correct block
        map.getBlock(x, y).entities.add(e);
    }
}
