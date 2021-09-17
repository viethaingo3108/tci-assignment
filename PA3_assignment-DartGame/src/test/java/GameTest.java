import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    /**
     * @verifies keep track of player turn
     * @see Game#getCurrentPlayer()
     */
    @Test
    public void getCurrentPlayer_shouldKeepTrackOfPlayerTurn() throws Exception {
        Game game = new Game(VALID_DATE);

        assertNotNull(game.getCurrentPlayer());
    }
}
