class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int prefixMax = 0;
        int [] suffixMin = new int[n];

        suffixMin[n-1] = nums[n-1];
        for(int i=nums.length-2; i>=0; i--){
            suffixMin[i] = Math.min(nums[i] , suffixMin[i+1]);
        }

        for(int i=0; i<n; i++){
            prefixMax = Math.max(prefixMax , nums[i]);
            int stable = prefixMax - suffixMin[i];
            if(stable <= k)
                return i;
        }
        return -1;
    }
}