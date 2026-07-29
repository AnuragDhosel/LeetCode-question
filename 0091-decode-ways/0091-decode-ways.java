class Solution {
    int [] dp;
    public int solve(int i , int n , String s){
        if(i >= n) // we get a valid way
            return 1;

        if(s.charAt(i) == '0') // we get a unvalid way bcz 0 can't represent
            return 0;

        if(dp[i] != -1) return dp[i];    

        int oneEleChoosen = solve(i + 1 , n ,  s);

        int twoEleChoosen = 0;
        if(i + 1 < n){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
                twoEleChoosen = solve(i + 2 , n , s);
            }
        }

        dp[i] = oneEleChoosen + twoEleChoosen;
        return dp[i];
    }

    public int numDecodings(String s) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp , -1);

        return solve(0 , s.length() , s);
    }
}