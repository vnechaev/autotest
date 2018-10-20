package task7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    public static void taskDo() {
        List<String> listString = Arrays.asList("qwe", "rty", "sdf", "qwert", "zxvv", "ghjk", "nmvcx");

        String threeLetter = listString.stream()
                .filter(str -> str.length() == 3)
                .collect(Collectors.joining(" | "));

        String fourLetter = listString.stream()
                .filter(str -> str.length() == 4)
                .collect(Collectors.joining(" | "));

        String resultString = threeLetter + "\n" + fourLetter;
        System.out.println(resultString);

        File resultCSV = new File("target","result.csv");
        try {
            FileWriter writer = new FileWriter(resultCSV);
            writer.write(resultString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task7.taskDo();
    }

}
