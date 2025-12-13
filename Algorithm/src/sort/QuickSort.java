package sort;

import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int len=sc.nextInt();
			int[] arr=new int[len];
			for(int i=0;i<len;i++) {
				arr[i]=sc.nextInt();
			}
			quickSort(arr,0,len-1);
			for(int i=0;i<len;i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}
	public static void swap(int[] arr,int index1,int index2) {
		int temp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}
	public static void quickSort(int[] arr,int start,int end) {
		if(start<end) {
			int l=start,r=end;
			int k=arr[l];
			while(l<r) {
				while(l<r&&arr[r]>=k) {
					r--;
				}
				swap(arr,l,r);
				while(l<r&&arr[l]<k) {
					l++;
				}
				swap(arr,l,r);
			}
			quickSort(arr,start,l-1);
			quickSort(arr,l+1,end);
		}
		
	}

}
