class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int prefix = 0;
        for(int i=0; i<nums.length; i++){
            prefix = Math.max(prefix , nums[i]);
            int min = Integer.MAX_VALUE;
            for(int j=i; j<nums.length; j++){
                min = Math.min(min , nums[j]);
            }
            int stable = prefix - min;
            if(stable <= k)
                return i;
        }
        return -1;
    }
}