import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class GameTest {

    private static Date VALID_DATE = new Date();
    private Member member1 = mock(Member.class);
    private Member member2 = mock(Member.class);
    private Member[] VALID_MEMBERS = new Member[]{member1, member2};

    private Game sut = new Game(VALID_DATE, VALID_MEMBERS);

    /**
     * @verifies set date when game is created
     * @see Game#Game(Date,Member[])
     */
    @Test
    public void Game_shouldSetDateWhenGameIsCreated() throws Exception {
        assertEquals(sut.getDate(), VALID_DATE);
    }

    /**
     * @verifies keep track of player turn
     * @see Game#getCurrentPlayer()
     */
    @Test
    public void getCurrentPlayer_shouldKeepTrackOfPlayerTurn() throws Exception {
        assertNotNull(sut.getCurrentPlayer());
    }


}
