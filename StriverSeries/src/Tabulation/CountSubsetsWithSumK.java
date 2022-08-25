package Tabulation;

public class CountSubsetsWithSumK {

    static int findWays(int[] num, int k){
        int n = num.length;

        int[][] dp=new int[n][k+1];

        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }

        if(num[0]<=k)
            dp[0][num[0]] = 1;

        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){

                int notTaken = dp[ind-1][target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = dp[ind-1][target-num[ind]];

                dp[ind][target]= notTaken + taken;
            }
        }

        return dp[n-1][k];


    }

    public static void main(String args[]) {

        int arr[] = {1,2,2,3};
        int k=3;

        System.out.println("The number of subsets found are "+findWays(arr,k));
    }
}
