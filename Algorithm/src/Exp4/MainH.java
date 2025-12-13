package Exp4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainH {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt(),y=sc.nextInt();
			List<Integer> list = new ArrayList<>(n);
			for(int i=0;i<n;i++) {
				list.add(sc.nextInt());
			}
			/*
		 	//方法一
			int[] dp1=new int[y+1];
			System.out.println(countLessMoney1(y,list,dp1));
			*/
			
			//方法二
			int[] dp2=new int[y+1];
			System.out.println(countLessMoney2(y,list,dp2));
			
			
		}
		sc.close();
	}
	//方法一:从顶到底的动态规划，记忆化搜索方法
	public static int countLessMoney1(int curMoney,List<Integer> list,int[] dp) {
		if(curMoney==0) {
			return 0;
		}
		if(dp[curMoney]!=0) {
			return dp[curMoney];
		}
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<list.size();i++) {
			int money=list.get(i);
			if(curMoney-money>=0) {
				ans=Math.min(ans,countLessMoney1(curMoney-money,list,dp)+1);
			}
		}
		dp[curMoney]=ans;
		return ans;
	}
	//方法二:从低到顶，纯粹的位置依赖
	public static int countLessMoney2(int curMoney,List<Integer> list,int[] dp) {
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0]=0;
		for(int i=1;i<=curMoney;i++) {
			for(int j=0;j<list.size();j++) {
				int money=list.get(j);
				if(i-money>=0) {
					dp[i]=Math.min(dp[i], dp[i-money]+1);
				}
			}
		}
		return dp[curMoney];
	}
}
