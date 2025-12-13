package dp;

public class SolutionLeetCode99 {
	private static int row,col;
    public static int minPathSum(int[][] grid) {
    	row=grid.length;
    	col=grid[0].length;
    	
    	//记忆化搜索
    	//int[][] dp=new int[row][col];
    	//for(int i=0;i<row;i++) {
    	//	Arrays.fill(dp[i], -1);
    	//}
    	//return findMinPath1(grid,0,0,dp);
    	
    	//严格位置依赖
    	//int[][] dp=new int[row][col];
    	//return findMinPath2(grid,dp);
    	
    	return findMinPath3(grid);
    }
    //记忆化搜索:从当前[curX,curY]到row和col的最短路径 向右代表X的正方向,向下表示y的正方向
    public static int findMinPath1(int[][] grid,int curX,int curY,int[][] dp) {
    	if(dp[curY][curX]!=-1) {
    		return dp[curY][curX];
    	}
    	if(curX==col-1&&curY==row-1) {
    		return grid[curY][curX];
    	}
    	int ans=Integer.MAX_VALUE;
    	if(curX+1<col) {
    		ans=Math.min(ans, findMinPath1(grid,curX+1,curY,dp)+grid[curY][curX]);
    	}
    	if(curY+1<row) {
    		ans=Math.min(ans, findMinPath1(grid,curX,curY+1,dp)+grid[curY][curX]);
    	}
    	dp[curY][curX]=ans;
    	return ans;
    }
    //严格位置依赖:
    public static int findMinPath2(int[][] grid,int[][] dp) {
    	dp[row-1][col-1]=grid[row-1][col-1];
    	//最后一行的数据
    	for(int c=col-1;c>=0;c--) {
    		dp[row-1][c]=dp[row-1][c+1]+grid[row-1][c];
    	}
    	//最后一列的数据
    	for(int r=row-1;r>=0;r--) {
    		dp[r][col-1]=dp[r+1][col-1]+grid[r][col-1];
    	}
    	for(int r=row-1;r>=0;r--) {
    		for(int c=col-1;c>=0;c--) {
    			dp[r][c]=Math.min(dp[r+1][c], dp[r][c+1])+grid[r][c];
    		}
    	}
    	return dp[0][0];	
    }
    //严格位置依赖(压缩空间版)
    public static int findMinPath3(int[][] grid) {
    	int[] dp = new int[col];
    	dp[col-1]=grid[row-1][col-1];
    	for(int c=col-2;c>=0;c--) {
    		dp[c]=dp[c+1]+grid[row-1][c];
    	}
    	for(int r=row-2;r>=0;r--) {
    		for(int c=col-1;c>=0;c--) {
    			if(c+1<col) {
    				dp[c]=Math.min(dp[c+1], dp[c])+grid[r][c];
    			}else {
    				dp[c]=dp[c]+grid[r][c];
    			}
    		}
    	}
    	return dp[0];
    }
}
