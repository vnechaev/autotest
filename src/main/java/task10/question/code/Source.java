package task10.question.code;

public class Source implements Abonent, Runnable, AbonentService {
    private final Address address = new Address();
    private final MessageSystem messageSystem;

    public Source(MessageSystem messageSystem) {
        this.messageSystem = messageSystem;
    }

    public void sendMessageTOTarget(Address to){
        final MsgFromSourceToTarget msg = new MsgFromSourceToTarget(address, to);
        System.out.println("Сообщение выслали "+ msg.getFrom().hashcode());
        messageSystem.sendMessages(msg);
    }

    @Override
    public void run() {
        while (true) {
            messageSystem.execForAbonent(this);
            try {
                Thread.sleep(ThreadSettings.SERVICE_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Address getAddress() {
        return address;
    }
}
