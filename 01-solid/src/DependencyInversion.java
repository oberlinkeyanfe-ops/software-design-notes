/**
 * D - Dependency Inversion.
 * Your phone charger plugs into a standard socket. It isn't soldered to the wall.
 * High-level code depends on an abstraction, not on a concrete source.
 */
public class DependencyInversion {

    /** The "standard socket". */
    interface PowerSource {
        String supply();
    }

    static class WallSocket implements PowerSource {
        public String supply() { return "220V from the wall"; }
    }

    static class SolarPanel implements PowerSource {
        public String supply() { return "power from the solar panel"; }
    }

    static class PowerBank implements PowerSource {
        public String supply() { return "power from the power bank"; }
    }

    /** The charger only knows the abstraction. */
    static class PhoneCharger {
        private final PowerSource source;

        PhoneCharger(PowerSource source) { this.source = source; }

        void charge() {
            System.out.println("Charging the phone with " + source.supply());
        }
    }

    public static void main(String[] args) {
        // During a power cut, switch the source without touching PhoneCharger.
        new PhoneCharger(new WallSocket()).charge();
        new PhoneCharger(new SolarPanel()).charge();
        new PhoneCharger(new PowerBank()).charge();
    }
}
