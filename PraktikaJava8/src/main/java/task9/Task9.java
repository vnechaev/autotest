package task9;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
Напишите программу, которая каждые 2 секунды отображает на экране
данные о времени, прошедшем от начала сессии, а другой ее поток
выводит сообщение каждые 10 секунд.
 */
public class Task9 {
    //Поток, печатающий каждые 2 секунды
    class Thread1 implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
        }
    }


    //Поток, печатающий каждые 10 секунд
    class Thread2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
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
