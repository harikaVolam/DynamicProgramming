package memonization;

import java.util.Arrays;

//https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/
//https://www.youtube.com/watch?v=SrP-PiLSYC0&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=12

public class MinimumPathSumGrid {

    static int minSumPathUtil(int i, int j, int[][] matrix, int[][] dp) {
        if(i==0 && j == 0)
            return matrix[0][0];
        if(i<0 || j<0)
            return (int)Math.pow(10,9);
        if(dp[i][j]!=-1) return dp[i][j];

        int up = matrix[i][j]+minSumPathUtil(i-1,j,matrix,dp);
        int left = matrix[i][j]+minSumPathUtil(i,j-1,matrix,dp);

        return dp[i][j] = Math.min(up,left);

    }

    static int minSumPath(int n, int m, int[][] matrix){
        int dp[][]=new int[n][m];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return minSumPathUtil(n-1,m-1,matrix,dp);

    }

    public static void main(String args[]) {

        int matrix[][] = {{5,9,6},{11,5,2}};

        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(minSumPath(n,m,matrix));
    }
}
