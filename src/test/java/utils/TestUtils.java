package utils;

import day1.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtils {

    @Test
    @DisplayName("Give empty filename")
    void giveEmptyList(){
        List<String> actual = Utils.readFileIntoList("");
        List<String> expected = Collections.emptyList();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Take a textfile with empty input")
    void takeEmptyInput(){
        List<String> actual = Utils.readFileIntoList("emptyinput.txt");
        List<String> expected = Collections.emptyList();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Give a string as input which doesn't exist")
    void TestWrongStringInput(){
        List<String> actual = Utils.readFileIntoList("something.txt");
        List<String> expected = Collections.emptyList();

        assertEquals(expected, actual);
    }

}
