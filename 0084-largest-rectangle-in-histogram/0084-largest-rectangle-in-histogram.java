class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        int maxArea = 0;
        for(int i=0; i<=n; i++){

            while(!st.isEmpty() && (i == n || heights[i] < heights[st.peek()])){
                int height = heights[st.pop()];

                int NSE = i;
                int PSE = st.isEmpty() ? -1 : st.peek();
                int width = NSE - PSE - 1;

                maxArea = Math.max(maxArea , height * width); 
            }
            st.push(i);
        }
        return maxArea;
    }
}