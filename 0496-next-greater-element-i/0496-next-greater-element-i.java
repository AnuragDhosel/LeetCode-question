class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] ans = new int[nums1.length];

        for(int idx=0; idx<nums1.length; idx++){
            int num1 = nums1[idx];
            for(int i=0; i<nums2.length; i++){
                if(num1 == nums2[i]){
                    for(int j=i+1; j<nums2.length; j++){
                        if(num1 < nums2[j]){
                            ans[idx] = nums2[j];
                            break;
                        }
                    }
                    if(ans[idx] == 0) ans[idx] = -1;
                    i = nums2.length;
                }
            }
        }

        return ans;
    }
}