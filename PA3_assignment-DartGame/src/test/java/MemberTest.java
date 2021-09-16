import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class MemberTest {

    private Member sut = new Member("Hai Ngo");
    private PlayerScore playerScore = mock(PlayerScore.class);

    /**
     * @verifies add player score to a member
     * @see Member#addScore(PlayerScore)
     */
    @Test
    public void addScore_shouldAddPlayerScoreToAMember() throws Exception {
        sut.addScore(playerScore);

        assertTrue(sut.getPlayerScores().contains(playerScore));
    }

    /**
     * @verifies return a set of player scores
     * @see Member#getPlayerScores()
     */
    @Test
    public void getPlayerScores_shouldReturnASetOfPlayerScores() throws Exception {
        sut.addScore(playerScore);

        assertTrue(sut.getPlayerScores().contains(playerScore));
    }

    /**
     * @verifies return a member's name
     * @see Member#getMemberName()
     */
    @Test
    public void getMemberName_shouldReturnAMembersName() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }
}
