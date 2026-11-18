import java.util.ArrayList;
import java.util.List;

/**
 * O - Open/Closed.
 * A power strip is closed for modification (you don't rewire it)
 * but open for extension (you can plug in any new device).
 */
public class OpenClosed {

    interface Device {
        String turnOn();
    }

    static class Lamp implements Device {
        public String turnOn() { return "Lamp: light on"; }
    }

    static class Fan implements Device {
        public String turnOn() { return "Fan: spinning"; }
    }

    /** Added later. PowerStrip did not change. */
    static class PhoneCharger implements Device {
        public String turnOn() { return "Charger: charging"; }
    }

    static class PowerStrip {
        private final List<Device> devices = new ArrayList<>();

        void plug(Device device) { devices.add(device); }

        void switchOn() {
            devices.forEach(device -> System.out.println(device.turnOn()));
        }
    }

    public static void main(String[] args) {
        PowerStrip strip = new PowerStrip();
        strip.plug(new Lamp());
        strip.plug(new Fan());
        strip.plug(new PhoneCharger());
        strip.switchOn();
    }
}
