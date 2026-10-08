class TicketCounter {

    private int tickets = 5;

    public synchronized void bookTicket(String customer, int numberOfTickets) {

        if (numberOfTickets <= tickets) {

            System.out.println(customer + " is booking "
                    + numberOfTickets + " ticket(s)...");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }

            tickets -= numberOfTickets;

            System.out.println(customer + " successfully booked "
                    + numberOfTickets + " ticket(s).");

            System.out.println("Remaining tickets: " + tickets);

        } else {
            System.out.println(customer
                    + " could not book tickets. Not enough tickets.");
        }

        System.out.println();
    }
}

public class TicketBooking {
    public static void main(String[] args) {

        TicketCounter counter = new TicketCounter();

        Thread customer1 = new Thread(() -> {
            counter.bookTicket("Customer 1", 2);
        });

        Thread customer2 = new Thread(() -> {
            counter.bookTicket("Customer 2", 2);
        });

        Thread customer3 = new Thread(() -> {
            counter.bookTicket("Customer 3", 2);
        });

        customer1.start();
        customer2.start();
        customer3.start();
    }
}
