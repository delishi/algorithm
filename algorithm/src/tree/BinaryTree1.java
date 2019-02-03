package tree;

public class BinaryTree1 {
	static class TreeNode {
		String data;
		TreeNode left;
		TreeNode right;

		public TreeNode(String data) {
			this.data = data;
		}
	}

	// 前序遍历
	public void preOrder(TreeNode tree) {
		System.err.print(tree.data + " ");

		if (tree.left == null) {
			return;
		}

		preOrder(tree.left);

		preOrder(tree.right);
	}

	// 中序遍历
	public void inOrder(TreeNode tree) {
		
		if(tree != null){
			inOrder(tree.left);

			System.err.print(tree.data + " ");

			inOrder(tree.right);
		}
	}

	// 后序遍历
	public void postOrder(TreeNode tree) {

		if (tree.left == null) {
			return;
		}

		postOrder(tree.left);

		postOrder(tree.right);

		System.err.print(tree.data + " ");
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode("A");
		tree.left = new TreeNode("B");
		tree.right = new TreeNode("C");

		tree.left.left = new TreeNode("D");
		tree.left.right = new TreeNode("E");

		tree.right.left = new TreeNode("F");
		tree.right.right = new TreeNode("G");

		BinaryTree1 binaryTree = new BinaryTree1();
		// binaryTree.preOrder(tree);
		// System.err.println();
		binaryTree.inOrder(tree);
		System.err.println();
		binaryTree.postOrder(tree);
		System.err.println();
	}
}
