import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ChapterTest {

    private static String VALID_CHAPTER_NAME = "The first chapter";
    private static int VALID_CHAPTER_NUMBER = 1;
    private static Chapter VALID_PARENT_CHAPTER = mock(Chapter.class);

    /**
     * @verifies set correct parameters
     * @see Chapter#Chapter(String, int, Chapter)
     */
    @Test
    public void Chapter_shouldSetCorrectParameters() throws Exception {
        Chapter sut = new Chapter(VALID_CHAPTER_NAME, VALID_CHAPTER_NUMBER, VALID_PARENT_CHAPTER);

        assertEquals(sut.getChapterName(), VALID_CHAPTER_NAME);
        assertEquals(sut.getChapterNumber(), VALID_CHAPTER_NUMBER);
        assertEquals(sut.getParentChapter(), VALID_PARENT_CHAPTER);
    }

    /**
     * @verifies throw IllegalArgumentException when name is null
     * @see Chapter#Chapter(String, int, Chapter)
     */
    @Test
    public void Chapter_shouldThrowIllegalArgumentExceptionWhenNameIsNull() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
           new Chapter(null, VALID_CHAPTER_NUMBER, VALID_PARENT_CHAPTER);
        });
    }

    /**
     * @verifies throw IllegalArgumentException when chapter number is less than 0
     * @see Chapter#Chapter(String, int, Chapter)
     */
    @Test
    public void Chapter_shouldThrowIllegalArgumentExceptionWhenChapterNumberIsLessThan0() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
           new Chapter(VALID_CHAPTER_NAME, -1, VALID_PARENT_CHAPTER);
        });
    }

    /**
     * @verifies show that chapters with same name and number are logically equal
     * @see Chapter#Chapter(String, int, Chapter)
     */
    @Test
    public void Chapter_shouldShowThatChaptersWithSameNameAndNumberAreLogicallyEqual() throws Exception {
        Chapter c1 = new Chapter(VALID_CHAPTER_NAME, VALID_CHAPTER_NUMBER, VALID_PARENT_CHAPTER);
        Chapter c2 = new Chapter(VALID_CHAPTER_NAME, VALID_CHAPTER_NUMBER, VALID_PARENT_CHAPTER);

        assertEquals(c1, c2);
        assertThat(c1).hasSameHashCodeAs(c2);
    }

    /**
     * @verifies show that parent chapter contains subchapters if any
     * @see Chapter#Chapter(String, int, Chapter)
     */
    @Test
    public void Chapter_shouldShowThatParentChapterContainsSubchaptersIfAny() throws Exception {
        Chapter sut = new Chapter(VALID_CHAPTER_NAME, VALID_CHAPTER_NUMBER, VALID_PARENT_CHAPTER);

        assertThat(VALID_PARENT_CHAPTER.getSubChapters()).contains(sut);
    }
}