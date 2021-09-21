import java.util.List;
import java.util.Objects;

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
    public Chapter(String chapterName, int chapterNumber, Chapter parent) throws IllegalArgumentException{
        if(chapterName == null){
            throw new IllegalArgumentException("Chapter must have a name");
        }
        if(chapterNumber < 0){
            throw new IllegalArgumentException("Chapter number must be a positive number");
        }
        this.chapterName = chapterName;
        this.chapterNumber = chapterNumber;
        this.parent = parent;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public int getChapterNumber() {
        return this.chapterNumber;
    }

    public Chapter getParentChapter() {
        return this.parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chapter)) return false;
        Chapter chapter = (Chapter) o;
        return chapterNumber == chapter.chapterNumber && chapterName.equals(chapter.chapterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chapterName, chapterNumber);
    }
}
