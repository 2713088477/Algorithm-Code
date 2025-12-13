package dpDay1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

public class demo1 {
	
	public static void main(String[] args) {
		System.out.println("你好!!!");
		//f(0)=0,f(1)=1  计算f(10);
		
		Arrays.fill(dp, -1);
		LocalTime start2 = LocalTime.now();	
		System.out.println(fi2(30));
		LocalTime end2 = LocalTime.now();	
		Duration dt2 =Duration.between(start2, end2);
		System.out.println(dt2.getNano()+"s");
		
		LocalTime start1 = LocalTime.now();	
		System.out.println(fi1(30));
		LocalTime end1 = LocalTime.now();	
		Duration dt1 =Duration.between(start1, end1);
		System.out.println(dt1.getNano()+"s");
		
	}
	public static int fi1(int num) {
		if(num==0) return 0;
		if(num==1) return 1;
		return fi1(num-1)+fi1(num-2);
	}
	//维护一个成员变量记录结果
	static int[] dp = new int[50];
	//这里输入一个少于50的数字
	public static int fi2(int num) {
		if(dp[num]==-1) {
			if(num==0) dp[0]=0;
			else if(num==1) dp[1]=1;
			else dp[num] = fi2(num-1)+fi2(num-2);
		}
		return dp[num];
	}
	
}
