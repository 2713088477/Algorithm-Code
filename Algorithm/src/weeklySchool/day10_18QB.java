package weeklySchool;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class day10_18QB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int temp;
		Set<Integer> cnt=new TreeSet();
		for(int i=0;i<n;i++) {
			temp=sc.nextInt();
			cnt.add(temp);
		}
		System.out.println(cnt.size());
		cnt.forEach(ele-> System.out.print(ele+" "));
	}
}
