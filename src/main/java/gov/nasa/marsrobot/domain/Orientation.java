package gov.nasa.marsrobot.domain;

import gov.nasa.marsrobot.model.Position;

public enum Orientation {

    NORTH("N") {
        @Override
        public Orientation left() {
            return WEST;
        }

        @Override
        public Orientation right() {
            return EAST;
        }

        @Override
        public void move(Position position) {
            position.advanceY();
        }
    },
    SOUTH("S") {
        @Override
        public Orientation left() {
            return EAST;
        }

        @Override
        public Orientation right() {
            return WEST;
        }

        @Override
        public void move(Position position) {
            position.backY();
        }
    },
    EAST("E") {
        @Override
        public Orientation left() {
            return NORTH;
        }

        @Override
        public Orientation right() {
            return SOUTH;
        }

        @Override
        public void move(Position position) {
            position.advanceX();
        }
    },
    WEST("W") {
        @Override
        public Orientation left() {
            return SOUTH;
        }

        @Override
        public Orientation right() {
            return NORTH;
        }

        @Override
        public void move(Position position) {
            position.backY();
        }
    };

    private String value;

    public abstract Orientation left();
    public abstract Orientation right();
    public abstract void move(Position position);

    Orientation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}