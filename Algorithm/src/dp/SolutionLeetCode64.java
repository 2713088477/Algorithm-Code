package dp;

public class SolutionLeetCode64 {
	private int xLen,yLen;
    public int minPathSum(int[][] grid) {
        xLen=grid.length;
        yLen=grid[0].length;
        //return f1(grid,xLen-1,yLen-1);
        return f3(grid);
    }
    //这个函数表示从[0,0]到curX,curY的最小数字和
    public int f1(int[][] grid,int curX,int curY) {
    	if(curX==0&&curY==0) {
    		return grid[curX][curY];
    	}
    	int ans=Integer.MAX_VALUE;
    	if(curX-1>=0) {
    		ans=Math.min(ans, f1(grid,curX-1,curY)+grid[curX][curY]);
    	}
    	if(curY-1>=0) {
    		ans=Math.min(ans, f1(grid,curX,curY-1)+grid[curX][curY]);
    	}
    	return ans;
    }
    //纯粹的位置依赖
    public int f2(int[][] grid) {
    	int[][] dp=new int[xLen][yLen];
    	dp[0][0]=grid[0][0];
    	for(int i=1;i<yLen;i++) {
    		dp[0][i]=dp[0][i-1]+grid[0][i];
    	}
    	for(int i=1;i<xLen;i++) {
    		dp[i][0]=dp[i-1][0]+grid[i][0];
    	}
    	for(int i=1;i<xLen;i++) {
    		for(int j=1;j<yLen;j++) {
    			dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
    		}
    	}
    	return dp[xLen-1][yLen-1];
    }
    //纯粹位置依赖+空间压缩
    public int f3(int[][] grid) {
    	int[] dp=new int[yLen];
    	dp[0]=grid[0][0];
    	for(int i=1;i<yLen;i++) {
    		dp[i]=dp[i-1]+grid[0][i];
    	}
    	for(int i=1;i<xLen;i++) {
    		for(int j=0;j<yLen;j++) {
    			if(j==0) {
    				dp[j]=dp[j]+grid[i][j];
    			}else {
    				dp[j]=Math.min(dp[j-1], dp[j])+grid[i][j];
    			}
    		}
    	}
    	return dp[yLen-1];
    }
    
}
