package gov.nasa.marsrobot.domain;

public enum Orientation {

    NORTH("N", 0, 1) {
        @Override
        public Orientation left() {
            return WEST;
        }

        @Override
        public Orientation right() {
            return EAST;
        }
    },
    SOUTH("S", 0, -1) {
        @Override
        public Orientation left() {
            return EAST;
        }

        @Override
        public Orientation right() {
            return WEST;
        }
    },
    EAST("E", 1, 0) {
        @Override
        public Orientation left() {
            return NORTH;
        }

        @Override
        public Orientation right() {
            return SOUTH;
        }
    },
    WEST("W", -1, 0) {
        @Override
        public Orientation left() {
            return SOUTH;
        }

        @Override
        public Orientation right() {
            return NORTH;
        }
    };

    private String value;

    public abstract Orientation left();
    public abstract Orientation right();

    private Integer quantityToincreaseInXAxis;
    private Integer quantityToincreaseInYAxis;

    Orientation(String value, Integer quantityToincreaseInXAxis, Integer quantityToincreaseInYAxis) {
        this.value = value;
        this.quantityToincreaseInXAxis = quantityToincreaseInXAxis;
        this.quantityToincreaseInYAxis = quantityToincreaseInYAxis;
    }

    public String getValue() {
        return value;
    }

    public Integer getQuantityToincreaseInXAxis() {
        return quantityToincreaseInXAxis;
    }

    public Integer getQuantityToincreaseInYAxis() {
        return quantityToincreaseInYAxis;
    }
}