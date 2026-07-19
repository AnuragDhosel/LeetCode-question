class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 1){
            return dividend;
        }
        // overflow check , 
        // int min value = -2^31 , Math.abs(-2^31) => 2^31
        // which is overflow , bcz int max value is 2^31 - 1
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);

        boolean negative = false;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            negative = true;
        }
        
        int count = 0;
        long sum = 0;
        while(sum + n <= m){
            count++;
            sum += n;
        }

        return negative ? -count : count;
    }
}
