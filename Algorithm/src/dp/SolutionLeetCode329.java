package dp;

public class SolutionLeetCode329 {
    public int longestIncreasingPath(int[][] matrix) {
    	int ans=0;
    	int m=matrix.length,n=matrix[0].length;
    	int[][] dp = new int[m][n];
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			ans=Math.max(ans, findMaxByMemory(matrix,i,j,dp));
    		}
    	}
    	return ans;
    }
    public static int findMaxByMemory(int[][] matrix ,int curX,int curY,int[][] dp) {
    	int ans=0;
    	if(dp[curX][curY]!=0) {
    		return dp[curX][curY];
    	}
    	if(curX-1>=0 && matrix[curX-1][curY]>matrix[curX][curY]) {
    		ans=Math.max(ans, findMaxByMemory(matrix,curX-1,curY,dp));
    	}
    	if(curX+1<matrix[0].length && matrix[curX+1][curY]>matrix[curX][curY]) {
    		ans=Math.max(ans, findMaxByMemory(matrix,curX+1,curY,dp));
    	}
    	if(curY-1>=0 && matrix[curX][curY-1]>matrix[curX][curY]) {
    		ans=Math.max(ans, findMaxByMemory(matrix,curX,curY-1,dp));
    	}
    	if(curY+1<matrix[0].length && matrix[curX][curY+1]>matrix[curX][curY]) {
    		ans=Math.max(ans, findMaxByMemory(matrix,curX,curY+1,dp));
    	}
    	dp[curX][curY]=ans+1;
    	return ans+1;
    		
    }
}
