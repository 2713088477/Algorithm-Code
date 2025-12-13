package VideoZuo31;

public class Near2Power {
	
	public static void main(String[] args) {
		int len=Integer.MAX_VALUE/2;
		int n=(int)(Math.random()*(len+1));
		System.out.println("测试开始");
		for(int i=0;i<10;i++) {
			if(getAns(n)!=Near2Power(n)) {
				System.out.println("测试失败");
			}
		}
		
		System.out.println("测试完成");
	}
	public static int getAns(int n) {
		long start= System.currentTimeMillis();
		int ans=1;
		while(ans<n) {
			ans*=2;
		}
		long end=System.currentTimeMillis();
		System.out.println("对于"+n+" while循环花费了"+(end-start)+"ms");
		return ans;
	}
	public static void printBinary(int n) {
		System.out.println(n);
		for(int i=31;i>=0;i--) {
			System.out.print((n&(1<<i))==0?0:1);
		}
		System.out.println();
	}
	public static int Near2Power(int n) {
		long start= System.currentTimeMillis();
		n--;
		n |= n>>>1;
		n |= n>>>2;
		n |= n>>>4;
		n |= n>>>8;
		n |= n>>>16;
		long end=System.currentTimeMillis();
		System.out.println("对于"+n+" 位运算"+(end-start)/1000+"ms");
		return n+1;
	}
}
