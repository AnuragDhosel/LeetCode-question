class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean isEven = false;
        boolean isOdd = false;

        for(int i=0; i<nums1.length; i++){
            if(nums1[i] % 2 == 0){
                isEven = true;
            }
            else{
                isOdd = true;
            }
        }

        return isEven || isOdd;


    }
}