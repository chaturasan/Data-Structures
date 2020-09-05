/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;


/*
* Problem: Given an array arr[] of integers, find out the maximum difference between any two elements such that
*  larger element appears after the smaller number.
* Find difference along with check for min value and keep on updating
* */
/*  https://www.geeksforgeeks.org/maximum-difference-between-two-elements */
public class MaximumDifference {

    private static int maxDifference(int[] numbers, int size) {
        int maxDifference = Integer.MIN_VALUE;

        int minElement = numbers[0];
        for(int i=1; i< size; i++) {
            int diff = numbers[i]-minElement;
            maxDifference = Math.max(diff, maxDifference);
            minElement = Math.min(minElement, numbers[i]);
        }

        return maxDifference;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());
        while(t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            String[] arrString = new String[n];
            arrString = scanner.nextLine().trim().split(" ");
            int[] numbers = new int[n];
            for(int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(arrString[i]);
            }

            System.out.println(maxDifference(numbers, n));
        }
    }
}