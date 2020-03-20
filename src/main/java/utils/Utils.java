package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Utils {
    public static List<String> readFileIntoList(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> lines = Collections.emptyList();
        try {
            ClassLoader classLoader = Utils.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Problem reading file "+fileName+" "+e.getMessage());
        }
        //Customized
        catch (NullPointerException e){
            System.out.println("File not found!");
        }
        return lines;
    }
}
