package task10;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ThreadInput extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(new PipedInputStream().read());;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
