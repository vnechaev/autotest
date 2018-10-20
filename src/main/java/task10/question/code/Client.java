package task10.question.code;

public class Client extends Thread {
    protected AbonentService service;
    protected Target target;

    public Client(AbonentService service, String name, Target target) {
        this.service = service;
        this.target = target;
        setName(name);
    }

    @Override
    public void run() {
        while (true){
            service.sendMessageTOTarget(target.getAddress());
            System.out.println("Выслал сообщение поток " + this.getName());
        }
    }
}
