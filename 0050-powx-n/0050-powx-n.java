class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long newN = Math.abs((long)n);

        while(newN > 0){
            if(newN % 2 == 0){
                x = x * x;
                newN = newN / 2;
            }
            else{
                ans = ans * x;
                newN = newN - 1;
            }
        }

        if(n < 0) return (double)(1 / ans);
        return ans;
    }
}