package task1;

import java.io.*;

public class WriteToFileThread extends Thread {

    PipedInputStream input;
    FileOutputStream fos;

    public WriteToFileThread(PipedInputStream input, File file) throws FileNotFoundException {
        this.input = input;
        this.fos = new FileOutputStream(file);
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (input.available() > -1) {
                    byte[] buffer = new byte[input.available()];
                    input.read(buffer, 0, buffer.length);
                    fos.write(buffer, 0, buffer.length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
