package Exp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringJoiner;

public class MainB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int len1=sc.nextInt(),len2=sc.nextInt();
			sc.nextLine();
			String text1=sc.nextLine();
			String text2=sc.nextLine();
			//System.out.println("text1:"+text1);
			//System.out.println("text2:"+text2);
			findMax(text1.toCharArray(),text2.toCharArray());
		}
		sc.close();
	}
	public static void findMax(char[] nums1,char[] nums2) {
		int len1=nums1.length,len2=nums2.length;
		int[][] dp=new int[len1+1][len2+1];
		
		for(int i=1;i<=len1;i++) {
			for(int j=1;j<=len2;j++) {
				if(nums1[i-1]==nums2[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
					
				}else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[len1][len2]);
		int l1=len1,l2=len2;
		Deque<String> deque=new ArrayDeque<>();
		while(l1>0&&l2>0) {
			if(nums1[l1-1]==nums2[l2-1]) {
				deque.addFirst(String.valueOf(nums1[l1-1]));
				l1--;
				l2--;
			}else if(dp[l1-1][l2]>=dp[l1][l2-1]) {
				l1--;
			}else {
				l2--;
			}
		}
		StringJoiner sj = new StringJoiner(",","<",">");
		for(String s:deque) {
			sj.add(s);
		}
		System.out.println(sj);
	}
}
