package business.services.util;

public enum PlayingState {
	
	PLAY {
		
		@Override
		public PlayingState switchState() {
			return PAUSE;
		}

		@Override
		public boolean isPlaying() {
			return true;
		}
		
	},
	
	PAUSE {
		
		@Override
		public PlayingState switchState() {
			return PLAY;
		}

		@Override
		public boolean isPlaying() {
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
	public abstract boolean isPlaying();
}
