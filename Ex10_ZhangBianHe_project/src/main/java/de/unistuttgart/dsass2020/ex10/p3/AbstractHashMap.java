package de.unistuttgart.dsass2020.ex10.p3;

/**
 * Abstract class that realizes an key value pair class and suggests using an
 * array as the basic data structure for implementing hash maps.
 * 
 *
 * @param <V> the type of the values to be stored in the map
 */
public abstract class AbstractHashMap<V>
implements IHashMap<V>, Iterable<AbstractHashMap.KeyValuePair<V>> {

	protected KeyValuePair<V> map[];

	/**
	 * Key-value pairs are the entries in the hash map. The key is expected to be
	 * an integer and value is of generic type V.
	 *
	 * @param <V> the type of the value
	 */
	public static final class KeyValuePair<V> {

		private final Integer key;
		private final V value;

		/**
		 * Create a new key value pair.
		 * 
		 * @param key   - cannot be null
		 * @param value - the value associated with the given key
		 */
		public KeyValuePair(Integer key, V value) {
			if (key == null) {
				throw new IllegalArgumentException("key cannot be null");
			} else {
				this.key = key;
				this.value = value;
			}

		}

		/**
		 * Gets the key of the pair
		 * 
		 * @return key
		 */
		public Integer getKey() {
			return this.key;
		}

		/**
		 * Gets the value of the pair
		 * 
		 * @return value
		 */
		public V getValue() {
			return this.value;
		}
		
		public String toString() {
			return String.format("{key is %d Value is %d }", this.getKey(),this.getValue());
		}
	}

}
