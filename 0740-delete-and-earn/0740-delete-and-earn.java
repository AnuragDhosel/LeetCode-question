class Solution {
    int [] dp;
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int max = 0;
        for(int ele : nums){
            if(!map.containsKey(ele)) map.put(ele , 1);
            else map.put(ele , map.get(ele)+1);

            max = Math.max(max , ele);
        }

        dp = new int[max+1];
        Arrays.fill(dp , -1);

        return solve(max , map);
    }
    public int solve(int num , HashMap<Integer , Integer> map){
        if(num <= 0) return 0;

        if(dp[num] != -1) return dp[num];

        int pick = solve(num-2 , map) + (map.containsKey(num) ? (num * map.get(num)) : 0);
        int skip = solve(num-1 , map);

        return dp[num] = Math.max(pick , skip);
    }
}