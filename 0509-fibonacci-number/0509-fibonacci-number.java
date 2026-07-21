class Solution {
    public int fib(int n) {
        if(n <= 1) return n;

        int a = 0;
        int b = 1;
        int fibo = 0;
        for(int i=0; i<n; i++){
            fibo = a + b;
            b = a;
            a = fibo;
        }

        return fibo;
    }
}