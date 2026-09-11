class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int [] ans = new int[n];

        for(int i=0; i<n; i++){
            int ele = temperatures[i];

            while(!st.isEmpty() && ele > temperatures[st.peek()]){
                ans[st.peek()] = i-st.peek();
                st.pop();
            }

            st.push(i);
        }

        return ans;
    }
}