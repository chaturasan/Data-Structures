class RotateMatrix {
   /*
   *
   *  You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
   * You need to do this in place.
   *
   * Greedy approach: when character is I it means next number is larger so select smaller number from available numbers
   * and if character is D it means next number is smaller so select largest number from available numbers
   *
   * Approach: To solve the question without any extra space, rotate the array in form of squares, dividing the matrix
   * into squares or cycles. For example, A 4 X 4 matrix will have 2 cycles. The first cycle is formed by its 1st row,
   * last column, last row and 1st column. The second cycle is formed by 2nd row, second-last column,
   * second-last row and 2nd column. The idea is for each square cycle, swap the elements involved with the
   * corresponding cell in the matrix in anti-clockwise direction i.e. from top to left, left to bottom, bottom to right
   * and from right to top one at a time using nothing but a temporary variable to achieve this. (Taken from GFG)
   * */

   /* https://www.interviewbit.com/problems/rotate-matrix */
   public static void rotate(ArrayList<ArrayList<Integer>> a) {
       int size = a.size();
       int numberOfCycles = size/2;
       for(int i=0; i< numberOfCycles; i++) {
           for(int j = i; j < size-i-1; j++) {
               int temp = a.get(i).get(j);
               a.get(i).set(j, a.get(size-j-1).get(i));
               a.get(size-j-1).set(i, a.get(size-i-1).get(size-j-1));
               a.get(size-i-1).set(size-j-1, a.get(j).get(size-i-1));
               a.get(j).set(size-i-1, temp);
           }
       }
   }

    private RotateMatrix() {
    }

}