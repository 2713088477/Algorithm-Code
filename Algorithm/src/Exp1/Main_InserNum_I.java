package Exp1;

import java.util.Scanner;

public class Main_InserNum_I {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int m=sc.nextInt(),n=sc.nextInt();
			if(m==0&&n==0) {
				break;
			}
			int[] arr=new int[m+1];
			for(int i=0;i<m;i++) {
				arr[i]=sc.nextInt();
			}
			if(n>arr[m-1]) {
				arr[m]=n;
			}else {
				for(int i=0;i<m;i++) {
					if(n<=arr[i]) {
						int index=i;
						int last=m;
						while(last>index) {
							arr[last]=arr[last-1];
							last--;
						}
						arr[index]=n;
						break;
					}
				}
			}
			
			for(int i=0;i<arr.length;i++) {
				if(i==arr.length-1) {
					System.out.println(arr[i]);
				}else {
					System.out.print(arr[i]+",");
				}
			}
		}
		sc.close();
	}
}
