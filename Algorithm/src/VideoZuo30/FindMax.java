package VideoZuo30;


public class FindMax {
	public static int getRand(int len) {
		return (int)Math.random()*(len+1);
	}
	public static void main(String[] args) {
		int len=Integer.MAX_VALUE;
		int test=2000;
		System.out.println("开始测试");
		for(int i=0;i<test;i++) {
			int a=getRand(len);
			int b=getRand(len);
			int ans1=findMaxAns(a,b);
			int ans2=Math.max(a, b);
			if(ans1!=ans2) {
				System.out.println("测试失败");
			}
		}
		System.out.println("测试完成");
	}
	public static int convert(int num) {
		return num^1;
	}
	//如果num为负数返回0，非负返回1
	public static int sign(int num) {
		return convert((num>>>31 & 1));
	}
	
	//这个函数基本上可以，但是有瑕疵
	public static int findMax(int a,int b) {
		int c=a-b; //a-b可能溢出
		int returnA=sign(c);
		int returnB=convert(returnA);
		return returnA*a+returnB*b;
	}
	public static int findMaxAns(int a,int b) {
		int c=a-b;
		int A=sign(a);
		int B=sign(b);
		int C=sign(c);
		//返回A的条件,a^b==1且A==1 或者 a^b==0 C==1
		int AB=A^B;
		int returnA=(AB&A)+(AB|C);
		int returnB=convert(returnA);
		
		return returnA*a+returnB*b;
	}
}
