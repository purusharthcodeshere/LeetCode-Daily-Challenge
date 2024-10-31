class Solution {
    //Dynamic Approach
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
    Collections.sort(robot); 
    Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

    ArrayList<Integer> factoryPos = new ArrayList<>();
    for(int d[] : factory)
    for(int i=0; i<d[1]; i++)
    factoryPos.add(d[0]);
    
    int m = robot.size(), n = factoryPos.size();
    long dp[][] = new long[m+1][n+1];
   
    for(int i=0; i<m; i++)
    dp[i][n] = (long) 1e12;
    
    for(int i=m-1; i>=0; i--)
    for(int j=n-1; j>=0; j--)
    {
    long pick = Math.abs(robot.get(i)-factoryPos.get(j)) + dp[i+1][j+1];
    long notPick = dp[i][j+1];
    dp[i][j] = Math.min(pick, notPick);
    }
    return dp[0][0];
    }

//Recursion with memoization 
    public long memo(int robIndex, int facIndex, List<Integer> robot, ArrayList<Integer> factoryPos, long [][]dp)
    {
      if(robIndex>=robot.size())
      return 0;
      if(facIndex>=factoryPos.size())
      return (long)1e12;

      if(dp[robIndex][facIndex]!=-1)
      return dp[robIndex][facIndex];
    
      long pick = Math.abs(robot.get(robIndex)-factoryPos.get(facIndex)) + memo(robIndex+1, facIndex+1, robot, factoryPos, dp);

    long notPick = memo(robIndex, facIndex+1, robot, factoryPos, dp);
    return dp[robIndex][facIndex] = Math.min(pick, notPick);

    }
}