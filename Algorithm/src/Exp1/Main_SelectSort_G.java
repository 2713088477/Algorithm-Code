package Exp1;

import java.util.Scanner;


public class Main_SelectSort_G {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			selectSort(arr);
			for(int i=0;i<n;i++) {
				if(i==n-1) {
					System.out.println(arr[i]);
				}else {
					System.out.print(arr[i]+",");
				}
			}
			
		}
	}
	public static void selectSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					arr[i]=arr[i]^arr[j];
					arr[j]=arr[i]^arr[j];
					arr[i]=arr[j]^arr[i];
				}
			}
		}
	}
}
