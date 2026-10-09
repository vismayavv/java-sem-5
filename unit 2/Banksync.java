class BankAccount {

    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()
                + " deposited " + amount
                + ". Balance = " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " withdrew " + amount
                    + ". Balance = " + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " cannot withdraw. Insufficient balance.");
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class BankSynchronization {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(500);
            }
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(300);
            }
        }, "Thread 2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
