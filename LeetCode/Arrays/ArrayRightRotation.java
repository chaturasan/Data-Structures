/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
/* https://leetcode.com/problems/rotate-array
*
* Given an array, rotate the array to the right by k steps, where k is non-negative.
* */

public class ArrayRightRotation {

    //Approach 1 Juggling algorithm Time complexity - O(n), space complexity - O(1)
    public static void rotateJugglingAlgorithm(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int greaterCommonDivisor = gcd(n, k);
        for (int i = n - 1; i >= n - greaterCommonDivisor; i--) {
            int temp = nums[i];
            int j = i;
            int x = 0;
            while (true) {
                x = j - k;
                if (x < 0) x = n + x;
                if (x == i) break;
                nums[j] = nums[x];
                j = x;
            }
            nums[j] = temp;
        }
    }

    //Approach 2 Array reversal approach
    public static void rotateReversalAppraoch(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    private ArrayRightRotation() {
    }
}