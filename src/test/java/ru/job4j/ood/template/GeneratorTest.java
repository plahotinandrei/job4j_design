package ru.job4j.ood.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

@Disabled
class GeneratorTest {
    @Test
    public void whenValidNameAndArgsThenMessageReturn() {
        Generator generator = new MessageGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Andrey Plakhotin");
        args.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}? ";
        String message = generator.produce(template, args);
        assertThat(message).isEqualTo("I am a Andrey Plakhotin, Who are you? ");
    }

    @Test
    public void whenInvalidArgsThenGetException() {
        Generator generator = new MessageGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Andrey Plakhotin");
        String template = "I am a ${name}, Who are ${subject}? ";
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenRedundantArgsThenGetException() {
        Generator generator = new MessageGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Andrey Plakhotin");
        args.put("subject", "you");
        args.put("age", "29");
        String template = "I am a ${name}, Who are ${subject}? ";
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenInvalidAndRedundantArgsThenGetException() {
        Generator generator = new MessageGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("subject", "you");
        args.put("age", "29");
        String template = "I am a ${name}, Who are ${subject}? ";
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}