class MinStepsInInfiniteGrid {
   /*
   *
   *    x x (B)
   *    x x
   * (A)x x
   * min. distance path between A & B will be diagonal path until x or y coordinate matches the respective destination cooridante
   * since it diagonal slope will be 1 so x1-x2 = y1-y2 so min path between A & B will be max(|x_a-x_b|, |y_a-y_b|)
   * */

   /* https://www.interviewbit.com/problems/min-steps-in-infinite-grid */
    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int minSteps = 0;
        for(int i=1; i<A.size(); i++) {
            minSteps += Math.max(Math.abs(A.get(i)-A.get(i-1)), Math.abs(B.get(i)-B.get(i-1)));
        }
        return minSteps;
    }

    private MinStepsInInfiniteGrid() {

    }

}