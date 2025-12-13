package Exp3;

import java.util.Arrays;
import java.util.Scanner;

public class MainE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			//f1:暴力递归
			//System.out.println(f1(arr,0,n-1)); 
			
			//f2:记忆化搜索
			int[][] dp=new int[n][n];
			for(int i=0;i<dp.length;i++) {
				Arrays.fill(dp[i], -1);
			}
			System.out.println(f2(arr,0,n-1,dp)); 
			
		}
	}
	/**
	 * 暴力递归
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public static int f1(int[] nums,int left,int right) {
		if(right-left+1<=2) {
			return 0;
		}
		int ans=Integer.MAX_VALUE;
		for(int i=left+1;i<right;i++) {
			int sum2=nums[left]*nums[i]*nums[right];
			int sum1=f1(nums,left,i);
			int sum3=f1(nums,i,right);
			ans=Math.min(ans, sum1+sum2+sum3);
		}
		return ans;
	}
	/**
	 * 记忆化搜索
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public static int f2(int[] nums,int left,int right,int[][] dp) {
		if(right-left+1<=2) {
			return 0;
		}
		if(dp[left][right]!=-1) {
			return dp[left][right];
		}
		int ans=Integer.MAX_VALUE;
		for(int i=left+1;i<right;i++) {
			int sum2=nums[left]*nums[i]*nums[right];
			int sum1=f2(nums,left,i,dp);
			int sum3=f2(nums,i,right,dp);
			ans=Math.min(ans, sum1+sum2+sum3);
		}
		dp[left][right]=ans;
		return ans;
	}
}
