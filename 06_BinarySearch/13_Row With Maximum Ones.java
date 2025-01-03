/* https://leetcode.com/problems/row-with-maximum-ones/ */
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
         int row = mat.length;
        int col = mat[0].length;

        int idx = -1, maxOneNum = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            int oneNum = 0;
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    oneNum += 1;
                }
            }

            if (oneNum > maxOneNum) {
                idx = i;
                maxOneNum = oneNum;
            }
        }

        return new int[]{idx, maxOneNum};
    }
}
