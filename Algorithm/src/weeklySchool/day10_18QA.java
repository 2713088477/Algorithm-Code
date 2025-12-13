package weeklySchool;

import java.util.Scanner;

public class day10_18QA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			if(sc.nextInt()==1){
				System.out.println("HARD");
				return;
			}
		}
		System.out.println("EASY");
	}
}
