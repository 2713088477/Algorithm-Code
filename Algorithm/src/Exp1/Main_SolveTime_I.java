package Exp1;

import java.util.Scanner;

public class Main_SolveTime_I{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int k=0;
			for(int i=1;i<=n;i++) {
				int m=n/i;
				for(int j=1;j<=m;j++) {
					k++;
				}
			}
			System.out.println(k);
		}
		sc.close();
	}
}
