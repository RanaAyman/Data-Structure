package eg.edu.alexu.csd.datastructure.FinalAssignment_cs24;

public class TreeDictionary<K extends Comparable<K>, V> implements IDictionary<K, V> {
	private Node root;
	public int size;
	boolean flag;
	V old = null;
	V deleted;
	boolean first;

	public static void main(String[] args) {
//	  TreeDictionary <String , String>test = new TreeDictionary<String , String>();
	}

	private class Node {
		K key;
		V value;
		Node left, right;

		Node(K key, V value) { 
			this.key = key;
			this.value = value;
			left = right = null;
		}
	}

	public TreeDictionary() {
		root = null;
		size = 0;
	}

	@Override
	public V get(K key) {
		if (key == null) {
			throw new RuntimeException("Error : Key is NULL ! (invalid key)!");
		} else {
			Node x = root;
			while (x != null) {
				int cmp = key.compareTo((K) x.key);
				if (cmp == 0)
					return (V) x.value;
				else if (cmp < 0)
					x = x.left;
				else if (cmp > 0)
					x = x.right;
			}
			return null;
		}
	}

	@Override
	public V set(K key, V value) {
		if (key == null || value == null) {
			throw new RuntimeException("Error : Key or Value is NULL ! (invalid Key or Value)!");
		} else {
			root = put(root, key, value);
			if (flag) {
				return old;                  
			} else {
				size++;
				return null;
			}
		}
	}
	
	private Node put(Node x, K key, V value) {
		flag = false;
		if (x == null) {
			return new Node(key, value);
		}
		int cmp = key.compareTo((K) x.key);
		if (cmp == 0) {
			flag = true;
			old = x.value;
			 x.value=value;           
		} else if (cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		return x;
	}

	@Override
	public V remove(K key) {
		if (key == null) {
			throw new RuntimeException("Error : Key is NULL ! (invalid key)!");
		} else {
			first = true;
			root = delete(root, key);
			return deleted;
		}
	}

	private Node delete(Node root, K key) {

		if (root == null) {
			deleted = null;
			return root;
		}
		int cmp = key.compareTo((K) root.key);
		if (cmp < 0) {
			root.left = delete(root.left, key);
		} else if (cmp > 0) {
			root.right = delete(root.right, key);
		} else {
			if (first) {
				deleted = root.value;
				size--;
				first = false;
			}
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.key = minKey(root.right).key;
			root.value = minKey(root.right).value;
			root.right = delete(root.right, root.key);
		}
		return root;
	}

	private Node minKey(Node root) {
		Node minK = root;
		while (root.left != null) {
			minK = root.left;
			root = root.left;
		}
		return minK;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
