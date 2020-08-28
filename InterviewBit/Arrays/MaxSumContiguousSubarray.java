public class MaxSumContiguousSubarray {
   /*
   * Two pointer approach one pointer to store globalSum till now and another pointer to store localSum and restore when
   * continuous sum (including current element) falls below the current element
   * */

   /* https://www.interviewbit.com/problems/max-sum-contiguous-subarray */
    public static int maxSubArray(final int[] A) {
        int globalSum = A[0];
        int localSum = A[0];
        for(int i=1; i< A.length; i++) {
            localSum = Math.max(A[i], A[i] + localSum);
            globalSum = Math.max(globalSum, localSum);
        }
        return globalSum;
    }

    private MaxSumContiguousSubarray() {
    }

}