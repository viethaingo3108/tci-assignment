import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class MemberTest {

    /**
     * @verifies add player score to a member
     * @see Member#addScore(PlayerScore)
     */
    @Test
    public void addScore_shouldAddPlayerScoreToAMember() throws Exception {
        Member sut = new Member("Hai Ngo");
        PlayerScore playerScore = mock(PlayerScore.class);

        sut.addScore(playerScore);

        assertTrue(sut.getPlayerScores().contains(playerScore));
    }

    /**
     * @verifies return a set of player scores
     * @see Member#getPlayerScores()
     */
    @Test
    public void getPlayerScores_shouldReturnASetOfPlayerScores() throws Exception {
        Member sut = new Member("Hai Ngo");
        PlayerScore playerScore = mock(PlayerScore.class);

        sut.addScore(playerScore);

        assertTrue(sut.getPlayerScores().contains(playerScore));
    }
}
