/**
 * Factory: one place decides which concrete class to create.
 * Everyday image: you tell the Mobile Money agent "I want to send money",
 * and the agent picks the right operator. You don't build the transfer yourself.
 */
public class FactoryExample {

    interface Payment {
        String pay(double amount);
    }

    static class OrangeMoney implements Payment {
        public String pay(double amount) { return "Paid " + amount + " FCFA with Orange Money"; }
    }

    static class MtnMomo implements Payment {
        public String pay(double amount) { return "Paid " + amount + " FCFA with MTN MoMo"; }
    }

    static class Card implements Payment {
        public String pay(double amount) { return "Paid " + amount + " FCFA by card"; }
    }

    /** The only place that knows the concrete classes. */
    static class PaymentFactory {
        static Payment create(String method) {
            return switch (method.toLowerCase()) {
                case "orange" -> new OrangeMoney();
                case "mtn" -> new MtnMomo();
                case "card" -> new Card();
                default -> throw new IllegalArgumentException("Unknown payment method: " + method);
            };
        }
    }

    public static void main(String[] args) {
        // The calling code only knows the Payment interface.
        for (String method : new String[] {"orange", "mtn", "card"}) {
            Payment payment = PaymentFactory.create(method);
            System.out.println(payment.pay(5000));
        }
        // Adding a new operator means one new class and one new line in the factory.
    }
}
