package delicious.zombies;
import delicious.zombies.blocks.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Map
{
    protected int width, height;
    protected Block[][] blocks;

    public Map(String filename) throws IOException {
        width = 48;
        height = 13;
        FileReader reader = new FileReader(filename);

        blocks = new Block[width][height];
        Block block;
        char character;
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                character = (char)reader.read();
                // skip new lines
                if (character == '\n')
                    character = (char)reader.read();

                if (character == '#') {
                    block = new Block('#');
                    block.isPassable = false;
                    block.style = "wall";
                }
                else {
                    block = new Block(' ');
                    block.isPassable = true;
                    block.style = "grass";
                }
                blocks[x][y] = block;
            }
        }
    }

    public Map(int width, int height)
    {
        this.width = width;
        this.height = height;

        blocks = new Block[width][height];
        Block block;
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
                    block = new Block('#');
                    block.isPassable = false;
                }
                else {
                    block = new Block(' ');
                    block.isPassable = true;
                }
                blocks[x][y] = block;
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
