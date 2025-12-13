package Exp4;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main_countAreaNum {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()) {
			int len=sc.nextInt();
			Deque<Integer> deque = new ArrayDeque<>();
			for(int i=0;i<len;i++) {
				int num=sc.nextInt();
				if(deque.isEmpty() || num-deque.getLast()>1) {
					deque.addLast(num);;
				}
			}
			System.out.println(deque.size());
			StringJoiner sj=new StringJoiner(",");
			while(!deque.isEmpty()) {
				int s= deque.removeFirst();
				sj.add("["+s+","+(s+1)+"]");
			}
			System.out.println(sj);
		}
		sc.close();
	}
}
