package Exp2;

import java.util.Scanner;

public class Main_FindMaxRow1_D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int ans=0,maxNum=0;
			for(int i=0;i<n;i++) {
				int num=0;
				for(int j=0;j<n;j++) {
					if(sc.nextInt()==1) {
						num++;
					}
				}
				if(num>maxNum) {
					maxNum=num;
					ans=i;
				}
			}
			System.out.println(ans+1);
		}
		sc.close();
	}

}
