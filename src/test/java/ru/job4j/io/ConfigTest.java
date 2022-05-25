package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(nullValue()));
    }

    @Test
    public void whenPairWithCommentAndEmptyLines() {
        String path = "./data/pair_with_comment_and_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Andrey"));
        assertThat(config.value("surname"), is("Plakhotin"));
        assertThat(config.value("profession"), is(nullValue()));
    }

    @Test
    public void whenValueContainsEqualSign() {
        String path = "./data/value_contains_equal_sign.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Andrey="));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFileDoesNotMatchPattern1() {
        String path = "./data/when_file_does_not_match_pattern_1.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFileDoesNotMatchPattern2() {
        String path = "./data/when_file_does_not_match_pattern_2.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFileDoesNotMatchPattern3() {
        String path = "./data/when_file_does_not_match_pattern_3.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFileDoesNotMatchPattern4() {
        String path = "./data/when_file_does_not_match_pattern_4.properties";
        Config config = new Config(path);
        config.load();
    }
}