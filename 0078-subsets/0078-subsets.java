class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public void solve(int i , int [] nums){
        if(i == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        // take
        list.add(nums[i]);
        solve(i+1 , nums);
        list.remove(list.size() - 1);

        // skip
        solve(i+1 , nums);   
    }

    public List<List<Integer>> subsets(int[] nums) {
        solve(0 , nums);

        return ans;
    }
    
}