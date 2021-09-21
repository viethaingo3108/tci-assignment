import java.util.List;

public class Chapter {
    private String chapterName;
    private int chapterNumber;
    private Chapter parent;
    private List<Chapter> subChapters;

    /**
     * Constructor for Chapter
     * @param chapterName
     * @param chapterNumber
     * @param parent
     * @should set correct parameters
     * @should throw IllegalArgumentException when name is null
     * @should throw IllegalArgumentException when chapter number is less than 0
     * @should show that chapters with same name and number are logically equal
     */
    public Chapter(String chapterName, int chapterNumber, Chapter parent) {
        this.chapterName = chapterName;
        this.chapterNumber = chapterNumber;
        this.parent = parent;
    }
}
