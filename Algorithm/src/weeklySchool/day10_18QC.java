package weeklySchool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day10_18QC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		List<String> list = new ArrayList();
		for(int i=0;i<n;i++) {
			list.add(String.valueOf(sc.nextInt()));
		}
		Collections.sort(list,(s1,s2)->{
			String com1=s1 + s2;
			String com2=s2 + s1;
			return com2.compareTo(com1);
		});
		StringBuilder sb = new StringBuilder();
		list.forEach(s->{
			sb.append(s);
		});
		System.out.println(sb.toString());
	}
}
