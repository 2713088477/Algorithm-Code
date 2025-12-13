package Exp4;

import java.util.Arrays;
import java.util.Scanner;

public class MainE {
	static class event{
		int time;
		int num;
		@Override
		public String toString() {
			return "time:"+this.time;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			event[] arr=new event[n];
			for(int i=0;i<n;i++) {
				arr[i] =new event();
				arr[i].time=sc.nextInt();
				arr[i].num=i+1;
			}
			Arrays.sort(arr,(e1,e2)->{
				return e1.time-e2.time;
			});
			//System.out.println(Arrays.toString(arr));
			int ans=0,curTime=0;
			int[] ansArr=new int[n];
			for(int i=0;i<arr.length;i++) {
				ans+=curTime;//记录当前等待时间
				ansArr[i]=arr[i].num;
				curTime+=arr[i].time;
			}
			System.out.println(ans);
			for(int i=0;i<ansArr.length;i++) {
				if(i!=ansArr.length-1) {
					System.out.print(ansArr[i]+",");
				}else {
					System.out.println(ansArr[i]);
				}
			}
			
		}
		sc.close();
	}
}
