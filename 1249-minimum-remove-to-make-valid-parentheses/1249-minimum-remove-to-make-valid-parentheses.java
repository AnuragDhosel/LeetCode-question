class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>(); 

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(!st.isEmpty() && c == ')' && s.charAt(st.peek()) == '('){
                st.pop();
            }
            else if(c == ')' || c == '('){
                st.push(i);
            }
        }

        int n = st.size();
        int [] arr = new int[n]; // store idx of unwanted '(' or ')'
        int idx = n-1;
        while(!st.isEmpty()){
            arr[idx--] = st.pop();
        }
        // System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        idx=0;
        for(int i=0; i<s.length(); i++){
            if(idx < arr.length && i == arr[idx]){
                idx++;
                continue;
            }
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}