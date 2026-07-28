class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int pref = 1 , maxPref = Integer.MIN_VALUE;
        int suff = 1 , maxSuff = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            pref *= nums[i];
            suff *= nums[n-1-i];

            maxPref = Math.max(pref , maxPref);
            maxSuff = Math.max(suff , maxSuff);

            if(pref == 0)  pref = 1;
            if(suff == 0)  suff = 1;
        }

        return Math.max(maxPref , maxSuff);
    }
}