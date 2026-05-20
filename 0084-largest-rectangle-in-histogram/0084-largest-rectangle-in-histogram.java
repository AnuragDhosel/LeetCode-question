// optimise
class Solution {
    public int largestRectangleArea(int[] heights) {
        int [] NSEidx = nextSmallerElementIdx(heights);
        int [] PSEidx = previousSmallerElementIdx(heights);

        System.out.println(Arrays.toString(NSEidx));
        System.out.println(Arrays.toString(PSEidx));

        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int width = NSEidx[i] - PSEidx[i] - 1;
            int currArea = heights[i] * width;
            maxArea = Math.max(maxArea , currArea);
        }
        return maxArea;
    }
    public int[] nextSmallerElementIdx(int [] arr){
        Stack<Integer> st = new Stack();
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            int ele = arr[i];
            while(!st.isEmpty() && ele < arr[st.peek()]){
                map.put(st.pop() , i);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            map.put(st.pop() , arr.length);
        }

        int [] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            ans[i] = map.get(i);
        }
        
        return ans;
    }
    public int[] previousSmallerElementIdx(int [] arr){
        Stack<Integer> st = new Stack();
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i=arr.length-1; i>=0; i--){
            int ele = arr[i];
            while(!st.isEmpty() && ele < arr[st.peek()]){
                map.put(st.pop() , i);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            map.put(st.pop() , -1);
        }

        int [] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            ans[i] = map.get(i);
        }
        
        return ans;
    }
}