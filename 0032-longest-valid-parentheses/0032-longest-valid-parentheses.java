class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>(); // store index
        HashMap<Integer , Integer> map = new HashMap<>(); // store ( => idx , ) => idx
        
        // store in hashmap
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(!st.isEmpty() && 
                (c == ')' && s.charAt(st.peek()) == '(')){
                map.put(st.pop() , i);
            }
            else{
                st.push(i);
            }
        }

        while(!st.isEmpty()){
            map.put(st.pop() , -1);
        }
        
        for(int key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }

        int count = 0;
        int maxCount = 0;
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(i)){
                if(map.get(i) != -1){
                    count += 2;
                    maxCount = Math.max(maxCount , count);
                }
                else if(map.get(i) == -1){
                    count = 0;
                }
            }
        }

        return maxCount;
    }
}