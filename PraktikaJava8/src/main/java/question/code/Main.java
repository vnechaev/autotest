package question.code;

public class Main {
    public static void main(String[] args) {
        final MessageSystem messageSystem = new MessageSystem();
        final Source source = new Source(messageSystem);
        final Target target = new Target(messageSystem);

        final Thread sourceThread = new Thread(source);
        sourceThread.setDaemon(true);
        sourceThread.setName("Source");
        final Thread targetThread = new Thread(target);
        targetThread.setDaemon(true);
        targetThread.setName("Source");

        final Client[] clients = {
                new Client(source, "bob", target),
                new Client(source, "duke", target),
                new Client(source, "alice", target),
                new Client(source, "kate", target),
                new Client(source, "john", target),
                new Client(source, "dave", target),
                new Client(source, "luke", target),
                new Client(source, "chewie", target),
                new Client(source, "anna", target),
                new Client(source, "sasha", target),
        };

        for (Client client : clients) {
            new Thread(client).start();
        }
        long timeStart = System.currentTimeMillis();
        while (true) {
            if ((System.currentTimeMillis() - timeStart) % 1000 == 0) {
                System.out.println("Шаг в 1 секунду");
            }
        }
    }
}
