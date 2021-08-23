package pieces;

public enum Pieces {
    BISHOP (3);
    private final int value;


    Pieces(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
