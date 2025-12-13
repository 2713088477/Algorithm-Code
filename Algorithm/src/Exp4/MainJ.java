package Exp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainJ {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			List<Integer> ans=new ArrayList<>();
			int res=arr[0]+4;
			ans.add(res);
			for(int i=0;i<n;i++) {
				if(Math.abs(res-arr[i])<=4) {
					continue;
				}
				res=arr[i]+4;
				ans.add(res);
			}
			for(int i=0;i<ans.size();i++) {
				if(i==ans.size()-1) {
					System.out.println(ans.get(i));
				}else {
					System.out.print(ans.get(i)+",");
				}
			}
		}
		sc.close();
	}
}
