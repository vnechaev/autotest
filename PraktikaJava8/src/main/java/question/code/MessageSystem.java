package question.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageSystem {

    public MessageSystem() {
    }

    private final Map<Address, ConcurrentLinkedQueue<Msg>> messages = new HashMap<>();

    public void sendMessages(MsgFromSourceToTarget message) {
        Queue<Msg> messageQueue = messages.get(message.getTo());
        messageQueue.add(message);
    }

    public void addService(Abonent abonent) {
        messages.put(abonent.getAddress(), new ConcurrentLinkedQueue<Msg>());
    }

    public void execForAbonent(Abonent abonent) {
        Queue<Msg> messageQueue = messages.get(abonent.getAddress());
        while (!messageQueue.isEmpty()) {
            Msg message = messageQueue.poll();
            System.out.println("Сообщение" + message.getTo().hashcode());
            message.exec(abonent);
        }
    }
}
