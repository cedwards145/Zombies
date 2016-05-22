package delicious.zombies.Util;

public class Point
{
    public int x, y;
    public Point()
    {
        x = 0;
        y = 0;
    }

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point move(Enums.Direction direction)
    {
        switch (direction)
        {
            case Up:
                return new Point(x, y - 1);
            case Down:
                return new Point(x, y + 1);
            case Left:
                return new Point(x - 1, y);
            case Right:
                return new Point(x + 1, y);
            default:
                return new Point(x, y);
        }
    }

    public float distance(Point other)
    {
        return (float)Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    public Enums.Direction directionToPoint(Point other)
    {
        int xDelta = other.x - x;
        int yDelta = other.y - y;

        int absXDelta = Math.abs(xDelta);
        int absYDelta = Math.abs(yDelta);

        if (absXDelta > absYDelta)
        {
            if (x > 0)
                return Enums.Direction.Up;
            else if (x < 0)
                return Enums.Direction.Left;
        }
        else
        {
            if (y > 0)
                return Enums.Direction.Down;
            else if (y < 0)
                return Enums.Direction.Up;
        }
        return Enums.Direction.None;
    }
}
