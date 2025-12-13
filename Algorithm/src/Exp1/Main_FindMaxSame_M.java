package Exp1;

import java.util.Scanner;

public class Main_FindMaxSame_M {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int num1=sc.nextInt();
			int num2=sc.nextInt();
			int ans= find(num1,num2);
			System.out.println(ans);
		}
		sc.close();
	}
	public static int find(int num1,int num2) {
		if(num1<num2) {
			int temp=num1;
			num1=num2;
			num2=temp;
		}
		while(num2!=0) {
			int temp=num2;
			num2=num1%num2;
			num1=temp;
		}
		return num1;
	}
}
