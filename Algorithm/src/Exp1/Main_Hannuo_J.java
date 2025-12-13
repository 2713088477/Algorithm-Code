package Exp1;

import java.util.Scanner;

public class Main_Hannuo_J{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			hannuo(sc.nextInt(),'A','B','C');
		}
		sc.close();
	}
	public static void hannuo(int num,char start,char temp,char end) {
		if(num==1) {
			System.out.println(num+","+start+","+end);
			return;
		}
		hannuo(num-1,start,end,temp);
		System.out.println(num+","+start+","+end);
		hannuo(num-1,temp,start,end);
		
	}
}
