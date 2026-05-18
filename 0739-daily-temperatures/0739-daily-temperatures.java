class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>(); // stack store index
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i=0; i<temperatures.length; i++){
            int ele = temperatures[i];
            while(!st.isEmpty() && ele > temperatures[st.peek()]){
                int diff = i - st.peek();
                map.put(st.pop() , diff);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            map.put(st.pop() , 0);
        }

        int [] ans = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            ans[i] = map.get(i);
        }

        return ans;
    }
}