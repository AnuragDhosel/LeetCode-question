class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int size = 2*n;
        StringBuilder sb = new StringBuilder();
        
        solve(sb , ans , size);

        return ans;
    }
    public void solve(StringBuilder sb , List<String> list , int size){
        if(sb.length() == size){
            if(isValidparentheses(sb))
                list.add(sb.toString());
            return;
        }

        sb.append('(');
        solve(sb , list , size);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        solve(sb , list , size);
        sb.deleteCharAt(sb.length() - 1);
    }
    public boolean isValidparentheses(StringBuilder s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            else
                count--;
            if(count < 0) // ())(
                return false;
        }

        return (count == 0);
    }
}