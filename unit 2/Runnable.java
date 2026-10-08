class NumberTask implements Runnable {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
        }
    }
}

class MessageTask implements Runnable {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Message: Hello");
        }
    }
}

public class RunnableExample {
    public static void main(String[] args) {

        RunnableTask r1 = new RunnableTask();
        RunnableTask r2 = new RunnableTask();

        Thread t1 = new Thread(new NumberTask());
        Thread t2 = new Thread(new MessageTask());

        t1.start();
        t2.start();
    }
}
