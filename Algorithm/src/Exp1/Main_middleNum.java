package Exp1;

import java.util.Scanner;

public class Main_middleNum {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<arr.length;i++) {
				arr[i]=sc.nextInt();
			}
			int min=arr[0],max=arr[0];
			for(int i=1;i<3;i++) {
				if(arr[i]>max) max=arr[i];
				if(arr[i]<min) min=arr[i];
			}
			int ans=0;
			for(int i=0;i<3;i++) {
				ans=arr[i];
				if(ans!=min&&ans!=max) {
					break;
				}
			}
			
			System.out.println(ans);
		}
		sc.close();
	}
}
