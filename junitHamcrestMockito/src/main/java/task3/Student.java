package task3;

public class Student {
    private long id;
    private String name;

    public Student(String name) {
        this.name = name;
        id = System.currentTimeMillis();
    }

    public long getId() {
        return id;
    }
}
