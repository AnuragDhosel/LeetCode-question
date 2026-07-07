class Solution {
    public int findKthPositive(int[] arr, int k) {
        int st = 0;
        int end = arr.length - 1;
        
        while(st <= end){
            int mid = st + (end - st)/2;

            // kitne missing Numbers On Left Side
            int missingNum = arr[mid] - (mid+1);

            if(missingNum < k){
                st = mid + 1;
            } 
            else{
                end = mid - 1;
            }
        }

        return st + k;  
    }
}