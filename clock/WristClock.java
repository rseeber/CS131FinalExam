package clock;

public class WristClock extends DigitalClock {
    public WristClock(){
        type_.type = "Wrist";
        offsetPerSecond = 0.000034722;
    }
}
