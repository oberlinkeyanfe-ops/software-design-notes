/**
 * L - Liskov Substitution.
 * If you order "a drink" and get water instead of juice, you can still drink it.
 * Any subtype must keep the promise of its parent type.
 */
public class LiskovSubstitution {

    interface Drink {
        /** Promise: returns a positive volume in ml, never throws. */
        int drink();
    }

    static class Juice implements Drink {
        public int drink() { return 330; }
    }

    static class Water implements Drink {
        public int drink() { return 500; }
    }

    /**
     * A bad subtype would break the promise, for example:
     *
     *   class EmptyBottle implements Drink {
     *       public int drink() { throw new IllegalStateException("empty"); }
     *   }
     *
     * Code written for Drink would suddenly crash. That is a Liskov violation.
     */

    static void serve(Drink drink) {
        System.out.println("Customer drank " + drink.drink() + " ml");
    }

    public static void main(String[] args) {
        serve(new Juice());
        serve(new Water()); // a substitute that still keeps the promise
    }
}
