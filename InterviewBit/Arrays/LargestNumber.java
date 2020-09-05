class LargestNumber {
   /*
   * Given a list of non negative integers, arrange them such that they form the largest number. For example:
   * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
   * Note: The result may be very large, so you need to return a string instead of an integer.
   *
   * Approch: Sorting by implementing comparator
   * */

   /* https://www.interviewbit.com/problems/largest-number */
   public static String largestNumber(final List<Integer> A) {
       String[] nums = new String[A.size()];
       for(int i=0; i<A.size(); i++) {
           nums[i] = String.valueOf(A.get(i));
       }

       Arrays.sort(nums, new Comparator<String>(){

           @Override
           public int compare(String a, String b) {
               return (b+a).compareTo(a+b);
           }
       });

       StringBuilder sb = new StringBuilder();

       for(String str: nums) {
           sb.append(str);
       }

       if(sb.charAt(0) == '0') return String.valueOf(0);

       return sb.toString();
   }

    private LargestNumber() {
    }

}