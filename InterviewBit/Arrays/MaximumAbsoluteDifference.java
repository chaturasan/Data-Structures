public class MaximumAbsoluteDifference {
   /*
   * |A[i]-A[j]| + |i-j| = max(A[i]-A[j]+i-j, -A[i]+A[j]+i-j, A[i]-A[j]-i+j, -A[i]+A[j]-i+j)
   *                     = max((A[i]-i)-(A[j]-j), (A[i]+i)-(A[j]+j))
   * */

   /* https://www.interviewbit.com/problems/maximum-absolute-difference */
   public static int maxArr(int[] A) {
       int maxSum = Integer.MIN_VALUE;
       int minSum = Integer.MAX_VALUE;
       int maxDiff = Integer.MIN_VALUE;
       int minDiff = Integer.MAX_VALUE;

       for(int i=0; i < A.length; i++) {
           int sum = A[i] + i;
           int diff = A[i] - i;
           maxSum = Math.max(maxSum, sum);
           minSum = Math.min(minSum, sum);
           maxDiff = Math.max(maxDiff, diff);
           minDiff = Math.min(minDiff, diff);
       }

       return Math.max(maxSum-minSum, maxDiff-minDiff);
   }

    private MaximumAbsoluteDifference() {
    }

}