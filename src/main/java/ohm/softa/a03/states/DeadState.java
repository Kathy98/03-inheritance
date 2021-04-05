package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeadState extends State {

    private static final Logger logger = LogManager.getLogger();

    DeadState() {
        super(1);
        // super(-1); // alt
    }

    @Override
    public State successor(Cat cat) {
        logger.info("I'm dead!");
        return this; // Mit this is der state der Katze gemeint // Katze wird immer Tot bleiben -> Endlosschleife
    }
}
