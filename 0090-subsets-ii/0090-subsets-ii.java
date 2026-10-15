class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void helper(int idx , int [] arr , List<Integer> temp){
        ans.add(new ArrayList<>(temp));

        for(int i=idx; i<arr.length; i++){
            if(i > idx && arr[i] == arr[i-1])
                continue;
            
            // take
            temp.add(arr[i]);
            helper(i+1 , arr , temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(nums);
        helper(0 , nums , temp);

        return ans;
    }
}