package VideoZuo30;

import java.util.Arrays;

public class Main30 {
	public static void main(String[] args) {
		int a=10,b=-10;
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println(a+" "+b); //-10 10
		
		int[] arr=new int[]{10,9,8,7,6,5};
		swap(arr,0,1);
		System.out.println(Arrays.toString(arr));  //[9, 10, 8, 7, 6, 5]
		swap(arr,0,0);
		System.out.println(Arrays.toString(arr));  //[0, 10, 8, 7, 6, 5] 出错了
	}
	//打印一个整形的二进制
	public static void printBinary(int num) {
		for(int i=31;i>=0;i--) {
			System.out.print((num&(1<<i)) == 0 ? 0:1);
		}
		System.out.println();
	}
	
	public static void swap(int[] arr,int i,int j) {
		if(i==j) return;
		arr[i]=arr[i]^arr[j];
		arr[j]=arr[i]^arr[j];
		arr[i]=arr[i]^arr[j];
	}
	

}
