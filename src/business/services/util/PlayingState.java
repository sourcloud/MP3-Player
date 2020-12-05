package business.services.util;

/**
 * Enum that represents if a player a player's state is PLAY or PAUSE.
 * 
 * @author Sascha Scheid
 *
 */
public enum PlayingState {

	PLAY {

		@Override
		public PlayingState switchState() {
			return PAUSE;
		}

		@Override
		public boolean playing() {
			return true;
		}

	},

	PAUSE {

		@Override
		public PlayingState switchState() {
			return PLAY;
		}

		@Override
		public boolean playing() {
			return false;
		}

	};

	/**
	 * Switches state between PLAY and PAUSE.
	 * 
	 * @return (PlayingState) Next state.
	 */
	public abstract PlayingState switchState();

	/**
	 * Returns if state is PLAY.
	 * 
	 * @return (boolean) True if state is PLAY, else false.
	 */
	public abstract boolean playing();
}
