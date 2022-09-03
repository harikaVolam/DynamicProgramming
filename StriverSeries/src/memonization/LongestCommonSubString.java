package memonization;

// Returns length of function
// for longest common
// substring of X[0..m-1] and Y[0..n-1]

class LongestCommonSubString {

    static String X, Y;

    static int lcs(int i, int j)
    {

        if (i == 0 || j == 0)
        {
            return 0;
        }

        int count =0;

        if (X.charAt(i - 1)
                == Y.charAt(j - 1))
        {
            count = 1+lcs(i - 1, j - 1);
        }
        count = Math.max(count,
                Math.max(lcs(i, j - 1),
                        lcs(i - 1, j)));
        return count;
    }

    // Driver code
    public static void main(String[] args)
    {
        int n, m;
        X = "abcdxyz";
        Y = "xyzabcf";

        n = X.length();
        m = Y.length();

        System.out.println(lcs(n, m));
    }
}