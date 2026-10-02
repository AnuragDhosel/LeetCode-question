class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        solve(sb , 0 , 0 , ans , n);

        return ans;
    }
    public void solve(StringBuilder sb , int open , int close , List<String> list , int n){
        if(sb.length() == 2*n){
            list.add(sb.toString());
        }

        // take open bracket
        if(open < n){
            sb.append('(');
            solve(sb , open+1 , close , list , n);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // take close bracket 
        if(close < open){
            sb.append(')');
            solve(sb , open , close+1 , list , n);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}