package Exp5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main_FindChild_B {
	private static int len;
	private static int target;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			len=sc.nextInt();
			target=sc.nextInt();
			int[] arr=new int[len];
			for(int i=0;i<len;i++) {
				arr[i]=sc.nextInt();
			}
			List<int[]> list=new ArrayList<>();
			int[] t = new int[len];
			
			findChilden(0,0,arr,t,list);
			for(int[] l:list) {
				StringJoiner sj=new StringJoiner(",","<",">");
				for(int x:l) {
					sj.add(String.valueOf(x));
				}
				System.out.println(sj);
			}
		}
	}
	public static void findChilden(int index,int sum,int[] arr,int[] t,List<int[]> list) {
		if(index==arr.length) {
			if(sum==target) {
				list.add(Arrays.copyOf(t, t.length));
			}
			return;
		}
		if(sum>target) return;
		if(sum+arr[index]<=target) {
			t[index]=1;
			findChilden(index+1,sum+arr[index],arr,t,list);
			t[index]=0;
		}
		findChilden(index+1,sum,arr,t,list);
	}
	

}
