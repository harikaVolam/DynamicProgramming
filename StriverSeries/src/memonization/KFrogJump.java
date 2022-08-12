package memonization;

//https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
//https://www.youtube.com/watch?v=Kmh3rhyEtB8&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6

import java.util.Arrays;

public class KFrogJump {
    static int solveUtil(int ind, int[] height, int[] dp, int k) {
        if (ind == 0) return 0;
        if (dp[ind] != -1) return dp[ind];

        int mmSteps = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = solveUtil(ind - j, height, dp, k) + Math.abs(height[ind] -
                        height[ind - j]);
                mmSteps = Math.min(jump, mmSteps);
            }
        }
        return dp[ind] = mmSteps;

    }

    static int solve(int n, int[] height, int k) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solveUtil(n - 1, height, dp, k);
    }

    public static void main(String args[]) {

        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int k = 2;
        System.out.println(solve(n, height, k));
    }

}
