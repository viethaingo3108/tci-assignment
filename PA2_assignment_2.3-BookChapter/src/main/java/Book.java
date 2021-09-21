import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private String bookName;
    private String author;

    private List<Chapter> chapters;

    /**
     *
     * @param bookName is name of the book
     * @param author is the book's author name
     * @should throw IllegalArgumentException when name is null
     * @should throw IllegalArgumentException when author is null
     * @should show that books with same name and author are logically equal
     * @should set correct name
     * @should set correct author
     */
    public Book(String bookName, String author) throws IllegalArgumentException{
        if(bookName == null){
            throw new IllegalArgumentException("Name of the book cannot be null");
        }
        if(author == null){
            throw new IllegalArgumentException("Author name cannot be null");
        }
        this.bookName = bookName;
        this.author = author;
        this.chapters = new ArrayList<>();
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

    public String getBookName() {
        return this.bookName;
    }
}
