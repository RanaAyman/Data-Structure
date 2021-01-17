package eg.edu.alexu.csd.datastructure.FinalAssignment_cs24;

public class BinaryTree implements IMiscUtils {
	public BinaryTreeNode Root;
	Boolean first; // To test if root is the first root
	int sum; // To store sum of specified elements

	public static void main(String[] args) {
//        
	}

	// Class containing left and right child of current node and key value
	public class BinaryTreeNode {
		public Object element;
		public BinaryTreeNode left, right;

		public BinaryTreeNode(Object element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}
	}

	// Constructor
	public BinaryTree() {
		Root = null; // Root of the Binary Tree
		first = true;
		sum = 0;
	}

	private void TestFirstRoot(BinaryTreeNode root) { // To test if root is the first root
		if (first) {
			Root = root;
			first = false;
		}
	}

	@Override
	public BinaryTreeNode insert(BinaryTreeNode root, int element) { // << Recursion Method
		// If the tree is empty, return a new node
		if (root == null) {
			root = new BinaryTreeNode(element);
			TestFirstRoot(root); // To test if root is the first root
			return root;
		}
		// Otherwise, recur down the tree
		if (element < (int) root.element) {
			root.left = insert(root.left, element);
		} else if (element > (int) root.element) {
			root.right = insert(root.right, element);
		}
		// return root
		return root;
	}

	@Override
	public int sumRange(BinaryTreeNode root, int low, int high) {
		// If the tree is empty, return zero
		if (root == null) {
			return sum;
		}
		// go left or right according to the given range [low,high] to test and get the
		// sum
		if (low < (int) root.element) {
			sumRange(root.left, low, high);
		}
		if (low <= (int) root.element && high >= (int) root.element) {
			sum += (int) root.element;
		}
		if (high > (int) root.element) {
			sumRange(root.right, low, high);
		}
		// return sum
		return sum;
	}

	// Returns true if the given tree is a BST and its values are >= min and <= max.
	private boolean isBSTUtil(BinaryTreeNode node, int min, int max) {
		// an empty tree is BST
		if (node == null)
			return true;
		// false if this node violates the min/max constraints
		if ((int) node.element < min || (int) node.element > max)
			return false;
		// otherwise check the subtrees recursively tightening the min/max constraints
		// Allow only distinct values
		return (isBSTUtil(node.left, min, (int) node.element - 1)
				&& isBSTUtil(node.right, (int) node.element + 1, max));

	}

	// returns true if given search tree is binary search tree
	@Override
	public boolean isValidBST(BinaryTreeNode root) {
		return isBSTUtil(Root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	@Override
	public int[] nextSmallerNumber(int[] array) {
		if (array == null) {
			throw new NullPointerException("Error: Null arrays!");
		} else if (array.length == 0) {
			throw new IllegalArgumentException("Error: Zero-length arrays!");
		} else {
			Stack Element = new Stack(); // stacks to deal with elements of the input array
			Stack Index = new Stack(); // another stacks to deal with indices of the input array
			int[] indices = new int[array.length];
			// push the first element to stack and its index
			Element.push(array[0]);
			Index.push(0);

			// iterate for rest of the elements and their indices
			for (int i = 1; i < array.length; i++) {

				if (Element.isEmpty()) {
					Element.push(array[i]);
					Index.push(i);
					continue;
				}
				/*
				 * if stack is not empty, then pop an element from stack and its index from the
				 * other stack. If the popped element is smaller than next, then keep popping
				 * while elements are smaller and stack is not empty
				 */
				while (Element.isEmpty() == false && (int) Element.peek() > array[i]) {
//				System.out.println(Element.peek() + " --> " + array[i]);
					indices[(int) Index.pop()] = i;
					Element.pop();
				}
				/*
				 * push next to stack so that we can find next smaller for it
				 */
				Element.push(array[i]);
				Index.push(i);
			}
			/*
			 * After iterating over the loop, the remaining elements in stack do not have
			 * the next smaller element, so store -1 for them
			 */
			while (Element.isEmpty() == false) {
//			System.out.println(Element.peek() + " --> " + "-1");
				indices[(int) Index.pop()] = -1;
				Element.pop();
			}
			// return an array containing the indices of the next smaller number of every
			// number or -1 if the next smaller number does not exist.
			return indices;
		}
	}

///////////////////////////////////////////////////////////////   Extra Functions For Testing Only ...
//	public void Inorder(BinaryTreeNode root) {
//		if (root == null)
//			return;
//		else {
//			Inorder(root.left);
//			System.out.print(root.element + " ");
//			Inorder(root.right);
//		}
//	}
//
//	public static void print(int[] arr) {
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//	}

}
