package de.unistuttgart.dsass2020.ex10.p3;

/**
 * Basic interface of a hash map that expects <code>Integer</code> keys and a
 * value of type V.
 *
 * @param <V> the type of the value
 */
public interface IHashMap<V> {

	/**
	 * Adds a value with the given key to the hash map if enough space is
	 * available. Returns a the previous value if the hash map contained one with
	 * the same key.
	 * 
	 * @param key
	 * @param value
	 * @return previous value if present, null otherwise
	 */
	public V put(Integer key, V value) throws IllegalStateException;

	/**
	 * Tests whether the hash map contains a given key.
	 * 
	 * @param key
	 * @return
	 */
	public boolean containsKey(Integer key);

	/**
	 * Gets the value of a specified key if present, null otherwise.
	 * 
	 * @param key
	 * @return the value or null
	 */
	public V get(Integer key);

	/**
	 * Removes the object associated with the provided key from the hash map and
	 * returns it.
	 * 
	 * @param key
	 * @return the removed object
	 */
	public V remove(Integer key);

}
