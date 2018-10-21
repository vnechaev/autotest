package question.code;

public class Target implements Abonent, Runnable {
    private final Address address = new Address();

    public Target(MessageSystem messageSystem) {
        this.messageSystem = messageSystem;
        messageSystem.addService(this);
    }

    private final MessageSystem messageSystem;

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
