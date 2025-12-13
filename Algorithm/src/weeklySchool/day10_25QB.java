package weeklySchool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;

public class day10_25QB {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] nums=new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		sc.nextLine();
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
		LocalDateTime start=LocalDateTime.parse(str1,formatter);
		LocalDateTime end=LocalDateTime.parse(str2,formatter);
		long minutes=ChronoUnit.MINUTES.between(start,end);
		
		Arrays.sort(nums);
		int ans=0;
		for(int i=0;i<nums.length;i++) {
			if(minutes-nums[i]>=0) {
				ans++;
				minutes-=nums[i];
			}else {
				break;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
