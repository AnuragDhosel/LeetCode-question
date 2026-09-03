class Solution {
    public boolean uniformArray(int[] nums1) {
        int minV = Integer.MAX_VALUE;
        for(int i=0; i<nums1.length; i++){
            minV = Math.min(minV , nums1[i]);
        }

        if(minV % 2 == 1) return true;
        if(minV % 2 == 0){
            for(int i=0; i<nums1.length; i++){
                if(nums1[i] % 2 == 1) return false;
            }
        }
        return true;

    }
}