import java.util.*;

/**
 * Game is responsible for keeping track of whose turn it is to play and the player scores during a game.
 * When a game is finished, the winning member is also added.
 */
public class Game {

    private Date date;
    private Member[] members;

    /**
     * Constructor for Game Object
     * @param date
     * @param members
     * @should set date when game is created
     * @should change turn automatically after score entered
     */
    public Game(Date date, Member[] members){
        this.date = date;
        this.members = members;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Method to keep track of which member has the turn to play
     * @return current player
     * @should keep track of player turn
     */
    public Member getCurrentPlayer(){
        for(int i=0; i<members.length; i++){
            return members[i];
        }
        return null;
    }
}
