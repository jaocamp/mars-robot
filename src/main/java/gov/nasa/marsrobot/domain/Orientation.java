package gov.nasa.marsrobot.domain;

public enum Orientation {

    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private String value;

    Orientation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}