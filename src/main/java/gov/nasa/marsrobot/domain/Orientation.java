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
    private Integer quantityToIncreaseInXAxis;
    private Integer quantityToIncreaseInYAxis;

    public abstract Orientation left();
    public abstract Orientation right();

    Orientation(String value, Integer quantityToIncreaseInXAxis, Integer quantityToIncreaseInYAxis) {
        this.value = value;
        this.quantityToIncreaseInXAxis = quantityToIncreaseInXAxis;
        this.quantityToIncreaseInYAxis = quantityToIncreaseInYAxis;
    }

    public String getValue() {
        return value;
    }

    public Integer getQuantityToIncreaseInXAxis() {
        return quantityToIncreaseInXAxis;
    }

    public Integer getQuantityToIncreaseInYAxis() {
        return quantityToIncreaseInYAxis;
    }
}