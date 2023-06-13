package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .containsExactly("first", "second", "three", "four", "five")
                .doesNotContain("ten", "nine")
                .startsWith("first", "second")
                .endsWith("four", "five")
                .containsSequence("second", "three")
                .last().isEqualTo("five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five", "six");
        assertThat(set).hasSize(6)
                .isNotNull()
                .allMatch(e -> e.length() > 2)
                .anySatisfy(e -> {
                    assertThat(e).isNotEmpty();
                    assertThat(e).isEqualTo("three");
                })
                .noneMatch(e -> e.length() < 1);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert
                .toMap("first", "second", "three", "four", "five", "six", "seven");
        System.out.println(map);
        assertThat(map).hasSize(7)
                .containsKeys("second", "three", "four", "five")
                .containsValues(3, 4, 1)
                .doesNotContainKey("nine")
                .doesNotContainValue(10)
                .containsEntry("first", 0);
    }
}