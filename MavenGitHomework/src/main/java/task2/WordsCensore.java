package task2;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class WordsCensore {
    @Option(name = "-size", required = true, usage = "set a start word for analyze the text")
    int size;

    @Option(name = "-start", required = true, usage = "set a start word for analyze the text")
    public int start;

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public WordsCensore(String... args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        }
    }

    public void doTask() throws IOException, URISyntaxException {
        Path pathException = Paths.get(getClass().getClassLoader()
                .getResource("exception.txt").toURI());

        byte[] fileBytes = Files.readAllBytes(pathException);
        String exception = new String(fileBytes);
        System.out.println("Строка со словами-исключениями: " + exception);

        Path pathText = Paths.get(getClass().getClassLoader()
                .getResource("text.txt").toURI());
        byte[] fileBytes2 = Files.readAllBytes(pathText);
        String text = new String(fileBytes2);
        System.out.println("исходный текс: " + text);


        List<String> listOfWord = Arrays.asList(text.split(" "));
        assertTrue("В переданном файле меньше слов, чем требуется пропустить", listOfWord.size() > start);
        String result = listOfWord.stream()
                .skip(start)
                .map(shortWord -> {
                    if (shortWord.length() < size) {
                        return "размер меньше чем " + size;
                    } else return shortWord;
                })
                .map(exceptionWord -> {
                    if (exception.contains(exceptionWord)) {
                        return "цензура";
                    } else return exceptionWord;
                }).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public static void main(String[] args) {
        WordsCensore values = new WordsCensore(args);
        CmdLineParser parser = new CmdLineParser(values);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.exit(1);
        }

        System.out.println("start - " + values.getStart());
        System.out.println("size - " + values.getSize());
    }
}
