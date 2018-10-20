package task9;
/*
Напишите программу, которая каждые 2 секунды отображает на экране
данные о времени, прошедшем от начала сессии, а другой ее поток
выводит сообщение каждые 10 секунд.
 */
public class Task9 {
    final long sessiionStartTime = System.currentTimeMillis();

    //Поток, печатающий каждые 2 секунды
    class Thread1 implements Runnable {
        @Override
        public void run() {
            while (true) {
                if ((System.currentTimeMillis() - sessiionStartTime) % 2000 == 0) {
                    System.out.println("Step 2 sec");
                    System.out.println((System.currentTimeMillis() - sessiionStartTime) / 1000);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //Поток, печатающий каждые 10 секунд
    class Thread2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                if ((System.currentTimeMillis() - sessiionStartTime) % 10000 == 0) {
                    System.out.println("Step 10 sec");
                    System.out.println((System.currentTimeMillis() - sessiionStartTime) / 1000);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void doTask() {
        (new Thread(new Thread1())).start();
        (new Thread(new Thread2())).start();
    }

    public static void main(String[] args) {
        new Task9().doTask();
    }
}
