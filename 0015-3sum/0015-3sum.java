class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set1 = new HashSet<>(); // to check dublicate

// a + b + c = 0  =>  c = -(a+b)
        for(int i=0; i<nums.length; i++){

            HashSet<Integer> set2 = new HashSet<>(); // check element have seen or not
            for(int j=i+1; j<nums.length; j++){

                int third = -(nums[i] + nums[j]);
                if(set2.contains(third)){
                    ArrayList<Integer> list = new ArrayList<>();

// store 3 element in sorted sothat set compare and can't store dublicate arraylist
                    int max = Math.max(third , Math.max(nums[i] , nums[j]));
                    int min = Math.min(third , Math.min(nums[i] , nums[j]));
                    int mid = (nums[i] + nums[j] + third) - (max + min);

                    list.add(min);
                    list.add(mid);
                    list.add(max);

                    set1.add(list);
                }
                set2.add(nums[j]); // we have seen nums[j]
            }
        }

        for(List<Integer> key : set1){
            ans.add(key);
        }

        return ans;
    }
}

// third = -(-1 + 0) = 1
// set = 0
// third = -(-1 + 1) = 0
// set = 1 0
// third = -(-1 + 2) = -1
// set = 1 0 -1
// third = -(-1 + -1) = 2
// set = 1 0 -1 2