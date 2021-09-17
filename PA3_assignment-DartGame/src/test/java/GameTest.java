import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private static Date VALID_DATE = new Date();

    /**
     * @verifies set date when game is created
     * @see Game#Game(Date)
     */
    @Test
    public void Game_shouldSetDateWhenGameIsCreated() throws Exception {
        Game game = new Game(VALID_DATE);

        assertEquals(game.getDate(), VALID_DATE);
    }
}
