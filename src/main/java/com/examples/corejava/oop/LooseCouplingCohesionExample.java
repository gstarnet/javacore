package com.examples.corejava.oop;


/**
 * Demonstrates loose coupling through an interface and cohesion through a focused service.
 *
 * <p>Interview questions answered: Why depend on abstractions? What makes a class
 * cohesive?</p>
 *
 * <p>Real-life use: swapping email, SMS, or push notification senders without rewriting
 * notification workflow code.</p>
 */
public class LooseCouplingCohesionExample {
    private LooseCouplingCohesionExample() {
    }
    /**
     * Runs this example directly from the command line.
     *
     * @param args command-line arguments; ignored by this example
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * Executes the example logic used by {@code DemoRunner} and tests.
     */
    public static void run() {
        // Walkthrough:
        // 1. Create the service with a MessageSender interface implementation.
        // 2. Let NotificationService focus only on notification workflow.
        // 3. The sender can change later without changing the service logic.
        NotificationService service = new NotificationService(new EmailSender());
        service.notifyUser("Ada", "Interview at 10");
        // Loose coupling: NotificationService depends on the MessageSender interface, not a concrete class.
        // Cohesion: NotificationService has one focused job: send user notifications.
    }

    private interface MessageSender {
        void send(String recipient, String message);
    }

    private static class EmailSender implements MessageSender {
        @Override
        public void send(String recipient, String message) {
            System.out.println("Email to " + recipient + ": " + message);
        }
    }

    private static class NotificationService {
        private final MessageSender sender;

        private NotificationService(MessageSender sender) {
            this.sender = sender;
        }

        private void notifyUser(String user, String message) {
            sender.send(user, message);
        }
    }
}
