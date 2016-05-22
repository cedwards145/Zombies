package delicious.zombies.entities;

import delicious.zombies.Map;
import delicious.zombies.World;

public class Survivor extends Entity
{
    private String name;
    public boolean isAlive = true;

    public Survivor(String name)
    {
        super();
        this.name = name;
    }

    public void update(World world)
    {
        isAlive = false;
    }

    public char getChar()
    {
        if (isAlive)
            return Character.toUpperCase(name.charAt(0));
        else
            return 'X';
    }
}
