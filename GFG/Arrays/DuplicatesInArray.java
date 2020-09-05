/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
/* https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1 */
/*
* Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more
* than once in the given array.
* */
public class DuplicatesInArray {

    //Approach 1 using hash table - O(n) time, O(n) auxilary space
    public static ArrayList<Integer> duplicatesUsingHashTable(int arr[], int n) {
        ArrayList<Integer> duplicateNumbers = new ArrayList<>();
        int[] hashTable = new int[n];
        for(int i=0; i< n; i++) {
            hashTable[arr[i]]++;
        }

        for(int i=0; i< n; i++) {
            if(hashTable[i] > 1 ) {
                duplicateNumbers.add(i);
            }
        }
        if(duplicateNumbers.isEmpty()) duplicateNumbers.add(-1);
        return duplicateNumbers;
    }



    private DuplicatesInArray() {
    }
}