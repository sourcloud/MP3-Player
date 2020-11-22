package business.services.util;

public enum ShuffleState {
	
	ACTIVE {
		
		@Override
		public ShuffleState switchState() {
			return INACTIVE;
		}

		@Override
		public boolean isActive() {
			return true;
		}
		
	},
	
	INACTIVE {
		
		@Override
		public ShuffleState switchState() {
			return ACTIVE;
		}

		@Override
		public boolean isActive() {
			return false;
		}
		
	};
	
	public abstract ShuffleState switchState();
	public abstract boolean isActive();
}