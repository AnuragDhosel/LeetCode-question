class Solution {
    int [][] dp;
    public boolean solve(int i , int j , String s1 , String s2){
        if(i < 0){
            if(j < 0) return true;
            else if(s2.charAt(j) == '*')
                return solve(i , j-1 , s1 , s2);
            else
                return false;
        }
        if(j < 0) return false;

        if(dp[i][j] != -1)
            return (dp[i][j] == 1) ? true : false;

        if(s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?'){
            dp[i][j] = solve(i-1 , j-1 , s1 , s2) ? 1 : 0;
            return (dp[i][j] == 1) ? true : false;
        }
        else if(s2.charAt(j) == '*'){
            boolean skip = solve(i , j-1 , s1 , s2); // compare with empty char
            boolean j_decrease = solve(i-1 , j-1 , s1 , s2); // compare with only one char
            boolean j_NotDecrease = solve(i-1 , j , s1 , s2); // compare with more

            dp[i][j] = (j_decrease || j_NotDecrease || skip) ? 1 : 0;
            return j_decrease || j_NotDecrease || skip;
        }
        else{ // not match
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        dp = new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);

        return solve(n-1 , m-1 , s , p);
    }
}