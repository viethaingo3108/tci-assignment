import java.util.Date;

/**
 * Game is responsible for keeping track of whose turn it is to play and the player scores during a game.
 * When a game is finished, the winning member is also added.
 */
public class Game {

    private Date date;

    /**
     * @should set date when game is created
     * @param date
     */
    public Game(Date date){
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
