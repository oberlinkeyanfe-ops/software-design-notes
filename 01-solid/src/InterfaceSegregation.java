/**
 * I - Interface Segregation.
 * Nobody wants a remote with 80 buttons when they only use 5.
 * Clients should not depend on methods they don't use.
 */
public class InterfaceSegregation {

    // Instead of one big "UniversalRemote" interface, small focused ones.

    interface PowerControl {
        void power();
    }

    interface VolumeControl {
        void volumeUp();
        void volumeDown();
    }

    interface ChannelControl {
        void nextChannel();
    }

    /** A TV needs everything. */
    static class Tv implements PowerControl, VolumeControl, ChannelControl {
        public void power() { System.out.println("TV on/off"); }
        public void volumeUp() { System.out.println("TV volume +"); }
        public void volumeDown() { System.out.println("TV volume -"); }
        public void nextChannel() { System.out.println("TV next channel"); }
    }

    /** A speaker has no channels, so it doesn't implement ChannelControl. */
    static class Speaker implements PowerControl, VolumeControl {
        public void power() { System.out.println("Speaker on/off"); }
        public void volumeUp() { System.out.println("Speaker volume +"); }
        public void volumeDown() { System.out.println("Speaker volume -"); }
    }

    public static void main(String[] args) {
        Tv tv = new Tv();
        tv.power();
        tv.nextChannel();

        Speaker speaker = new Speaker();
        speaker.power();
        speaker.volumeUp();
    }
}
