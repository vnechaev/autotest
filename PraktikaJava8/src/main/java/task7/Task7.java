package task7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    public static String stringToFilteredString(List<String> list, int length) {
        return list.stream()
                .filter(str -> str.length() == length)
                .collect(Collectors.joining(" | ")) + "\n";
    }

    public static void main(String[] args) {
        List<String> listString = Arrays.asList("qwe", "rty", "sdf", "qwert", "zxvv", "ghjk", "nmvcx");

        String resultString = stringToFilteredString(listString, 3)
                + stringToFilteredString(listString, 4);
        System.out.println(resultString);

        File resultCSV = new File("result.csv");
        try {
            FileWriter writer = new FileWriter(resultCSV);
            writer.write(resultString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
