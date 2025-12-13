package Exp4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class MainF {
	static class Obj{
		double value;
		double weight;
		double key;//单位重量的价值
		int index;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt(),total=sc.nextInt();
			Obj[] arr=new Obj[n];
			for(int i=0;i<n;i++) {
				arr[i]=new Obj();
				arr[i].value=sc.nextDouble();
				arr[i].index=i;
			}
			for(int i=0;i<n;i++) {
				arr[i].weight=sc.nextDouble();
				arr[i].key=arr[i].value/arr[i].weight;
			}
			Arrays.sort(arr,(o1,o2)->{
				return Double.compare(o2.key, o1.key);
			});
			double maxValue=0.0;
			Map<Integer,Double> map=new HashMap<>();
			for(int i=0;i<arr.length;i++) {
				if(total-arr[i].weight>=0) {
					map.put(arr[i].index, (double) 1);
					total-=arr[i].weight;
					maxValue+=arr[i].value;
				}else {
					map.put(arr[i].index, total/arr[i].weight);
					maxValue+=(total*arr[i].key);
					total=0;
				}
			}
			
			if(Math.abs(maxValue-Math.round(maxValue))< 1e-6) {
				System.out.println((long)Math.round(maxValue));
			}else {
				System.out.printf("%.3f\n",maxValue);
			}
			
			StringJoiner sj = new StringJoiner(",","<",">");
			for(int i=0;i<n;i++) {
				double r=map.get(i);
				if(r ==(int) r) {
					sj.add(String.valueOf((int)r));
				}else {
					sj.add(String.format("%.3f",r));
				}
				
			}
			System.out.println(sj);
		}
		sc.close();
	}
}
