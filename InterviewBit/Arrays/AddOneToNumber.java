public class MinStepsInInfiniteGrid {
    /* https://www.interviewbit.com/problems/add-one-to-number */

    public static int[] plusOne(int[] A) {
        int carry = 1;
        int n = A.length;

        for(int i=n-1; i>=0; i--) {
            int num = (A[i] + carry);
            carry = num/10;
            A[i] = num%10;
            if(carry == 0) break;
        }

        if(carry > 0) {
            int[] result = new int[n+1];
            result[0] = carry;
            for(int i=0; i<n; i++) {
                result[i+1] = A[i];
            }
            return result;
        }

        if(A[0] == 0) {

            int i = 0;
            for(; i<n; i++) {
                if(A[i] != 0) break;
            }
            int[] result = new int[n-i];
            for(int j=0;j<result.length; j++) {
                result[j] = A[j+i];
            }
            return result;
        }
        return A;
    }

    private MinStepsInInfiniteGrid() {
    }

}