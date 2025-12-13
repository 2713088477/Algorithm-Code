package weeklySchool;

import java.util.Scanner;

public class day10_25QA {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t--!=0) {
			int n=sc.nextInt();
			boolean ans=true;
			int num;
			for(int i=0;i<n;i++) {
				num=sc.nextInt();
				if(num<Math.min(i+1, n-i)) {
					ans=false;
					break;
				}
			}
			if(ans) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
		}
		sc.close();
	}
}
