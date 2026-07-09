class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;

        int [] arr = new int[n];
        createArray(arr , nums1 , nums2);

        if(n % 2 != 0){
            return (double)arr[n / 2];
        }
        else{
            return (double)(arr[(n/2)-1] + arr[n/2]) / (double)2;
        }

    }

    public void createArray(int [] arr , int [] nums1 , int [] nums2){
        int i = 0; // on the nums1
        int j = 0; // on the nums2
        int idx = 0; // for arr

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                arr[idx++] = nums1[i++];
            }
            else{
                arr[idx++] = nums2[j++];
            }
        }

        while(i < nums1.length)
            arr[idx++] = nums1[i++];
        while(j < nums2.length)
            arr[idx++] = nums2[j++];   
    }
}