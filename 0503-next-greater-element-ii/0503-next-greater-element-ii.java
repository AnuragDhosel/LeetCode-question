class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int ele = nums[i];
            while(!st.isEmpty() && ele > nums[st.peek()]){
                map.put(st.pop() , ele);
            }
            st.push(i);
        }

        // for rotation
        for(int i=0; i<nums.length; i++){
            int ele = nums[i];
            while(!st.isEmpty() && ele >  nums[st.peek()]){
                map.put(st.pop() , ele);
            }
        }

        int [] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(i)) ans[i] = map.get(i);
            else ans[i] = -1;
        }

        return ans;
    }
}