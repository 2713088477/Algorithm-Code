package Exp1;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[10]; // 对应 C++ 中的 a[10]
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            if (a[1] < a[2]) {
                if (a[1] > a[3]) {
                    System.out.println(a[1]);
                } else {
                    System.out.println(Math.min(a[2], a[3]));
                }
            } else if (a[2] > a[3]) {
                System.out.println(a[2]);
            } else {
                System.out.println(Math.min(a[1], a[3]));
            }
        }
        scanner.close();
    }
}
