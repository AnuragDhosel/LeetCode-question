class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target > matrix[matrix.length-1][matrix[0].length-1]){
            return false;
        }
        
        int ansR = findTargetRow(matrix , target);
        if(ansR == -1) return false;

        return BSinMatrix(matrix , ansR , target);

    }
    public int findTargetRow(int [][] matrix , int target){
        int st = 0;
        int end = matrix.length-1;
        int ansR = -1;

        while(st <= end){
            int mid = st + (end - st)/2;

            if(matrix[mid][0] <= target){
                ansR = mid;
                st = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return ansR;
    }

    public boolean BSinMatrix(int [][] matrix , int ansR , int target){
        int st = 0;
        int end = matrix[0].length-1;
        
        while(st <= end){
            int mid = st + (end - st)/2;

            if(matrix[ansR][mid] == target){
                return true;
            }
            else if(matrix[ansR][mid] > target){
                end = mid - 1;
            }
            else{ // matrix[ansC][mid] < target
                st = mid + 1;
            }
        }

        return false;
    }
}