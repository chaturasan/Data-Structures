class BinaryTreeMaximumPathSum {

    /*
    * https://leetcode.com/problems/binary-tree-maximum-path-sum/
    *
    * For each node there can be four ways that the maximum sum path goes through the node:
    * Node only.
    * Maximum sum path through Left Child + Node.
    * Maximum sum path through Right Child + Node.
    * Maximum sum through Left Child + Node + Max path through Right Child.
    *
    * we will initialize the resultant maximum sum variable res with INT_MIN, we keep track of four paths and pick up
    * the max one in the end. An important thing to note is, the root of every subtree need to return maximum path sum
    * such that at most one child of root is involved. This is needed for the parent function call.
    * */
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        findMaxPath(root, maxSum);
        return maxSum[0];
    }

    private static int findMaxPath(TreeNode root, int[] maxSum) {
        if(root == null) return 0;

        int leftMaxPath = findMaxPath(root.left, maxSum);
        int rightMaxPath = findMaxPath(root.right, maxSum);

        int maxSumFromSingleChild = Math.max(root.val, Math.max(root.val + leftMaxPath, root.val + rightMaxPath));

        int maxPathSubTree = Math.max(maxSumFromSingleChild, root.val + leftMaxPath + rightMaxPath);

        maxSum[0] = Math.max(maxSum[0], maxPathSubTree);

        return maxSumFromSingleChild;
    }

    private BinaryTreeMaximumPathSum() {
    }
}