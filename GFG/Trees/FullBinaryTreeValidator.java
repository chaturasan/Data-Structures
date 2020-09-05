/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
/* https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree */
/*
* Full binary tree has either 0 or 2 children
* */
public class FullBinaryTreeValidator {

    public static boolean isFullTree(Node node) {
        if(node == null) return true;

        if(node.left == null && node.right == null) return true;

        if(node.left == null || node.right == null) return false;

        return isFullTree(node.left) && isFullTree(node.right);
    }

    private FullBinaryTreeValidator() {
    }

}