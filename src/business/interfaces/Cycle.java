package business.interfaces;

public interface Cycle<T> {
	
	public boolean hasNext();
	public boolean hasPrev();
	public T current();
	public T next();
	public T prev();
	
}
