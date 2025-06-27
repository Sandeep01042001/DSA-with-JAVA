class Solution { /*https://leetcode.com/problems/search-a-2d-matrix-ii/description/*/
    public boolean searchMatrix(int[][] matrix, int target) {
        int findRow = -1;
        for(int i=0; i<matrix.length; i++){
            int [] mat = matrix[i];
            if(isFind(mat, target)){
                return true;
            }
        }  
        return false;
    }
    public boolean isFind(int [] arr, int target){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
           int mid = l + (r - l)/2;
           if(arr[mid] == target){
            return true;
           }else if(arr[mid] > target){
             r = mid -1;
           }else{
             l = mid + 1;
           }
        }
        return false;
    }
}
