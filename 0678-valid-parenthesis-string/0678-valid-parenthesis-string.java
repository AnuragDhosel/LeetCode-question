class Solution {
    int [][] dp;
    public boolean solve(int i , int balance , String s){ // balance -> for ( increase , for ) decrease
        if(balance < 0) // we get ) at the starting
            return false;

        if(i == s.length()){
            return (balance == 0) ? true : false;
        }

        if(dp[i][balance] != -1)
            return (dp[i][balance] == 1) ? true : false;

        boolean isValid = false;
        if(s.charAt(i) == '*'){
            isValid = isValid || solve(i+1 , balance+1 , s); // * -> (
            isValid = isValid || solve(i+1 , balance-1 , s); // * -> )
            isValid = isValid || solve(i+1 , balance , s);   // * -> ""
        }
        else if(s.charAt(i) == '('){
            isValid = isValid || solve(i+1 , balance+1 , s);
        }
        else{   // if(s.charAt(i) == ')')
            isValid = isValid ||solve(i+1 , balance-1 , s);
        }

        dp[i][balance] = isValid ? 1 : 0;
        return isValid;
    }
    public boolean checkValidString(String s) {
        int n = s.length();

        dp = new int[n+1][n+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++)
                Arrays.fill(dp[i] , -1);
        }

        return solve(0 , 0 , s);
    }
}