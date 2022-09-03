package memonization;


import java.util.Arrays;

//https://takeuforward.org/data-structure/longest-common-subsequence-dp-25/
//https://www.youtube.com/watch?v=NPZn9jBrX8U&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=26&t=1401s

//Print the longest common subsequence
//https://www.youtube.com/watch?v=-zI4mrF2Pb4&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=27&t=291s
public class LCS {

    static int lcsUtil(String s1, String s2, int ind1, int ind2, int[][] dp){

        if(ind1<0 || ind2<0)
            return 0;

        if(dp[ind1][ind2]!=-1)
            return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2] = 1 + lcsUtil(s1,s2,ind1-1,ind2-1,dp);

        else
            return dp[ind1][ind2] = 0 + Math.max(lcsUtil(s1,s2,ind1,ind2-1,dp),
                    lcsUtil(s1,s2,ind1-1,ind2,dp));

    }


    static int lcs(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n][m];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);
        return lcsUtil(s1,s2,n-1,m-1,dp);
    }

    public static void main(String args[]) {

        String s1= "acd";
        String s2= "ced";

        System.out.println("The Length of Longest Common Subsequence is "+lcs(s1,s2));
    }
}
