package Exp1;

import java.util.Scanner;

public class Main_Num_2_H {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=0;i<arr.length;i++) {
				if(arr[i]%2!=0) {
					arr[i]*=2;
				}
			}
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
}
