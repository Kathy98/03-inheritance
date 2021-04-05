package ohm.softa.a03;

// import static ohm.softa.a03.Cat.State.*; //static???
import ohm.softa.a03.states.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Cat {

	private static final Logger logger = LogManager.getLogger(); // Für Konsolenausgabe

	private State state;	// initially, animals are sleeping

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;

		state = new SleepingState(sleep); // initially, animals are sleeping
	}

	public void tick(){
		logger.info("tick()");
		this.state = state.tick(this);
	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry()) // if (!(state instanceof HungryState))
			throw new IllegalStateException("Not every cat is Garfield...");

		logger.info("You feed the cat...");
		this.state = ((HungryState) state).feed(this);
	}

	public boolean isAsleep() { return state instanceof SleepingState; }

	public boolean isPlayful() {
		return state instanceof PlayfulState;
	}

	public boolean isHungry() { return state instanceof HungryState; }

	public boolean isDigesting() {
		return state instanceof DigestingState;
	}

	public boolean isDead() {
		return state instanceof DeadState;
	}

	public int getAwake() {
		return awake;
	}

	public int getSleep() {
		return sleep;
	}

	public int getDigest() {
		return digest;
	}

	@Override
	public String toString() {
		return name;
	}
}
