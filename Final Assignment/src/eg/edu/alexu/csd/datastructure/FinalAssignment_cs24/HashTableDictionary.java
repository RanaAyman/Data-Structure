package eg.edu.alexu.csd.datastructure.FinalAssignment_cs24;

public class HashTableDictionary<K, V> implements IDictionary<K, V> {
	private int table_size;
	public int size;
	private HashNode[] table;
	private V old = null;

	public static void main(String[] args) {
/* *************************************************** :: NOTE ::  *********************************
 * 
 *                                            YOU CAN USE ANY CONSTRUCTOR 
 *                                     A Constructor with parameter "Size of hashTable"
 *                                        OR A Constructor without any parameter .
 *                                        
 *  *************************************************** :: NOTE ::  *********************************                                       
 */
	}
	private class HashNode<K, V> {
		K key;
		V value;
		HashNode<K, V> next;

		private HashNode(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}

////////////////////////////////////////////////////////////////////////////      TWO CONSTRUCTORS ONE WITH PARAMETER "SIZE" AND ANOTHER ONE WITHOUT .
	public HashTableDictionary(int Size) {
		size = 0;
		table_size = Size;
		table = new HashNode[table_size];
		for (int i = 0; i < table_size; i++) {
			table[i] = null;
		}
	}

	public HashTableDictionary() {
		size = 0;
		table_size = 199;
		table = new HashNode[table_size];
		for (int i = 0; i < table_size; i++) {
			table[i] = null;
		}
	}

/////////////////////////////////////////////////////////
	@Override
	public V get(K key) {
		if (key == null) {
			throw new RuntimeException("Error : Key is NULL ! (invalid key)!");
		} else {
			int index = hash(key);
			if (table[index] == null) {
//			throw new RuntimeException("This Key Doesn't Exist !! ");
				return null;
			} else {
				HashNode entry = table[index];
				while (entry != null && !entry.key.equals(key))
					entry = entry.next;
				if (entry == null) {
//				throw new RuntimeException("This Key Doesn't Exist !! ");
					return null;

				} else
					return (V) entry.value;
			}
		}
	}

	@Override
	public V set(K key, V value) {
		if (key == null || value == null) {
			throw new RuntimeException("Error : Key or Value is NULL ! (invalid Key or Value)!");
		} else {
			int hash = (hash(key) % table_size);
			if (table[hash] == null) {
				table[hash] = new HashNode(key, value);
				size++;
				return null;
			} else {
				HashNode entry = table[hash];
				while (entry.next != null && !entry.key.equals(key))
					entry = entry.next;
				if (entry.key.equals(key)) {
					old = (V) entry.value;
					entry.value = value;
					return old;
				} else {
					entry.next = new HashNode(key, value);
					size++;
					return null;
				}
			}
		}
	}

	@Override
	public V remove(K key) {
		if (key == null) {
			throw new RuntimeException("Error : Key is NULL ! (invalid key)!");
		} else {
			int hash = (hash(key) % table_size);
			V value = null;
			if (table[hash] != null) {
				HashNode prevEntry = null;
				HashNode entry = table[hash];
				while (entry.next != null && !entry.key.equals(key)) {
					prevEntry = entry;
					entry = entry.next;
				}

				if (entry.key.equals(key)) {
					value = (V) entry.value;
					if (prevEntry == null)
						table[hash] = entry.next;
					else
						prevEntry.next = entry.next;
					size--;
				}
			}
			return value;
		}
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	private int hash(K key) {
		int hash_val = key.hashCode();
		hash_val %= table_size;
		if (hash_val < 0) {
			hash_val += table_size;
		}
		return hash_val;
	}

	public void printHashTable() {
		for (int i = 0; i < table_size; i++) {
			System.out.print("\nBucket " + (i + 1) + " : ");
			HashNode entry = table[i];
			while (entry != null) {
				System.out.print(entry.value + " ");
				entry = entry.next;
			}
		}
		System.out.println();
	}

}
