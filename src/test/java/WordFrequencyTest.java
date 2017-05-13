import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class WordFrequencyTest {
    @Test
    public void should_handle_blank_text() {
        // given
        String text = "";

        // when
        String result = WordFrequency.handle(text);

        // then
        assertThat(result).isEqualTo("");
    }
    
    @Test
    public void should_handle_one_word_text() {
        // given
        String text = "one";

        // when
        String result = WordFrequency.handle(text);

        // then
        assertThat(result).isEqualTo("one 1");
    }

    @Test
    public void should_handle_two_different_words_text() {
        // given
        String text = "one two";

        // when
        String result = WordFrequency.handle(text);

        // then
        assertThat(result).isEqualTo("one 1\r\ntwo 1");
    }

    @Test
    public void should_handle_duplicated_words_text() {
        // given
        String text = "one two one";

        // when
        String result = WordFrequency.handle(text);

        // then
        assertThat(result).isEqualTo("one 2\r\ntwo 1");
    }

    @Test
    public void should_handle_the_order() {
        // given
        String text = "one two two";

        // when
        String result = WordFrequency.handle(text);

        // then
        assertThat(result).isEqualTo("two 2\r\none 1");
    }
}
