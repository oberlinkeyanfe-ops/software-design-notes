/**
 * Singleton: only one instance exists in the whole program.
 * Everyday image: a country has one central bank. Everybody talks to the same one.
 */
public class SingletonExample {

    static final class CentralBank {
        // Created once, when the class is loaded. Thread-safe without extra code.
        private static final CentralBank INSTANCE = new CentralBank();

        private double interestRate = 3.5;

        private CentralBank() {
            System.out.println("Central bank created");
        }

        static CentralBank getInstance() {
            return INSTANCE;
        }

        double getInterestRate() { return interestRate; }

        void setInterestRate(double rate) { this.interestRate = rate; }
    }

    public static void main(String[] args) {
        CentralBank a = CentralBank.getInstance();
        CentralBank b = CentralBank.getInstance();

        a.setInterestRate(4.0);

        System.out.println("Same object? " + (a == b));
        System.out.println("Rate seen through b: " + b.getInterestRate());

        // Use it with care: a Singleton is global state, which makes testing harder.
        // Often, passing one shared object through the constructor (dependency injection) is cleaner.
    }
}
