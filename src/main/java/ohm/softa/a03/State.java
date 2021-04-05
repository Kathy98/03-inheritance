package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {

    protected static final Logger logger = LogManager.getLogger();
    private int time = 0;
    private final int duration;

    protected State(int duration) {
        this.duration = duration;
    }

    public int getTime() {
        return time;
    }

    public int getDuration() {
        return duration;
    }

    // Note that the State.tick() method should be marked final; why is that?
    // WEIL: Keiner in dieser Logik mitreden soll
    final State tick(Cat cat) {
        /*if(duration < 0) // cat dies
            return this;*/

        time = time + 1; // time goes by...

        if(time < duration) {
            logger.info("Still in {}", getClass().getSimpleName()); // Bleibe länger im selben Zustand
            return this;
        }
        // Sobald die Zeit um ist z.B. duration/sleep=10 und time=11 wechsle ich den Zustand
        else {
            return successor(cat);
        }
    }

    // Abstrakte Methode -> kein Methodenrumpf
    public abstract State successor(Cat cat);
}
