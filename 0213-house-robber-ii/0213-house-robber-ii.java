class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int taking_0th_idx = solve1(nums , n-1);
        int taking_last_idx = solve2(nums , n);

        return Math.max(taking_0th_idx , taking_last_idx);
    }
    public int solve1(int [] nums , int size){
        int prevPrev = 0;
        int prev = nums[0]; // take 1st house

        for(int i=2; i<=size; i++){
            int pick = nums[i-1] + prevPrev;
            int skip = prev;

            int curr = Math.max(pick , skip);

            prevPrev = prev;
            prev = curr;
        }

        return prev;
    }

    public int solve2(int [] nums , int size){
        int prevPrev = 0;
        int prev = 0; // skip 1st house

        for(int i=2; i<=size; i++){
            int pick = nums[i-1] + prevPrev;
            int skip = prev;

            int curr = Math.max(pick , skip);

            prevPrev = prev;
            prev = curr;
        }

        return prev;
    } 
}