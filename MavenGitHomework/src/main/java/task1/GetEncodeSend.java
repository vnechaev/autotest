package task1;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URISyntaxException;
import java.util.Base64;

public class GetEncodeSend extends Thread {
    PipedInputStream pis;
    PipedOutputStream pos;


    public GetEncodeSend(PipedInputStream pis, PipedOutputStream out2) throws URISyntaxException {
        this.pos = out2;
        this.pis = pis;
    }

    public void run() {
        while (true) {
            byte[] buffer = new byte[0];
            try {
                buffer = new byte[pis.available()];
                pis.read(buffer, 0, buffer.length);
                byte[] encodedBytes = Base64.getEncoder().encode(buffer);
                pos.write(encodedBytes);
                pos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
