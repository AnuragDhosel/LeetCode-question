class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        int st = 0;
        int end = n-1;
        char ans = letters[0];

        while(st <= end){
            int mid = st + (end - st)/2;

            // if(letters[mid] == target){
            //     return mid == n-1 ? letters[0] : letters[mid+1];
            // }
            if(letters[mid] <= target){
                ans = (mid == n-1) ? letters[0] : letters[mid+1];
                st = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return ans;
    }
}