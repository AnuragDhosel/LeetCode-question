class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<List> set = new HashSet<>();

        Arrays.sort(nums);
        helper(nums , 0 , list , ans , set);
        return ans;
    }
    public void helper(int [] nums , int idx , List<Integer> subset , List<List<Integer>> ans, HashSet<List> set){

        if(idx == nums.length){
            if(!set.contains(subset)){
                set.add(new ArrayList<>(subset));
                ans.add(new ArrayList<>(subset));
            } 
            return;
        }
        
        // include
        subset.add(nums[idx]);
        helper(nums , idx+1 , subset , ans , set);

        // exclude
        subset.remove(subset.size() - 1);
        helper(nums , idx+1 , subset , ans , set);
    }
}

/*
*/
