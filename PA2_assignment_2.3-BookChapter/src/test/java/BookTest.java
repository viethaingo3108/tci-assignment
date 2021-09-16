import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BookTest {

    private List<Chapter> chapters = new ArrayList<>();

    private String VALID_BOOK_NAME = "Book 1";
    private String VALID_AUTHOR = "Hai Ngo";
    private int VALID_NR_OF_CHAPTERS = chapters.size();

    /**
     * @verifies throw IllegalArgumentException when name is null
     * @see Book#Book(String, String, int)
     */
    @Test
    public void Book_shouldThrowIllegalArgumentExceptionWhenNameIsNull() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->
        {
            new Book(null, VALID_AUTHOR, VALID_NR_OF_CHAPTERS);
        });
    }

    /**
     * @verifies throw IllegalArgumentException when author is null
     * @see Book#Book(String, String, int)
     */
    @Test
    public void Book_shouldThrowIllegalArgumentExceptionWhenAuthorIsNull() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
           new Book(VALID_BOOK_NAME, null, VALID_NR_OF_CHAPTERS);
        });
    }

    /**
     * @verifies consists of zero or more Chapters
     * @see Book#Book(String, String, int)
     */
    @Test
    public void Book_shouldConsistsOfZeroOrMoreChapters() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
            new Book(VALID_BOOK_NAME, VALID_AUTHOR, -1);
        });
    }

    @Test
    public void Book_withSameNameAndAuthorAreLogicallyEqual(){
        Book bookA = new Book(VALID_BOOK_NAME, VALID_AUTHOR, VALID_NR_OF_CHAPTERS);
        Book bookB = new Book(VALID_BOOK_NAME, VALID_AUTHOR, VALID_NR_OF_CHAPTERS);

        assertThat(bookA).isEqualTo(bookB);
        assertThat(bookA).hasSameHashCodeAs(bookB);
    }
}
