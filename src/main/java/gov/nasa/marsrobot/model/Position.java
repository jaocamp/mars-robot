package gov.nasa.marsrobot.model;

import gov.nasa.marsrobot.domain.Orientation;

import java.io.Serializable;

public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer x;

    private Integer y;

    private Orientation orientation;

    public Position() {
    }

    public Position(Integer x, Integer y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void advanceX() {
        this.x++;
    }

    public void backX() {
        this.x--;
    }

    public void advanceY() {
        this.y++;
    }

    public void backY() {
        this.y--;
    }

    public void addX() {
        this.x++;
    }

    public void removeX() {
        this.x--;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("(");
        sb.append(x).append(", ");
        sb.append(y).append(", ");
        sb.append(orientation.getValue()).append(")");
        return sb.toString();
    }
}
