package delicious.zombies;
import delicious.zombies.blocks.*;
public class Map
{
    protected int width, height;
    protected Block[][] blocks;

    public Map(int width, int height)
    {
        this.width = width;
        this.height = height;

        blocks = new Block[width][height];

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1)
                    blocks[x][y] = new Block('#');
                else
                    blocks[x][y] = new Block(' ');
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                sb.append(blocks[x][y].getChar());
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    public Block getBlock(int x, int y)
    {
        return blocks[x][y];
    }

    // ============ Accessors =============
    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
