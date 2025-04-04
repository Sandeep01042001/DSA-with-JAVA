class NumMatrix {
    int [][] arr;
    int [][] prefix; 
    public void createPSum(){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                int leftValue = j>0 ? prefix[i][j-1] : 0;
                int upValue = i>0 ? prefix[i-1][j] : 0;
                int midvalue = (i>0 && j>0) ? prefix[i-1][j-1] : 0;
                prefix[i][j] = leftValue + upValue - midvalue + arr[i][j];
            }
        }
    }
    public NumMatrix(int[][] matrix) {
        this.arr = matrix;
        this.prefix = new int[matrix.length][matrix[0].length];
        this.createPSum();

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int upVal = row1>0 ? prefix[row1-1][col2] : 0;
        int leftVal = col1>0 ? prefix[row2][col1-1] : 0;
        int midVal = (row1>0 && col1>0)? prefix[row1-1][col1-1]:0;
        return prefix[row2][col2] - upVal - leftVal + midVal;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
