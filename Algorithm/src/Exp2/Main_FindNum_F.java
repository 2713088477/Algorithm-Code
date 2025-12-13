package Exp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_FindNum_F {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int l=sc.nextInt();
			int r=sc.nextInt();
			List<Integer> list=new ArrayList<>();
			int num=0;
			for(int i=0;i<n;i++) {
				num=sc.nextInt();
				if(num>l&&num<r) {
					list.add(num);
				}
			}
			for(int i=0;i<list.size();i++) {
				if(i==list.size()-1) {
					System.out.println(list.get(i));
				}else {
					System.out.print(list.get(i)+",");
				}
			}
		}
		sc.close();
	}

}
