package task10.question.code;

import java.util.concurrent.atomic.AtomicInteger;

public class Address {
    static private AtomicInteger abonentIdCreator = new AtomicInteger();
    final private int abonentId;

    public Address() {
        this.abonentId = abonentIdCreator.incrementAndGet();
    }

    public int hashcode(){
        return abonentId;
    }


}
