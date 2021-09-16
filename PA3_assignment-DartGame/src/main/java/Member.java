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
     * Add score to a player/member
     * @param playerScore score of a player
     * @should add player score to a member
     */
    public void addScore(PlayerScore playerScore){
        playerScores.add(playerScore);
    }

    /**
     * Return a set of player scores
     * @return playerScores
     * @should return a set of player scores
     */
    public Set<PlayerScore> getPlayerScores() {
        return playerScores;
    }

    /**
     * Return player name
     * @return player name
     * @should return a member's name
     */
    public String getMemberName() {
        return memberName;
    }
}
