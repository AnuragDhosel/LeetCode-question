class Solution {
    public int gcdOfOddEvenSums(int n) {
        long sumEven = n*(n+1);
        long sumOdd = (long)(n * n);

        System.out.println(sumEven + " " + sumOdd);

        return gcd(sumEven , sumOdd);
    }
    public int gcd(long a , long b){
        if(b == 0) return (int)a;
        return gcd(b , a%b);
    }
}