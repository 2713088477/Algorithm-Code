package Exp1;

import java.util.Scanner;

public class Main_findByBinarySearch_D{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int target=sc.nextInt();
			int[] nums=new int[n];
			for(int i=0;i<n;i++) {
				nums[i]=sc.nextInt();
			}
			binarySearch(nums,target);
		}
		sc.close();
	}
	public static void binarySearch(int[] nums,int target) {
		int left=0,right=nums.length-1;
		while(left<=right) {
			int middle=left+(right-left)/2;
			if(nums[middle]==target) {
				System.out.println(middle+1);
				return;
			}else if(nums[middle]>target) {
				right=middle-1;
			}else {
				left=middle+1;
			}
		}
		System.out.println(0);
		
	}
}
