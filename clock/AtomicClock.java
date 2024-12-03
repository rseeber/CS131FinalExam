package clock;

public class AtomicClock extends QuantumClock{
    public AtomicClock(){
        type_.type = "Atomic";
        offsetPerSecond = 0.00d;
    }
}
