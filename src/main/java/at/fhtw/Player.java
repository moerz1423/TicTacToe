package at.fhtw;

// Class Player represents a player in the game. It has a marker (X or O).
class Player {
    private char marker;

    public Player(char marker) {
        this.marker = marker;
    }

    public char getMarker() {
        return marker;
    }
}
