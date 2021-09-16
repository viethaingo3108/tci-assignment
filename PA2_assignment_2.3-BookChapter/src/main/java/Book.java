import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private String bookName;
    private String author;

    private List<Chapter> chapters = new ArrayList<>();
    private int nrOfChapters = chapters.size();

    /**
     *
     * @param bookName is name of the book
     * @param author is the book's author name
     * @param nrOfChapters is the number of chapters in a book
     * @should throw IllegalArgumentException when name is null
     * @should throw IllegalArgumentException when author is null
     * @should consists of zero or more Chapters
     */
    public Book(String bookName, String author, int nrOfChapters) throws IllegalArgumentException{
        if(bookName == null){
            throw new IllegalArgumentException("Name of the book cannot be null");
        }
        if(author == null){
            throw new IllegalArgumentException("Author name cannot be null");
        }
        if(nrOfChapters < 0){
            throw new IllegalArgumentException("Book must consists of zero or more Chapters");
        }
        this.bookName = bookName;
        this.author = author;
        this.nrOfChapters = nrOfChapters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return bookName.equals(book.bookName) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, author);
    }
}
