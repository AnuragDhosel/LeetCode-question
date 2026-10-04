class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void helper(int i , int [] arr , int target , List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp)); // it take linear time
            return;
        }
        if(i < 0){
            return;
        }

        // take
        if(target - arr[i] >= 0){
            temp.add(arr[i]);
            helper(i , arr , target - arr[i] , temp);
            temp.remove(temp.size()-1);
        }
        // skip
        helper(i-1 , arr , target , temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        int n = candidates.length;

        helper(n-1 , candidates , target , temp);

        return ans;
    }
}