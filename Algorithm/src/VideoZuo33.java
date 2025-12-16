
public class VideoZuo33 {
	public static void main(String[] args) {
		int n1=1000,n2=20;
		System.out.println(plus(n1,n2));
		System.out.println(minus(n1,n2));
		System.out.println(multiply(n1,n2));
		System.out.println(divide(n1,n2));
	}
	public static int plus(int n1,int n2) {
		int ans=0;
		while(n2!=0) {
			ans=n1^n2;
			n2=(n1&n2)<<1;
			n1=ans;
		}
		return ans;
	}
	//整数最小值会失效
	public static int reverse(int n) {
		return plus(~n,+1);
	}
	public static int minus(int n1,int n2) {
		return plus(n1,reverse(n2));
	}
	//这个乘法如果n2<0,就有问题
	public static int multiply(int n1,int n2) {
		int ans=0;
		while(n2!=0) {
			if((n2&1)==1) {
				ans=plus(ans,n1);
			}
			n1=n1<<1;
			n2=n2>>>1;
		}
		return ans;
	}
	//利用到了reverse,所以整数最小值会失效
	public static int divide(int n1,int n2) {
		int x=n1<0?reverse(n1):n1;
		int y=n2<0?reverse(n2):n2;
		int ans=0;
		for(int i=30;i>=0;i--) {
			if((x>>i)>=y) {
				ans|=(1<<i);
				x= minus(x,(y<<i));
			}
		}
		return n1<0 ^ n2<0?reverse(ans):ans;
	}
	//分类讨论Integer.MIN_VALUE
	public static int dividePlus(int n1,int n2) {
		int MIN=Integer.MIN_VALUE;
		if(n1==MIN&&n2==MIN) {
			return 1;
		}
		if(n1==MIN) {
			if(n2==1) return MIN;
			else if(n2==-1) return Integer.MAX_VALUE;//leetcode29上说的;
			else {
				n1=plus(n1,n2<0?reverse(n2):n2);
				int ans=divide(n1,n2);
				ans=plus(ans,n2<0?1:reverse(1));
				return ans;
			}
		}
		if(n2==MIN) {
			return 0;
		}
		return divide(n1,n2);
	}
	
}
