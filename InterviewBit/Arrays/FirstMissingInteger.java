class FirstMissingInteger {
   /*
   *
   *Given an unsorted integer array, find the first missing positive integer.
   * Example: Given [1,2,0] return 3, [3,4,-1,1] return 2, [-8, -7, -6] returns 1
   * Your algorithm should run in O(n) time and use constant space.
   *
   * Approach: Numbers in focus 1 to n so ignore negative and numbers GT n, store number at respective index - 1 (since
   * index starts from 0). Swap the pos of the element and decrease the counter to process the swapped element
   * */

   /* https://www.interviewbit.com/problems/first-missing-integer */

    //Time complexity - O(n), auxilary space complexity - O(1)
   public static int firstMissingPositive(int[] A) {
       int n = A.length;
       for(int i=0; i< n; i++) {
           if(A[i] > 0 && A[i] <=n) {
               int pos = A[i]-1;
               if(A[pos] != A[i]) {
                   int num = A[pos];
                   A[pos] = A[i];
                   A[i] = num;
                   i--;
               }
           }
       }

       for(int i=0; i<n; i++) {
           if(A[i] != i+1) return i+1;
       }

       return n+1;
   }

    private FirstMissingInteger() {
    }

}