package gov.nasa.marsrobot.model;

import java.io.Serializable;

public class Robot implements Serializable {

    private static final long serialVersionUID = 1L;

    public Robot() {
    }

    public Robot(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    private String name;

    private Position position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Robot{");
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
