class Solution {
    public boolean canJump(int[] nums) {
        int maxJ = 0; // ith index se max kahan tak pahuch sakte hain
        for(int i=0; i<nums.length; i++){
            if(i > maxJ) // we can't reach i from starting point
                return false;

            maxJ = Math.max(maxJ , i + nums[i]);
        }
        return true;
    }
}