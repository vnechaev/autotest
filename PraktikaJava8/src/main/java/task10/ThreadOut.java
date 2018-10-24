package task10;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ThreadOut extends Thread{
    private List<Transmitter> list = new ArrayList<>();

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PipedOutputStream stream = new PipedOutputStream();
        for (Transmitter elem: list){
            try {
                stream.write(elem.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
