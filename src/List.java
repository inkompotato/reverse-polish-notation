
public interface List {
	void add(Object o);
	void addFirst (Object o);
	void remove();
	boolean isEmpty();
	Object current();
	int getSize();
	void reset();
	void next();
	boolean endoflist();
}
