class Solution {
    public int findKthPositive(int[] arr, int k) {
        int num = 1;
        int idx = 0;
        while(k > 0){
            if(idx < arr.length && arr[idx] == num){
                idx++;
            }
            else{
                k--;
                if(k == 0) return num;
            }
            num++;
        }
        return num;
    }
}