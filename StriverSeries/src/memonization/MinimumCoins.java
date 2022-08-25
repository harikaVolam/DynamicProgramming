package memonization;


//https://takeuforward.org/data-structure/minimum-coins-dp-20/
//https://www.youtube.com/watch?v=myPeWb3Y68A&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=21&t=1038s

import java.util.Arrays;

public class MinimumCoins {

    static int minimumElementsUtil(int[] arr, int ind, int T, int[][] dp){

        if(ind == 0){
            if(T%arr[0] == 0) return T/arr[0];
            else return (int)Math.pow(10,9);
        }

        if(dp[ind][T]!=-1)
            return dp[ind][T];

        int notTaken = 0 + minimumElementsUtil(arr,ind-1,T,dp);

        int taken = (int)Math.pow(10,9);
        if(arr[ind] <= T)
            taken = 1 + minimumElementsUtil(arr,ind,T-arr[ind],dp);

        return dp[ind][T] = Math.min(notTaken,taken);
    }


    static int minimumElements(int[] arr, int T){

        int n= arr.length;

        int[][] dp=new int[n][T+1];

        for(int row[]: dp)
            Arrays.fill(row,-1);

        int ans =  minimumElementsUtil(arr, n-1, T, dp);
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }

    public static void main(String args[]) {

        int arr[] ={1,2,3};
        int T=7;

        System.out.println("The minimum number of coins required to form the target sum is "+minimumElements(arr,T));
    }
}
