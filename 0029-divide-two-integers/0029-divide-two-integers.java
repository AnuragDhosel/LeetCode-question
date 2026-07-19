class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);

        long ans = 0;
        while(m >= n){
            int count = 0;
            while(m >= (n << (count + 1))){
                count++;
            }  
            ans += (1 << count); 
            m -= (n << count);
        }   

        return negative ? (int)-ans : (int)ans;
    }
}

// (n << (count + 1)) => n * (long)Math.pow(2 , count+1)
// 1 << count => (long)Math.pow(2 , count)

// boolean negative = false;
// if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) negative = true;
//                        ↓
// boolean negative = (dividend < 0) ^ (divisor < 0);