import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    /**
     * @verifies set date when game is created
     * @see Game#Game()
     */
    @Test
    public void Game_shouldSetDateWhenGameIsCreated() throws Exception {
        Game game = new Game(VALID_DATE);

        assertEquals(game.getDate(), VALID_DATE);
    }
}
