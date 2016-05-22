package delicious.zombies.blocks;

import delicious.zombies.entities.Entity;
import java.util.ArrayList;

public class Block
{
    private char displayCharacter;
    public ArrayList<Entity> entities;

    public Block(char displayCharacter)
    {
        this.displayCharacter = displayCharacter;
        entities = new ArrayList<Entity>();
    }

    public char getChar()
    {
        if (entities.isEmpty())
            return displayCharacter;
        else
            return entities.get(entities.size() - 1).getChar();
    }

    public  boolean isPassable()
    {
        return true;
    }

}
