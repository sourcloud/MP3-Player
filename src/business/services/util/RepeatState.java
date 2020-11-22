package business.services.util;

public enum RepeatState {

	NONE {
		@Override
		public RepeatState nextState() { return ALL; }

		@Override
		public boolean repeatAll() { return false; }

		@Override
		public boolean repeatOne() {  return false; }
	},
	
	ALL {	
		@Override
		public RepeatState nextState() { return ONE; }

		@Override
		public boolean repeatAll() { return true; }

		@Override
		public boolean repeatOne() { return false; }		
	},
	
	ONE {	
		@Override
		public RepeatState nextState() { return NONE; }

		@Override
		public boolean repeatAll() { return false; }

		@Override
		public boolean repeatOne() { return true; }
	};
	
	/**
	 * Returns next state in repeat cycle. 
	 * Repeat cycle is NONE -> ALL -> ONE -> NONE.
	 * 
	 * @return (RepeatState) Next state in repeat cycle.
	 */
	public abstract RepeatState nextState();
	
	/**
	 * Returns if state is ALL.
	 * 
	 * @return (boolean) True if state is ALL, else false. 
	 */
	public abstract boolean repeatAll();
	
	/**
	 * Returns if state is ONE.
	 * 
	 * @return (boolean) True if state is ONE, else false.
	 */
	public abstract boolean repeatOne();

}
