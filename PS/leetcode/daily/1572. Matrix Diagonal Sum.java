class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;

        for (int i = 0 ; i < mat.length ; i++) {
            sum += mat[i][i];
            sum += mat[0 + i][mat.length - 1 - i];
        }

        return mat.length % 2 == 0 ? sum : sum - mat[mat.length / 2][mat.length / 2];
    }
}