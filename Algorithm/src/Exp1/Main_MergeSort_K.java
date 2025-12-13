package Exp1;

import java.util.Scanner;

public class Main_MergeSort_K {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			MergeSort(arr,0,n-1);
			for(int i=0;i<n;i++) {
				if(i==n-1) {
					System.out.println(arr[i]);
				}else {
					System.out.print(arr[i]+",");
				}
			}
		}
		sc.close();
	}
	public static void Merge(int[] arr,int s,int m,int e) {
		int[] barr=new int[e-s+1];
		int p1=s,p2=m+1,p3=0;
		while(p1<=m&&p2<=e) {
			if(arr[p1]<arr[p2]) {
				barr[p3++]=arr[p1++];
			}else {
				barr[p3++]=arr[p2++];
			}
		}
		while(p1<=m) {
			barr[p3++]=arr[p1++];
		}
		while(p2<=e) {
			barr[p3++]=arr[p2++];
		}
		for(int i=0;i<barr.length;i++) {
			arr[s+i]=barr[i];
		}
	}
	public static void MergeSort(int[] arr,int s,int e) {
		if(s<e) {
			int middle=s+(e-s)/2;
			MergeSort(arr,s,middle);
			MergeSort(arr,middle+1,e);
			Merge(arr,s,middle,e);
		}
	}
}
