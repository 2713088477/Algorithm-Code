package Exp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int[] nums=new int[n];
			for(int i=0;i<n;i++) {
				nums[i]=sc.nextInt();
			}
			f1(nums);
		}
		sc.close();
	}
	public static void f1(int[] nums) {
		int len=nums.length;
		//dp[i]表示以i下标结尾的最长递增子序列的个数
		int[] dp=new int[len];
		//pre[i]=j //记录pre之前的那个数字
		int[] pre=new int[len];
		Arrays.fill(dp, 1);
		Arrays.fill(pre, -1);
		for(int i=1;i<len;i++) {
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]) {
					if(dp[j]+1>dp[i]) {
						dp[i]=dp[j]+1;
						pre[i]=j;
					}
				}
			}
		}
		int maxLen=1;
		for(int x:dp) {
			maxLen=Math.max(maxLen, x);
		}
		int index=-1;
		for(int i=0;i<len;i++) {
			if(dp[i]==maxLen) {
				index=i;
				break;
			}
		}
		List<Integer> list=new ArrayList<>();
		while(pre[index]!=-1) {
			list.add(nums[index]);
			index=pre[index];
		}
		list.add(nums[index]);
		for(int i=list.size()-1;i>=0;i--) {
			if(i==0) {
				System.out.println(list.get(i));
			}else {
				System.out.print(list.get(i)+",");
			}
		}
		System.out.println(maxLen);
		
        
	}
	
	
	
}
