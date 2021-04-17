/*
* Target Sum Problem
* Given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
*
* Find out how many ways to assign symbols to make sum of integers equal to target S.
*
* Example 1:
* Input: nums is [1, 1, 1, 1, 1], S is 3. 
* Output: 5
* Explanation: 
*
* -1+1+1+1+1 = 3
* +1-1+1+1+1 = 3
* +1+1-1+1+1 = 3
* +1+1+1-1+1 = 3
* +1+1+1+1-1 = 3
*
* There are 5 ways to assign symbols to make the sum of nums be target 3.
*/

public static int targetSum(int []arr, int target)
    {
        return countOfSubsetWithGivenDiff(arr,target);
    }

    private static int countOfSubsetWithGivenDiff(int []arr, int diff)
    {
        int sum=0;
        for(int x: arr)
            sum += x;
        int sumNeeded = (sum+diff)/2;
        return countOfSubsetWithGivenSum(arr, sumNeeded);
    }

    private static int countOfSubsetWithGivenSum(int []arr, int sum)
    {
        int row = arr.length+1;
        int col=sum+1;
        int [][]dp = new int[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i==0 && j==0)
                    dp[i][j] = 1;
                else if(i==0)
                    dp[i][j] =0;
                else if(j==0)
                    dp[i][j]=1;
                else
                {
                    if(arr[i-1]<=j)
                    {
                        dp[i][j]= dp[i-1][j] + dp[i-1][j-arr[i-1]];
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][1];
                    }
                }
            }
        }
        return dp[row-1][col-1];
    }
