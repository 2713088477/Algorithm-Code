package Exp4;

import java.util.Arrays;
import java.util.Scanner;

public class MainG {
	static class Event implements Comparable<Event>{
		int startTime;
		int endTime;
		
		@Override
		public int compareTo(Event e2) {
			if(this.startTime==e2.startTime) {
				return this.endTime-e2.endTime;
			}
			return this.startTime-e2.startTime;
		}
		@Override
		public String toString() {
			return "startTime="+this.startTime+",endTime="+this.endTime;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			Event[] arr=new Event[n];
			for(int i=0;i<n;i++) {
				arr[i]=new Event();
				arr[i].startTime=sc.nextInt();
				arr[i].endTime=sc.nextInt();
			}
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			int[] dp=new int[n];
			dp[n-1]=1;
			findMaxEvent(arr,1,dp);
			int ans=1;
			for(int i=0;i<dp.length;i++) {
				if(ans<dp[i]) {
					ans=dp[i];
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
	//这个函数表示选了cur活动之后，可以举办的最大活动数
	public static int findMaxEvent(Event[] arr,int cur,int[] dp) {
		if(dp[cur]!=0) {
			return dp[cur];
		}
		if(cur==arr.length-1) {
			return 1;
		}
		int ans=1;
		int curEndTime=arr[cur].endTime;
		for(int i=cur+1;i<arr.length;i++) {
			if(arr[i].startTime>=curEndTime) {
				ans=Math.max(ans, findMaxEvent(arr,i,dp)+1);
			}
		}
		dp[cur]=ans;
		return ans;
	}
}
