package Exp2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_Num_E {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			Map<Integer,Integer> cnt=new HashMap<>();
			int num=0;
			for(int i=0;i<n;i++) {
				num=sc.nextInt();
				cnt.put(num, cnt.getOrDefault(num, 0)+1);
			}
			cnt.forEach((key,value)->{
				if(value>=n/2) {
					System.out.println(key);
				}
			});
		}
		sc.close();
	}
}
