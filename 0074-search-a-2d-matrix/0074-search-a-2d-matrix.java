class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int r = 0;
        int c = col - 1;

        while(r < row && c >= 0){
            int mid = matrix[r][c];

            if(target == mid){
                return true;
            }
            else if(target > mid){
                r++;
            }
            else{ // target < mid
                c--;
            }
        }
        return false;
    }
}