import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberTest {

    /**
     * @verifies add player score to a member
     * @see Member#addScore(PlayerScore)
     */
    @Test
    public void addScore_shouldAddPlayerScoreToAMember() throws Exception {
        Member sut = new Member("Hai Ngo");

        sut.addScore(playerScore);
        assertTrue(sut.getPlayerScores()).contains(playerScore);
    }
}
