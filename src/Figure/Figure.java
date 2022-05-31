package Figure;

public abstract class Figure {
    private int x,y;
    private FigureType type;

    /**
     * Figure Constructor
     * @param x
     * @param y
     * @param type
     */
    public Figure(int x,int y,FigureType type) {
        setX(x);
        setY(y);
        setType(type);
    }

    /**
     * set X
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set Y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * set Type
     * @param type
     */
    public void setType(FigureType type) {
        this.type = type;
    }

    /**
     * get X
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * get Y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * get Type
     * @return type
     */
    public FigureType getType() {
        return type;
    }
}
