package de.unistuttgart.dsass2020.ex10.p3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Realizes a basic hash map with closed hashing and linear probing. The hash
 * map is not expanded automatically on overflow. It extends
 * {@link AbstractHashMap} and uses its array of {@link KeyValuePair} as basic
 * data structure.
 *
 * @param <V> the type of the values to be added to the HashMap
 */
public class ClosedHashMap<V> extends AbstractHashMap<V> {

	/**
	 * Initializes a ClosedHashMap with the defined size and probing step size.
	 * 
	 * @param c    the probing step size
	 * @param size the size of the map
	 * @throws IllegalArgumentException
	 */

	private KeyValuePair<V>[] table;
	private int schrittweite = 1;
	private int size;

	private int getIndex(Integer key) {
		return Math.abs(key.hashCode()) % this.size;
	}

	@SuppressWarnings("unchecked")
	public ClosedHashMap(int size, int c) throws IllegalArgumentException {
		table = new KeyValuePair[size];
		this.schrittweite = c;
		this.size = size;
	}

	@Override
	public V put(Integer key, V value) throws IllegalStateException {
		// TODO Auto-generated method stub
		V res;
		KeyValuePair<V> newKVP = new KeyValuePair(key, value);
		int idx = this.getIndex(key);
		if (table[idx] == null) {
			table[idx] = newKVP;
		} else {
			int newIndex;
			for (int i = 0; i < this.size; i++) {
				newIndex = idx + i * this.schrittweite;
				newIndex = newIndex % this.size;
//				System.out.println(table[newIndex].getKey());
				if (table[newIndex] == null) {
					table[newIndex] = newKVP;
					return null;
				} else if (table[newIndex].getKey() == key) {
					res = table[newIndex].getValue();
					table[newIndex] = newKVP;
					return res;
				}

			}
			throw new IllegalStateException();
		}
		return null;

	}

	@Override
	public boolean containsKey(Integer key) {
		// TODO Auto-generated method stub
		int idx = this.getIndex(key);
		for (int i = 0; i < this.size; i++) {
			int newIndex = idx + i * this.schrittweite;
			newIndex = newIndex % this.size;
			if (this.table[newIndex].getKey() == key) {
				return true;
			}
		}
		return false;
	}

	@Override
	public V get(Integer key) {
		// TODO Auto-generated method stub
		if (!this.containsKey(key))
			return null;
		int idx = this.getIndex(key);
		for (int i = 0; i < this.size; i++) {
			int newIndex = idx + i * this.schrittweite;
			newIndex = newIndex % this.size;
			if (this.table[newIndex].getKey() == key) {
				return this.table[newIndex].getValue();
			}
		}
		return null;
	}

	@Override
	public V remove(Integer key) {
		// TODO Auto-generated method stub
		int idx = this.getIndex(key);
		V res;
		for (int i = 0; i < this.size; i++) {
			int newIdx = idx + this.schrittweite * i;
			newIdx = newIdx % this.size;
			if (this.table[newIdx].getKey() == key) {
				res = this.table[newIdx].getValue();
				this.table[newIdx] = null;
				return res;
			}
		}
		return null;
	}

	public class HashMapIter implements Iterator<KeyValuePair<V>> {

		private int i;

		public HashMapIter() {
			this.i = 0;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return this.i < table.length;
		}

		@Override
		public KeyValuePair<V> next() {
			// TODO Auto-generated method stub
			while (this.hasNext()) {
				if (table[this.i] != null) {
					KeyValuePair<V> res=table[this.i];
					i++;
					return res;
				}
				i++;
			}
			return null;
		}

	}

	@Override
	public Iterator<KeyValuePair<V>> iterator() {
		// TODO Auto-generated method stub
		return new HashMapIter();
	}

}
