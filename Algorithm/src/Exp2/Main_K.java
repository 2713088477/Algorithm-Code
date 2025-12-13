package Exp2;

import java.util.Arrays;
import java.util.Scanner;

public class Main_K {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++) {
				if(arr[i]<0) {
					reverse(arr,0,i-1);
					reverse(arr,0,i);
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		
		
	}
	public static void reverse(int[] arr,int left,int right) {
		while(left<right) {
			int temp=arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
			left++;
			right--;
		}
	}

}
