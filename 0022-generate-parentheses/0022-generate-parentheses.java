class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int size = 2*n;
        solve("" , ans , size);

        return ans;
    }
    public void solve(String s , List<String> list , int size){
        if(s.length() == size){
            if(isValidparentheses(s))
                list.add(s);
            return;
        }

        solve(s + "(" , list , size);
        solve(s + ")" , list , size);
    }
    public boolean isValidparentheses(String s){
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