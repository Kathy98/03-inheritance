package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class HungryState extends State {

    HungryState(int duration) {
        super(duration);
    }

    public State feed(Cat cat) {
        logger.info("You feed the cat...");
        // change state and reset the timer
        return new DigestingState(cat.getDigest(), getDuration() - getTime()); //Erster durchgang: 10-0
        // Katze verdaut: Wie lange darf Katze noch wach sein?
    }

    @Override
    public State successor(Cat cat) {
        logger.info("I've been starving for a too long time...");
        return new DeadState();
    }
}
