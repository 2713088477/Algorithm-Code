package dpDay2;

import java.util.Arrays;

public class SolutionLeetCode3693 {
    public int climbStairs(int n, int[] costs) {
//        return f1(0,n,costs);
//    	int[] dp = new int[n+1];
//    	return f2(0,n,costs,dp);
    	
    	int[] dp = new int[n+1];
    	Arrays.fill(dp,Integer.MAX_VALUE);
    	return f3(dp,n,costs);
    }
    static int[] steps= {1,2,3};
//    //这个函数的定义:从cur位置出发，爬完整个楼梯的最小成本
//    public int f1(int cur,int n,int[] costs) {
//    	if(cur==n) {
//    		return 0;
//    	}
//    	int ans=Integer.MAX_VALUE;
//    	for(int i=0;i<3;i++) {
//    		int newPos=cur+steps[i];
//    		if(newPos<=n){
//    			//ans=costs[newPos]+(newPos-cur)*(newPos-cur)+f1(newPos,n,costs);
//    			ans=Math.min(ans, costs[newPos-1]+(newPos-cur)*(newPos-cur)+f1(newPos,n,costs));
//    		}	
//    	}
//    	return ans;
//    }
    
//    public int f2(int cur,int n,int[] costs,int[] dp) {
//    	if(cur==n) return dp[cur];
//    	if(dp[cur]!=0) return dp[cur];
//    	int ans=Integer.MAX_VALUE;
//    	for(int i=0;i<3;i++) {
//    		int newPos = cur+steps[i];
//    		if(newPos<=n) {
//    			ans=Math.min(ans, costs[newPos-1]+(newPos-cur)*(newPos-cur)+f2(newPos,n,costs,dp));
//    		}
//    	}
//    	dp[cur]=ans;
//    	return ans;
//    }
    
    public int f3(int[] dp,int n,int[] costs) {
    	dp[n]=0;
    	for(int cur=n-1;cur>=0;cur--) {
    		//每一步都有三种尝试策略
    		for(int i=0;i<3;i++) {
    			int newPos=cur+steps[i];
    			if(newPos<=n) {
    				dp[cur]=Math.min(dp[cur], costs[newPos-1]+(newPos-cur)*(newPos-cur)+dp[newPos]);
    			}
    		}
    	}
    	return dp[0];
    	
    }

}
