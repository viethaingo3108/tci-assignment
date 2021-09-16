import java.util.HashSet;
import java.util.Set;

/**
 * Member is responsible for keeping track of the name and number of members. It also manages all Playerscores of the member
 */

public class Member {

    private String memberName;
    private Set<PlayerScore> playerScores;

    public Member(String memberName) {
        this.memberName = memberName;
        this.playerScores = new HashSet<>();
    }

    /**
     *
     * @param playerScore score of a player
     * @should add player score to a member
     */
    public void addScore(PlayerScore playerScore){
        playerScores.add(playerScore);
    }

    public Set<PlayerScore> getPlayerScores() {
        return playerScores;
    }
}
