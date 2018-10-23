package task10;

public class Transmitter {
    int id;
    public Transmitter(){
        id = this.hashCode();
    }

    public int getId() {
        return id;
    }
}
