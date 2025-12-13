package dp;

import java.util.Arrays;

public class SolutionLeetCode62 {
    public int uniquePaths(int m, int n) {
        return funWithDpAndLessMemory(m,n);
    }
    //从[0,0]出发到[curX][curY]的方案
    public int tryfun(int curX,int curY) {
    	if(curX==0&&curY==0) {
    		return 1;
    	}
    	int ans=0;
    	if(curX-1>=0) {
    		ans+=tryfun(curX-1,curY);
    	}
    	if(curY-1>=0) {
    		ans+=tryfun(curX,curY-1);
    	}
    	return ans;
    }
    //严格位置依赖的动态规划
    public int funWithDp(int m,int n) {
    	int[][] dp=new int[m][n];
    	for(int i=0;i<n;i++) {
    		dp[0][i]=1;
    	}
    	for(int i=0;i<m;i++) {
    		dp[i][0]=1;
    	}
    	for(int i=1;i<m;i++) {
    		for(int j=1;j<n;j++) {
    			dp[i][j]=dp[i-1][j]+dp[i][j-1];
    		}
    	}
    	return dp[m-1][n-1];
    }
    //严格位置依赖+空间压缩
    public int funWithDpAndLessMemory(int m,int n) {
    	int[] dp=new int[n];
    	Arrays.fill(dp, 1);
    	for(int i=1;i<m;i++) {
    		for(int j=1;j<n;j++) {
    			dp[j]=dp[j-1]+dp[j];
    		}
    	}
    	return dp[n];
    }
}
