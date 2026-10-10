class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void solve(int idx , int t , int [] arr , List<Integer> temp){
        if(t == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(idx >= arr.length)
            return;

        for(int i=idx; i<arr.length; i++){
            if(i > idx && arr[i] == arr[i-1])
                continue;

            // take
            if(t - arr[i] >= 0){
                temp.add(arr[i]);
                solve(i+1 , t-arr[i] , arr , temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();

        solve(0 , target , candidates , temp);

        return ans;
    }
}