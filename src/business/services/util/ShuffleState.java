package business.services.util;

/**
 * Enum that represents if a player's shuffle state is active or inactive
 * 
 * @author Sascha Scheid
 */
public enum ShuffleState {

	ACTIVE {

		@Override
		public ShuffleState switchState() {
			return INACTIVE;
		}

		@Override
		public boolean active() {
			return true;
		}

	},

	INACTIVE {

		@Override
		public ShuffleState switchState() {
			return ACTIVE;
		}

		@Override
		public boolean active() {
			return false;
		}

	};

	/**
	 * Switches state between ACTIVE and INACTIVE!
	 * 
	 * @return (ShuffleState) Next state.
	 */
	public abstract ShuffleState switchState();

	/**
	 * Returns if state is ACTIVE.
	 * 
	 * @return (boolean) True if state is ACTIVE, else false.
	 */
	public abstract boolean active();
}