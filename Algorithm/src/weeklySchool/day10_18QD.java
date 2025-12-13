package weeklySchool;

import java.util.Scanner;

public class day10_18QD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if(s==null||s=="") {
			System.out.println("No Answer");
			System.out.println(0);
			return;
		}
		int[] cnt=new int[26];
		for(char x:s.toCharArray()) {
			cnt[x-'a']++;
			
		}
		int max=1,min=s.length();
		for(int x:cnt) {
			if(x>0) {
				if(x>max) max=x;
				if(x<min) min=x;
			}
		}
		//System.out.println(max+" "+min);
		if(isPrim(max-min)) {
			 System.out.println("Lucky Word");
			 System.out.println(max-min);
		}else {
			System.out.println("No Answer");
			System.out.println(0);
		}
	}
	public static boolean isPrim(int num) {
		if(num==0||num==1) return false;
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) return false;
		}
		return true;
//		boolean[] arr=new boolean[101];
//		Arrays.fill(arr, true);
//		arr[0]=false;
//		arr[1]=false;
//		for(int i=2;i<arr.length;i++) {
//			for(int j=2;i*j<arr.length;j++) {
//				arr[i*j]=false;
//			}
//		}
//		return arr[num];
	}
}
