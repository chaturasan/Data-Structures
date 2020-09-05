/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
/* https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree */
/*
*
* Min depth implementation assuming minDepth is counted as number of nodes present in a path
* */
public class MinDepthOfTree {

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            level++;
            while(n-- > 0) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) return level;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

        }
        return level;
    }

    private MinDepthOfTree() {
    }

}