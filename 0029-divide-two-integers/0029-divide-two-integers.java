class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        boolean negative = false;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            negative = true;
        }

        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);

        long ans = 0;
        while(m >= n){
            int count = 0;
            while(m >= n * (long)Math.pow(2 , count+1)){
                count++;
            }
            ans += (long)Math.pow(2 , count);
            m -= n * (long)Math.pow(2 , count);
        }   

        // System.out.println(ans);
        // // System.out.println(Integer.MAX_VALUE + 1);
        // if(ans-1 == Integer.MAX_VALUE){
        //     System.out.println("T");
        //     return negative ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        // }

        return negative ? (int)-ans : (int)ans;
    }
}