package memonization;

//https://www.youtube.com/watch?v=tyB0ztf0DNY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=2
//memonization- top-down
//Tabulation- Bottom up-> Base case to top
//https://takeuforward.org/data-structure/dynamic-programming-introduction/


import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {

        int n = 5;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(solve(n, dp));

    }

    private static int solve(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1)
            return dp[n];

        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);

        return dp[n];
    }
}
