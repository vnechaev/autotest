package task1;


import java.io.*;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        File resultCSV = new File("target", "result.csv");

        PipedOutputStream pout = new PipedOutputStream();
        PipedInputStream pin = new PipedInputStream();
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();

        try {
            pout.connect(pin);
            out.connect(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ReadFromFileAndSend readFileThread = new ReadFromFileAndSend(pout, "abcd.txt");
        GetEncodeSend getEncodeSendThread = new GetEncodeSend(pin, out);
        WriteToFileThread writeToFileThread = new WriteToFileThread(in, resultCSV);

        readFileThread.run();
        getEncodeSendThread.run();
        writeToFileThread.run();
    }

}
