package Exp4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainK {
	static class obj{
		int v;
		int index;
		@Override
		public String toString() {
			return "v="+v+",index="+index;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n=sc.nextInt(),c=sc.nextInt();
			obj[] arr=new obj[n];
			for(int i=0;i<n;i++) {
				arr[i]=new obj();
				arr[i].v=sc.nextInt();
				arr[i].index=i+1;
			}
			Arrays.sort(arr,(o1,o2)->{
				return o1.v-o2.v;
			});
			//System.out.println(Arrays.toString(arr));
			int ans=0;
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<n;i++) {
				if(c-arr[i].v>=0) {
					ans++;
					list.add(arr[i].index);
					c-=arr[i].v;
				}else {
					break;
				}
			}
			for(int i=0;i<list.size();i++) {
				if(i!=list.size()-1) {
					System.out.print(list.get(i)+",");
				}else {
					System.out.println(list.get(i));
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
