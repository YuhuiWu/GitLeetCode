/**
 *Given an integer n, return the number of trailing zeroes in n!.
 *
 *Note: Your solution should be in logarithmic time complexity.
 */
public class Math_172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int ret=0;
        while(true){
            n=n/5;
            ret+=n;
            if(n==0){
                break;
            }
        }
        return ret;
    }
}