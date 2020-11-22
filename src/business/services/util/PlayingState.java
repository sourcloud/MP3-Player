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
	
	public abstract PlayingState switchState();
	public abstract boolean isPlaying();
}
