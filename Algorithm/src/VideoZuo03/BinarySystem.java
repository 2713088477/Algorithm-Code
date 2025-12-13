package VideoZuo03;

public class BinarySystem {
	/**
	 * 打印全部二进制位数
	 * @param num
	 */
	public static void printBinary(int num) {
		for(int i=31;i>=0;i--) {
			System.out.print(((num&(1<<i)) == 0)?0:1);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int num=-10;
		printBinary(num);
		printBinary(num >> 1);
		printBinary(num >>> 1);
		System.out.println(~Integer.MIN_VALUE+1); //-2147483648
		int test1 = Integer.MIN_VALUE;
		System.out.println(-test1);
	}
	/**
	 * 打印有效的二进制位
	 * 
	 */
	public static void printValidBinary(int num) {
		if(num==0) {
			System.out.println(0);
		}
		for(int i=31;i>=0;i--) {
			if((num&(1<<i))==0 ) {
				continue;
			}else {
				for(int j=i;j>=0;j--) {
					System.out.print((num&(1<<j))==0?0:1);
				}
				System.out.println();
				break;
			}
		}
	}
}
