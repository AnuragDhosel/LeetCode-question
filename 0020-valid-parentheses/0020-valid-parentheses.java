class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character , Character> map = new HashMap<>();
        map.put(']' , '[');
        map.put('}' , '{');
        map.put(')' , '(');

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(map.containsKey(c)){   // c == ')' || c == '}' || c == ']'
                if(!st.isEmpty() && map.get(c) == st.peek()) st.pop();
                else return false;
            }
            else{  // c == '(' || c == '{' || c == '['
                st.push(c);
            }
        }
        
        if(st.isEmpty()) return true;
        return false;
    }
}