class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int a = 0;
        int b = 1;
        int c = 2;
        int ways = 0;

        for(int i=3; i<n+1; i++){
            ways = b + c;
            b = c;
            c = ways;
        }

        return ways;
    }
}