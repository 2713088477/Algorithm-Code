package dpDay1;

import java.util.Arrays;

public class MainLeetCode983 {
	
	
	public static int[] continueDays = {1,7,30}; 
	public static int mincostTickets(int[] days, int[] costs) {
		//1.暴力递归版本
//		return violentRecursion(days,costs,0);
		
		//2.记忆化搜索版本
//		int[] dp = new int[days.length];
//		return violentRecursionWithDp(days,costs,dp,0);
		
		//3.从已知到未知版本
		int[] dp = new int[days.length+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		return solveProblem(days,costs,dp);
		
    }
	public static int myLowerBound(int[] days,int sum) {
		//在这个方法中找到第一个数组中的值>=sum的,并且返回下标
		int left=0,right=days.length-1;
		while(left<=right) {
			int mid = left+(right-left)/2;
			if(days[mid]<sum) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return right+1;
	}
	//暴力递归
	public static int violentRecursion(int[] days,int[] costs,int curDayIndex) {
		//递归终止条件
		if(curDayIndex>=days.length) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<costs.length;i++) {
			//找到购买当前的票钱可以旅行几天(直接用二分查找)
			//找到days数组中第一个>=(curDayIndex+continueDays[i])的下标
			int nowDayIndex = myLowerBound(days,days[curDayIndex]+continueDays[i]);
			ans = Math.min(ans, violentRecursion(days,costs,nowDayIndex)+costs[i]);
		}
		return ans;
	}
	
	
	//记忆化搜索
	public static int violentRecursionWithDp(int[] days,int[] costs,int[] dp,int curDayIndex) {
		//递归终止条件
		if(curDayIndex>=days.length) {
			return 0;
		}
		if(dp[curDayIndex]!=0) {
			return dp[curDayIndex];
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<costs.length;i++) {
			//找到购买当前的票钱可以旅行几天(直接用二分查找)
			//找到days数组中第一个>=(curDayIndex+continueDays[i])的下标
			int nowDayIndex = myLowerBound(days,days[curDayIndex]+continueDays[i]);
			ans = Math.min(ans, violentRecursionWithDp(days,costs,dp,nowDayIndex)+costs[i]);
		}
		dp[curDayIndex] = ans;
		return ans;
	}
	
	//从已知到未知的动态规划
	public static int solveProblem(int[] days,int[] costs,int[] dp) {
		dp[days.length]=0;
		for(int i=days.length-1;i>=0;i--) {
			for(int j=0;j<costs.length;j++) {
				int nowDayIndex = myLowerBound(days,days[i]+continueDays[j]);
				dp[i] = Math.min(dp[i], dp[nowDayIndex]+costs[j]);
			}
		}
		return dp[0];
	}
	
	
	
}
