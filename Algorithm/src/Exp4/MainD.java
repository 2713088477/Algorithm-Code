package Exp4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainD {
	static class Obj{
		int l;
		int index;
		@Override
		public String toString() {
			return "l:"+l;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int L=sc.nextInt();
			Obj[] arr=new Obj[n];
			for(int i=0;i<n;i++) {
				arr[i]=new Obj();
				arr[i].l=sc.nextInt();
				arr[i].index=i+1;
			}
			Arrays.sort(arr,(o1,o2)->{
				return o1.l-o2.l;
			});
			//System.out.println(Arrays.toString(arr));
			int ans=0;
			List<Integer> ansArr=new ArrayList<>();
			for(int i=0;i<arr.length;i++) {
				if(L-arr[i].l>=0) {
					ans++;
					ansArr.add(arr[i].index);
					L-=arr[i].l;
				}else {
					break;
				}
			}
			System.out.println(ans);
			for(int i=0;i<ansArr.size();i++) {
				if(i==ansArr.size()-1) {
					System.out.println(ansArr.get(i));
				}else {
					System.out.print(ansArr.get(i)+",");
				}
			}
		}
		sc.close();
		
	}
}
