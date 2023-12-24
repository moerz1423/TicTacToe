package at.fhtw;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testGetMarker() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }
}
