package memonization;

import java.util.Arrays;
//https://www.youtube.com/watch?v=sdE0A2Oxofw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=9
//https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/
public class GridNoOfWays {

    static int countWaysUtil(int i, int j, int[][] dp) {
        if(i==0 && j == 0)
            return 1;
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int up = countWaysUtil(i-1,j,dp);
        int left = countWaysUtil(i,j-1,dp);

        return dp[i][j] = up+left;

    }

    static int countWays(int m, int n){
        int dp[][]=new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysUtil(m-1,n-1,dp);

    }

    public static void main(String args[]) {

        int m=3;
        int n=4;

        System.out.println(countWays(m,n));
    }
}
