public static int longestCommoSubsequence(String A, String B, int na, int nb)
    {
        if(na ==0 || nb ==0)
            return 0;
        if(A.charAt(na-1) == B.charAt(nb-1))
            return 1+ longestCommoSubsequence( A, B, na-1, nb-1);
        else
            return Math.max(longestCommoSubsequence( A, B, na, nb-1),longestCommoSubsequence( A, B, na-1, nb));
    }
