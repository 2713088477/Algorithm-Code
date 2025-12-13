package dpDay1;

import java.util.Arrays;

public class demo4 {
	
    public static int mincostTickets(int[] days, int[] costs) {
    	
//    	//第二种方法的代码
//    	int[] dp = new int[days.length+1];
//      return minCost2(days,costs,0,dp);
    	//第三种方法
    	return minCost3(days,costs);
    }
    
    static int[] arr= {1,7,30};
    
    //1.暴力尝试(从顶到底)
    public static int minCost1(int[] days,int[] costs,int curIndex) {
    	if(curIndex==days.length) {
    		return 0;
    	}
    	int ans = Integer.MAX_VALUE;
    	for(int i=0;i<costs.length;i++) {
    		int k=curIndex;
    		while(k<days.length&&days[curIndex]+arr[i]>days[k]) {
    			k++;
    		}
    		ans=Math.min(ans, costs[i]+minCost1(days,costs,k));
    	}
    	return ans;
    }
    //2.挂一个缓存表(从顶到底)
    public static int minCost2(int[] days,int[] costs,int curIndex,int[] dp) {
    	if(curIndex==days.length) {
    		return dp[curIndex];
    	}
    	if(dp[curIndex]!=0) {
    		return dp[curIndex];
    	}
    	int ans = Integer.MAX_VALUE;
    	for(int i=0;i<costs.length;i++) {
    		int k=curIndex;
    		while(k<days.length&&days[curIndex]+arr[i]>days[k]) {
    			k++;
    		}
    		ans=Math.min(ans, costs[i]+minCost2(days,costs,k,dp));
    	}
    	dp[curIndex]=ans;
    	return ans;
    }
    //3.状态转移方程,从低到顶
    public static int minCost3(int[] days,int[] costs) {
    	int[] dp = new int[days.length+1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[days.length]=0;
    	for(int curIndex=days.length-1;curIndex>=0;curIndex--) {
    		//这里面的代码和递归差不多，只不过不用递归求值，用dp[k]求值
    		for(int j=0;j<costs.length;j++) {
    			int k=curIndex;
    			while(k<days.length&&days[curIndex]+arr[j]>days[k]) k++;
    			dp[curIndex]=Math.min(dp[curIndex], dp[k]+costs[j]);
    		}
    	}
    	return dp[0];
    }
}
