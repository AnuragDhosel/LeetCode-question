class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void helper(int i , int [] arr , List<Integer> temp , HashSet<List<Integer>> set){
        if(i == arr.length){
            if(!set.contains(temp)){
                set.add(new ArrayList<>(temp));
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // take
        temp.add(arr[i]);
        helper(i+1 , arr , temp , set);
        temp.remove(temp.size() - 1);

        // skip
        helper(i+1 , arr , temp , set);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        helper(0 , nums , temp , set);

        return ans;
    }
}