package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class SleepingState extends State {

    // Da ich von anderer Klasse erbe, die keinen defaultkonstruktor hat, muss ich hier auch nen Konstruktor implementieren
    public SleepingState(int duration) {
        super(duration);
    }

    // Nachfolger = successor
    @Override
    public State successor(Cat cat) {
        logger.info("Yoan... getting hungry!");
        return new HungryState(cat.getAwake());
    }
}
