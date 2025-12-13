package Exp2;

import java.util.Scanner;

public class Main_findSingleMax_B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++) {
				if(i-1>=0&&i+1<n) {
					if(arr[i]>arr[i-1]&&arr[i]>arr[i+1]) {
						System.out.println(arr[i]);
						break;
					}
				}
			}
		}
		sc.close();
	}
}
