import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BookTest {

    private String VALID_BOOK_NAME = "Book 1";
    private String VALID_AUTHOR = "Hai Ngo";

    /**
     * @verifies throw IllegalArgumentException when name is null
     * @see Book#Book(String, String)
     */
    @Test
    public void Book_shouldThrowIllegalArgumentExceptionWhenNameIsNull() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->
        {
            new Book(null, VALID_AUTHOR);
        });
    }

    /**
     * @verifies throw IllegalArgumentException when author is null
     * @see Book#Book(String, String)
     */
    @Test
    public void Book_shouldThrowIllegalArgumentExceptionWhenAuthorIsNull() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
           new Book(VALID_BOOK_NAME, null);
        });
    }

    /**
     * @verifies show that books with same name and author are logically equal
     * @see Book#Book(String, String)
     */
    @Test
    public void Book_shouldShowThatBooksWithSameNameAndAuthorAreLogicallyEqual() throws Exception {
        Book bookA = new Book(VALID_BOOK_NAME, VALID_AUTHOR);
        Book bookB = new Book(VALID_BOOK_NAME, VALID_AUTHOR);

        assertThat(bookA).isEqualTo(bookB);
        assertThat(bookA).hasSameHashCodeAs(bookB);
    }

    /**
     * @verifies set correct name
     * @see Book#Book(String, String)
     */
    @Test
    public void Book_shouldSetCorrectName() throws Exception {
        Book sut = new Book(VALID_BOOK_NAME, VALID_AUTHOR);

        assertEquals(sut.getBookName(), VALID_BOOK_NAME);
    }
}
