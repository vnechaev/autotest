package task1;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFromFileAndSend extends Thread {
    PipedOutputStream pos;
    FileInputStream fin;


    public ReadFromFileAndSend(PipedOutputStream pos, String resourcesFile) throws URISyntaxException, FileNotFoundException {
        this.pos = pos;
        Path pathText = Paths.get(getClass().getClassLoader()
                .getResource(resourcesFile).toURI());
        this.fin =  new FileInputStream(String.valueOf(pathText));

    }

    public void run() {
        try {
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
