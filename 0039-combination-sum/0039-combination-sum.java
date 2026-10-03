class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public void helper(int i , int [] arr , int target){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i < 0){
            return;
        }

        // take
        if(target - arr[i] >= 0){
            temp.add(arr[i]);
            helper(i , arr , target - arr[i]);
            temp.remove(temp.size()-1);
        }
        // skip
        helper(i-1 , arr , target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;

        helper(n-1 , candidates , target);

        return ans;
    }
}