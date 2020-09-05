class NextPermutation {
   /*
   * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers
   * for a given array A of size N. If such arrangement is not possible, it must be rearranged as the lowest possible
   * order i.e., sorted in an ascending order.
   *
   * Writing next smallest numbmer helps
   * */

   /* https://www.interviewbit.com/problems/next-permutation */
   public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
       int n = A.size();
       int index=n-1;
       for(; index> 0; index--) {
           if(A.get(index) > A.get(index-1)) {
               break;
           }
       }

       index = index-1;

       if(index < 0) {
           Collections.sort(A);
       } else {
           int swapIndex = n-1;
           for(; swapIndex> index; swapIndex--) {
               if(A.get(swapIndex) > A.get(index)) break;
           }
           int temp = A.get(index);
           A.set(index, A.get(swapIndex));
           A.set(swapIndex, temp);
           Collections.sort(A.subList(index+1, n));
       }
       return A;
   }

    private NextPermutation() {
    }

}