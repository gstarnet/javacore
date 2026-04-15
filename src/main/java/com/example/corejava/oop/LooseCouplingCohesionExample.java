package com.example.corejava.oop;

public class LooseCouplingCohesionExample {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
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
