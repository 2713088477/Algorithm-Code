package Exp2;

import java.util.Scanner;

public class Main_InsertSort_A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			insertSort(arr);
			for(int i=0;i<arr.length;i++) {
				if(i==arr.length-1) {
					System.out.println(arr[i]);
				}else {
					System.out.print(arr[i]+",");
				}
			}
			
		}
	}
	public static int myBound(int[] arr,int left,int right,int target) {
		while(left<=right) {
			int middle=left+(right-left)/2;
			if(arr[middle]<target) {
				left=middle+1;
			}else {
				right=middle-1;
			}
		}
		return left;
	}
	public static void insertSort(int[] arr) {
		int len=arr.length;
		int num,index;
		for(int i=1;i<len;i++) {
			//查找arr[0,i-1]中第一个>=arr[i]的位置
			num=arr[i];
			index=myBound(arr,0,i-1,num);
			if(index==i) {
				arr[index]=num;
			}else {
				for(int j=i-1;j>=index;j--) {
					arr[j+1]=arr[j];
				}
				arr[index]=num;
			}
		}
	}
}
