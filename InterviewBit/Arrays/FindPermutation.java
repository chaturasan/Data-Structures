class FindPermutation {
   /*
   *
   *  Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of
   * first n positive integer that satisfy the given input string. D means the next number is smaller, while I means
   *  the next number is greater.
   *
   * E.g: n = 3
   * s = ID
   * Return: [1, 3, 2]
   *
   * Greedy approach: when character is I it means next number is larger so select smaller number from available numbers
   * and if character is D it means next number is smaller so select largest number from available numbers
   * */

   /* https://www.interviewbit.com/problems/find-permutation */
   public static ArrayList<Integer> findPerm(final String A, int B) {
       ArrayList<Integer> result = new ArrayList<>();
       int l = 1;
       int r = B;
       for(char ch: A.toCharArray()) {
           if(ch == 'D') {
               result.add(r);
               r--;
           } else {
               result.add(l);
               l++;
           }
       }

       result.add(l);
       return result;
   }

    private FindPermutation() {

    }

}