class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        boolean [] arr = new boolean[s.length()];

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '(')
                st.push(i);
            else{ // c == ')'
                if(st.size() > 1){
                    arr[st.peek()] = true;
                    arr[i] = true;
                }
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(arr[i])
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}