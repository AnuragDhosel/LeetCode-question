class Solution {
    int [][][] dp;
    public boolean solve(int i , int open , int close , String s){ // balance -> for ( increase , for ) decrease
        if(close > open) // we get ) at the starting
            return false;

        if(i == s.length()){
            return (open == close) ? true : false;
        }

        if(dp[i][open][close] != -1)
            return (dp[i][open][close] == 1) ? true : false;

        boolean isValid = false;
        if(s.charAt(i) == '*'){
            isValid = isValid || solve(i+1 , open+1 , close , s); // * -> (
            isValid = isValid || solve(i+1 , open , close+1 , s); // * -> )
            isValid = isValid || solve(i+1 , open , close , s);   // * -> ""
        }
        else if(s.charAt(i) == '('){
            isValid = isValid || solve(i+1 , open+1 , close , s);
        }
        else{   // if(s.charAt(i) == ')')
            isValid = isValid || solve(i+1 , open , close+1 , s);
        }

        dp[i][open][close] = isValid ? 1 : 0;
        return isValid;
    }
    public boolean checkValidString(String s) {
        int n = s.length();

        dp = new int[n+1][n+1][n+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++)
                Arrays.fill(dp[i][j] , -1);
        }

        return solve(0 , 0 , 0 , s);
    }
}