class RepeatAndMissingNumberArray {
   /*
   *
   * You are given a read only array of n integers from 1 to n.
   * Each integer appears exactly once except A which appears twice and B which is missing. Return A and B.
   * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
   * Note that in your output A should precede B.
   *
   * Approach:  using formula a^2-b^2 = (a+b)(a-b)
   * */

   /* https://www.interviewbit.com/problems/repeat-and-missing-number-array */
   public static int[] repeatedNumber(final int[] A) {
       long sumOfElements = 0;
       long sum = 0;
       long squareSum = 0;
       long squareSumOfElements = 0;
       for(int i=0; i< A.length; i++) {
           sum += (long) (i+1);
           squareSum += ((long) (i+1) * (long) (i+1));
           sumOfElements += (long) A[i];
           squareSumOfElements += ((long) A[i] * (long) A[i]);
       }
       long diff = sumOfElements - sum;
       long add = (squareSumOfElements - squareSum)/(diff);
       int[] arr = new int[2];
       arr[0] = (int) ((add + diff)/2);
       arr[1] = (int) ((add - diff)/2);
       return arr;
   }

    private RepeatAndMissingNumberArray() {
    }

}