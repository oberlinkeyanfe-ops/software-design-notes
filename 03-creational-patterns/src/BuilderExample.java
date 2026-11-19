/**
 * Builder: build a complex object step by step, only with the parts you need.
 * Everyday image: ordering a plate at a restaurant. Main dish required, the rest optional.
 */
public class BuilderExample {

    static final class Plate {
        private final String mainDish;   // required
        private final String side;       // optional
        private final boolean spicy;     // optional
        private final String drink;      // optional

        private Plate(Builder builder) {
            this.mainDish = builder.mainDish;
            this.side = builder.side;
            this.spicy = builder.spicy;
            this.drink = builder.drink;
        }

        @Override
        public String toString() {
            return mainDish
                    + (side != null ? " with " + side : "")
                    + (spicy ? ", spicy" : "")
                    + (drink != null ? ", and a " + drink : "");
        }

        static Builder builder(String mainDish) {
            return new Builder(mainDish);
        }

        static final class Builder {
            private final String mainDish;
            private String side;
            private boolean spicy;
            private String drink;

            private Builder(String mainDish) { this.mainDish = mainDish; }

            Builder side(String side) { this.side = side; return this; }
            Builder spicy() { this.spicy = true; return this; }
            Builder drink(String drink) { this.drink = drink; return this; }

            Plate build() { return new Plate(this); }
        }
    }

    public static void main(String[] args) {
        Plate simple = Plate.builder("Ndole").build();
        Plate full = Plate.builder("Poulet DG").side("plantains").spicy().drink("juice").build();

        System.out.println(simple);
        System.out.println(full);
        // Without a builder, we would need a constructor with 4 parameters,
        // and calls like new Plate("Poulet DG", "plantains", true, null) are hard to read.
    }
}
