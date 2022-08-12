package memonization;

import java.util.Arrays;

//https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
//https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6
public class MaximumSumNonAdjacent {

    static int solveUtil(int ind, int[] arr, int[] dp){
        if(ind<0)  return 0;
        if(ind==0) return arr[ind];
        if(dp[ind]!=-1) return dp[ind];
        int pick= arr[ind]+ solveUtil(ind-2, arr,dp);
        int nonPick = 0 + solveUtil(ind-1, arr, dp);

        return dp[ind]=Math.max(pick, nonPick);
    }

    static int solve(int n,int[] arr){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solveUtil(n-1, arr, dp);
    }


    public static void main(String args[]) {

        int arr[]={2,1,4,9};
        int n=arr.length;
        System.out.println(solve(n,arr));
    }

}
