class SetMatrixZeros {
   /*
   *
   * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
   * Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
   *
   * Approach: Usage of first row and column to store values for remaining rows and columns
   * */

   /* https://www.interviewbit.com/problems/set-matrix-zeros */

    //Time complexity - O(M*N), auxilary space complexity - O(1)
   public static void setZeroes(ArrayList<ArrayList<Integer>> a) {

       int R = 1, C = 1;
       int m = a.size();
       int n = a.get(0).size();
       for(int i=0; i< n; i++) {
           if(a.get(0).get(i) == 0) {
               R = 0;
               break;
           }
       }

       for(int i=0; i< m; i++) {
           if(a.get(i).get(0) == 0) {
               C = 0;
               break;
           }
       }



       for(int i=0; i< m; i++) {
           for(int j=0; j <n; j++) {
               if(a.get(i).get(j) == 0) {
                   a.get(0).set(j, 0);
                   a.get(i).set(0, 0);
               }
           }
       }

       for(int i=1; i< m; i++) {
           for(int j=1; j <n; j++) {
               if(a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
                   a.get(i).set(j, 0);
               }
           }
       }

       if(R == 0) {
           for(int i=0; i< n; i++) {
               a.get(0).set(i, 0);
           }
       }

       if(C == 0) {
           for(int i=0; i< m; i++) {
               a.get(i).set(0, 0);
           }
       }

   }

    private SetMatrixZeros() {
    }

}