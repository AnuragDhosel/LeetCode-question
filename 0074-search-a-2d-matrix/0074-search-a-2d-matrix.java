class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int c = matrix.length;
        int r = matrix[0].length;

        int st = 0;
        int end = c-1;
        int ansC = 0;

        while(st <= end){
            int mid = st + (end - st)/2;

            if(matrix[mid][0] <= target){
                ansC = mid;
                st = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }


        st = 0;
        end = r-1;
        while(st <= end){
            int mid = st + (end - st)/2;

            if(matrix[ansC][mid] == target){
                return true;
            }
            else if(matrix[ansC][mid] > target){
                end = mid - 1;
            }
            else{ // matrix[ansC][mid] < target
                st = mid + 1;
            }
        }

        return false;

    }
}